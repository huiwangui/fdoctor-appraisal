package com.boco.modules.fdoc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.service.HospitalService;

@Controller
@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8")
public class TestController {
	
	@Resource
	HospitalService hospitalService;
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public String test() {
		return JsonUtils.getJson(hospitalService.getHospitalList());
	}
}
