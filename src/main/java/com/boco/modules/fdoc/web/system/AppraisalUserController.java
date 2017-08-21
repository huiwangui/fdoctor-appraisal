package com.boco.modules.fdoc.web.system;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.enums.ApiStatusEnum;
import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.MatcherUtiles;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.model.system.AppraisalUserEntity;
import com.boco.modules.fdoc.service.system.AppraisalUserService;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class AppraisalUserController {
	@Resource
	AppraisalUserService appraisalUserService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String save(HttpServletRequest request,String body) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		AppraisalUserEntity entity=new AppraisalUserEntity(StringUtils.toMd5(userName),StringUtils.toMd5(password));
		AppraisalUserEntity user=appraisalUserService.selectByUserNameAndPassword(entity);
        if(user!=null){
        	// 将登陆用户写入session
            request.getSession().setAttribute("user_session", user);
        	return JsonUtils.getJson(BaseJsonVo.success(1));
        }else{
    			// 若没有查询到该对象，返回用户名或密码错误
			return JsonUtils.getJson(BaseJsonVo.empty(
    					ApiStatusEnum.DOC_LOGIN_ERROR.getKey(),
    					ApiStatusEnum.DOC_LOGIN_ERROR.getValue()));
        }
		
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,String body) {
        
		return "/index";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String password(HttpServletRequest request,String body) {
        
		return "/system/password";
	}
	
     /**
      * 更新密码
      * @param request
      * @param password
      * @param newpassword
      * @return
      *
      */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(HttpServletRequest request,String password,String newpassword,String repassword) {
		if(!repassword.equals(newpassword)){
		     return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.PASSWORD_NOSAME.getKey(),
					ApiStatusEnum.PASSWORD_NOSAME.getValue()));
		}
		if(repassword.equals(password)){
		     return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.NONE_CHANGED.getKey(),
					ApiStatusEnum.NONE_CHANGED.getValue()));
		}
		// 判断新密码是否合法
		if (!MatcherUtiles.lengthVail(newpassword)) {
			return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.PASSWORD_VAILED_FAIL.getKey(),
					ApiStatusEnum.PASSWORD_VAILED_FAIL.getValue()));
		}
		AppraisalUserEntity user=(AppraisalUserEntity)request.getSession().getAttribute("user_session");
		if(user==null){
			return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.SESSION_TOKEN_VALID.getKey(),
					ApiStatusEnum.SESSION_TOKEN_VALID.getValue()));
		}
		AppraisalUserEntity entity=new AppraisalUserEntity(user.getUserName(),StringUtils.toMd5(password));
		AppraisalUserEntity appEntity=appraisalUserService.selectByUserNameAndPassword(entity);
        if(appEntity!=null){
        	AppraisalUserEntity updateEntity=new AppraisalUserEntity(user.getId(),user.getUserName(),StringUtils.toMd5(newpassword),user.getType());
        	int result=appraisalUserService.updateByPrimaryKeySelective(updateEntity);
        	if(result>0){
        		 updateEntity.setPassword(null);
        		 request.getSession().setAttribute("user_session", updateEntity);
      	 	   return JsonUtils.getJson(BaseJsonVo.success(1));
      		}else{
      			return JsonUtils.getJson(BaseJsonVo.error());
      		}
        }else{
        	return JsonUtils.getJson(BaseJsonVo.empty(ApiStatusEnum.OLD_ERROR.getKey(),ApiStatusEnum.OLD_ERROR.getValue()));
        }
	}
   /**
    * 注销
    * @param request
    * @param body
    * @return
    *
    */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request,String body) {
        
		request.getSession().removeAttribute("user_session");
		return "redirect:/";
	}
}
