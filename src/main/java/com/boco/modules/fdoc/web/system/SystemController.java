package com.boco.modules.fdoc.web.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
	
	
	@RequestMapping("/404error")
	public String error(){
		return "/404error";
	}

}
