package com.boco.modules.fdoc.web.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.system.AppraisalGradeLineService;

@Controller
@RequestMapping(value = "/grade", produces = "application/json;charset=UTF-8")
public class AppraisalGradeLineController {
	@Autowired
	AppraisalGradeLineService gradeService;
	
	@RequestMapping(value = "/line", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
        
		return "/system/gradeLine";
	}
	
	/**
	 * 分数线列表
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public String findAll(HttpServletRequest request) {
		List<AppraisalGradeLineEntity> list= gradeService.findAll();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total", list.size());
		System.err.println(JsonUtils.getJson(map));
		return JsonUtils.getJson(map);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(HttpServletRequest request,AppraisalGradeLineEntity entity) {
		entity.setUpdateTime(new Date());
		int result=gradeService.insert(entity);
		if(result>0){
		 	   return JsonUtils.getJson(BaseJsonVo.success(result));
		}else{
				return JsonUtils.getJson(BaseJsonVo.error());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,AppraisalGradeLineEntity entity) {
		System.out.println(JsonUtils.getJson(entity));
		entity.setUpdateTime(new Date());
		System.out.println(JsonUtils.getJson(entity));
		int result=gradeService.update(entity);
		if(result>0){
		 	   return JsonUtils.getJson(BaseJsonVo.success(result));
		}else{
				return JsonUtils.getJson(BaseJsonVo.error());
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,String body) {
		int result=0;
		List<AppraisalGradeLineEntity> list=JsonUtils.getObjectList(body, AppraisalGradeLineEntity.class);
		for(AppraisalGradeLineEntity entity:list){
		  result=gradeService.delete(entity);
		}
		if(result>0){
		 	   return JsonUtils.getJson(BaseJsonVo.success(result));
		}else{
				return JsonUtils.getJson(BaseJsonVo.error());
		}
	}

}
