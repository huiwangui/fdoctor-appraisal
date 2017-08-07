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
		AppraisalUserEntity entity=new AppraisalUserEntity(userName,password);
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
      * @param repassword
      * @return
      *
      */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(HttpServletRequest request,String password,String newpassword,String repassword) {
		// 判断新密码是否合法
		if (!MatcherUtiles.noSpecialChar(newpassword)) {
			return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.PASSWORD_OUTLAW.getKey(),
					ApiStatusEnum.PASSWORD_OUTLAW.getValue()));
		}
		AppraisalUserEntity user=(AppraisalUserEntity)request.getSession().getAttribute("user_session");
        if(password.equals(user.getPassword())){
        	AppraisalUserEntity entity=new AppraisalUserEntity(user.getId(),user.getUserName(),newpassword,user.getType());
        	int result=appraisalUserService.updateByPrimaryKeySelective(entity);
        	 if(result>0){
        		 request.getSession().setAttribute("user_session", entity);
      	 	   return JsonUtils.getJson(BaseJsonVo.success(1));
      		}else{
      			return JsonUtils.getJson(BaseJsonVo.error());
      		}
        	
        }else{
        	return JsonUtils.getJson(BaseJsonVo.empty(
					ApiStatusEnum.OLD_ERROR.getKey(),
					ApiStatusEnum.OLD_ERROR.getValue()));
        }
	}
   /**
    * 注销
    * @param request
    * @param body
    * @return
    *
    */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	@ResponseBody
	public String loginOut(HttpServletRequest request,String body) {
        
		request.getSession().removeAttribute("user_session");
		return "redirect:/fdoctor-appraisal";
	}
}
