package com.boco.modules.fdoc.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.enums.ApiStatusEnum;
import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.JsonUtils;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class AppraisalUserController {
	
	@Resource
	DocService docService;
	@Resource
	DocUserService docUserService;

	@RequestMapping(value = "/docLogin")
	@ResponseBody
	public String login(HttpServletRequest request, Model model) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		DoctorUserEntity userEntity = new DoctorUserEntity(userName, password);

		// 登录验证
		DoctorUserEntity verifyUser = docUserService.verifyUser(userEntity);
		if (verifyUser == null) {
			// 若没有查询到该对象，返回用户名或密码错误
			return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.DOC_LOGIN_ERROR.getKey(),
					ApiStatusEnum.DOC_LOGIN_ERROR.getValue()));
		} else {
			DoctorDetailVo doctorInfo = docService.getDoctorInfo(verifyUser
					.getDoctorId());
			if (doctorInfo == null) {
				return JsonUtils.getJson(BaseJsonVo.empty(
						ApiStatusEnum.NO_SUCH_DOCTOR.getKey(),
						ApiStatusEnum.NO_SUCH_DOCTOR.getValue()));
			}
			doctorInfo.setProductCode(verifyUser.getProductCode());
			// 把用户登录数据存入MAP
			Map<String, String> returnDataMap = new HashMap<String, String>();
			returnDataMap.put("userName", userName);
			returnDataMap.put("password", password);
			returnDataMap.put("img", verifyUser.getImg());
			returnDataMap.put("nickName", verifyUser.getNickName());
			returnDataMap.put("doctorId", doctorInfo.getId());
			returnDataMap.put("docName", doctorInfo.getDocName());
			returnDataMap.put("sex", doctorInfo.getSex());
			returnDataMap.put("deptName", doctorInfo.getDeptName());
			returnDataMap.put("orgId", doctorInfo.getOrgId());
			returnDataMap.put("orgName", doctorInfo.getOrgName());
			returnDataMap.put("regionCode", doctorInfo.getRegionCode());
			returnDataMap.put("teamId", doctorInfo.getTeamId());
			returnDataMap.put("docType", doctorInfo.getDocType());
			returnDataMap.put("productCode", doctorInfo.getProductCode());
			// 将登陆用户写入session
			request.getSession().setAttribute("doc_session", returnDataMap);
			request.getSession().setAttribute("doctorInfo", doctorInfo);
			request.getSession().setAttribute("username_in_session", userName);
			// 返回登录结果
			return JsonUtils.getJson(BaseJsonVo.success(returnDataMap));
		}

	}

	@RequestMapping(value = "/indexPage", method = RequestMethod.GET)
	public String showIndexPage(HttpServletRequest request, Model model) {

		return "/index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("doc_session");
		request.getSession().removeAttribute("doctorInfo");
		return "redirect:/";
	}


}
