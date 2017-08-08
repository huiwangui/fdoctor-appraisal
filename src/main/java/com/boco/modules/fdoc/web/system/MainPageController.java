package com.boco.modules.fdoc.web.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页控制器
 * @author q
 *
 */
@Controller
@RequestMapping(value = "/main", produces = "application/json;charset=UTF-8")
public class MainPageController {
	
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String mainPage(HttpServletRequest request) {
		return "/main";
	}
}
