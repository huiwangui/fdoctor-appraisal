package com.boco.modules.fdoc.web.appraise;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.json.BaseJsonVo;
import com.boco.common.persistence.Page;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.statistics.StatisticsDayBasedataEntity;
import com.boco.modules.fdoc.service.sign.SignService;
import com.boco.modules.fdoc.service.system.DocService;
import com.boco.modules.fdoc.service.system.HospitalService;
import com.boco.modules.fdoc.service.system.StatisticsDayBasedataService;
import com.boco.modules.fdoc.vo.DoctorDetailVo;
import com.boco.modules.fdoc.vo.SignFamilyTeamVo;

/**
 * Description
 * @author lzz
 * @date 2017年8月7日 上午11:00:08
 */

@Controller
@RequestMapping(value="/sign",produces="application/json;charset=UTF-8")
public class SignRecordController {
	
	@Resource
	HospitalService hospitalService;
	@Resource
	DocService docService;
	@Resource
	StatisticsDayBasedataService baseService;
	@Resource
	SignService signService;
	
	@RequestMapping(value = "/showPage",method = RequestMethod.GET)
	public String showPage(HttpServletRequest request, Model model){
		
		//获取签约总人数详情
		StatisticsDayBasedataEntity baseEntity=new StatisticsDayBasedataEntity();
		baseEntity=baseService.getBasedata();
		
		//获取医院列表
		List<HospitalEntity> hospitalList = hospitalService.getHospitalList();
		//设置作用域对象
		model.addAttribute("hospitalList", hospitalList);
		model.addAttribute("hospitalList2",JsonUtils.getJson(hospitalList));
		model.addAttribute("baseEntity", baseEntity);
		
		return "/sign/signCount";
	}
	
	@ResponseBody
	@RequestMapping(value="/getTeamLeader",method=RequestMethod.GET)
	public String getTeamLeader(HttpServletRequest request, Model model,String orgId){
		DoctorDetailVo docVo=new DoctorDetailVo();
		docVo.setOrgId(orgId);
		List<DoctorDetailVo> dlist=docService.getLeaderList(docVo);
		return JsonUtils.getJson(dlist);
	}
	
	@ResponseBody
	@RequestMapping(value="/getSignDetail",method=RequestMethod.GET)
	public String getSignDetail(HttpServletRequest request, Model model,String orgId,String teamId,String personType,
			Integer pageIndex,Integer pageSize){
		
		SignFamilyTeamVo signVo=new SignFamilyTeamVo();
		if(teamId !=null && !"".equals(teamId)){
			signVo.setTeamId(teamId);
		}else if(orgId !=null && !"".equals(orgId)){
			signVo.setOrgId(orgId);
		}
		if(!"0".equals(personType)){
			signVo.setPersonType(personType);
		}
		Integer  count=signService.getSignListByTypecCount(signVo);
		Page<SignFamilyTeamVo> page=new Page<SignFamilyTeamVo>(pageIndex, pageSize);
		signVo.setPage(page);
		List<SignFamilyTeamVo> list=signService.getSignListByType(signVo);
		System.out.println(JsonUtils.getJson(list));
		for(SignFamilyTeamVo sVo:list){
			//签约时间
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String start=sdf.format(sVo.getSignTime());
			sVo.setSignTimeStr(start);
			//签约年限
			Calendar begin=Calendar.getInstance();
			Calendar end=Calendar.getInstance();
			begin.setTime(sVo.getSignTime());
			end.setTime(sVo.getDueTime());
			int lastTime=end.get(Calendar.YEAR)-begin.get(Calendar.YEAR);
			sVo.setLastTime(String.valueOf(lastTime));
		}
		
		return JsonUtils.getJson(BaseJsonVo.pageList(list, count));
	}

}
