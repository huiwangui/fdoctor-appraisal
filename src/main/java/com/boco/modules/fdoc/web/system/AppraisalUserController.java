package com.boco.modules.fdoc.web.system;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.JsonUtils;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class AppraisalUserController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String save(HttpServletRequest request,String body) {
        
		return JsonUtils.getJson(BaseJsonVo.success(1));
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,String body) {
        
		return "/index";
	}

}
