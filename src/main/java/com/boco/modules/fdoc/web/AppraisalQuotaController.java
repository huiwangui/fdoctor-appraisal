package com.boco.modules.fdoc.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.AppraisalQuotaService;


@Controller
@RequestMapping(value = "/system", produces = "application/json;charset=UTF-8")
public class AppraisalQuotaController {
    @Resource
	AppraisalQuotaService appraisalQuotaService;



	@RequestMapping(value = "/quota", method = RequestMethod.GET)
	public String showquotaPage(HttpServletRequest request, Model model) {

		return "/system/quota";
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(HttpServletRequest request, Model model) {

		List<AppraisalQuotaEntity> list=appraisalQuotaService.getAll();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total", list.size());
		return JsonUtils.getJson(map);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(HttpServletRequest request,String body) {
		List<AppraisalQuotaEntity> list=JsonUtils.getObjectList(body, AppraisalQuotaEntity.class);
        
		return JsonUtils.getJson(BaseJsonVo.success(1));
	}




}
