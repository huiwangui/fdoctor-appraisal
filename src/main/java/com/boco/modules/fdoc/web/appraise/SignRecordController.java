package com.boco.modules.fdoc.web.appraise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.reflect.ReflectionBasedReferenceTypeDelegate;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.json.BaseJsonVo;
import com.boco.common.persistence.Page;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.NumberUtils;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.sign.SigServicepackEntity;
import com.boco.modules.fdoc.model.statistics.StatisticsDayBasedataEntity;
import com.boco.modules.fdoc.model.statistics.StatisticsDayTeamBasedataEntity;
import com.boco.modules.fdoc.service.sign.SigServicepackService;
import com.boco.modules.fdoc.service.sign.SignService;
import com.boco.modules.fdoc.service.system.DocService;
import com.boco.modules.fdoc.service.system.HospitalService;
import com.boco.modules.fdoc.service.system.StatisticsDayBasedataService;
import com.boco.modules.fdoc.vo.DoctorDetailVo;
import com.boco.modules.fdoc.vo.SignFamilyTeamVo;
import com.taobao.api.internal.toplink.embedded.websocket.util.StringUtil;

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
	@Resource
	SigServicepackService packService;
	
	@RequestMapping(value = "/showPage",method = RequestMethod.GET)
	public String showPage(HttpServletRequest request, Model model){
		
		//获取签约总人数详情
		StatisticsDayBasedataEntity baseEntity=new StatisticsDayBasedataEntity();
		baseEntity=baseService.getBasedata();
		StatisticsDayTeamBasedataEntity dataEntity=new StatisticsDayTeamBasedataEntity();
		baseEntity=baseService.getBasedata();
		dataEntity.setSignCount(baseEntity.getSignCount());
		dataEntity.setHyperCount(baseEntity.getHyperCount());
		dataEntity.setDiabetesCount(baseEntity.getDiabetesCount());
		dataEntity.setChildrenCount(baseEntity.getChildrenCount());
		dataEntity.setMajorPsychosisCount(baseEntity.getMajorPsychosisCount());
		dataEntity.setOldCount(baseEntity.getOldCount());
		dataEntity.setMaternalCount(baseEntity.getMaternalCount());
		//求占比
		dataEntity.setHyperPercent(getPercent(baseEntity.getHyperCount(), baseEntity.getSignCount()));
		dataEntity.setDiabetesPercent(getPercent(baseEntity.getDiabetesCount(), baseEntity.getSignCount()));
		dataEntity.setChildrenPercent(getPercent(baseEntity.getChildrenCount(), baseEntity.getSignCount()));
		dataEntity.setMajorPsychosisPercent(getPercent(baseEntity.getMajorPsychosisCount(),baseEntity.getSignCount()));
		dataEntity.setOldPercent(getPercent(baseEntity.getOldCount(), baseEntity.getSignCount()));
		dataEntity.setMaternalPercent(getPercent(baseEntity.getMaternalCount(), baseEntity.getSignCount()));
		
		//获取医院列表
		List<HospitalEntity> hospitalList = hospitalService.getHospitalList();
		//设置作用域对象
		model.addAttribute("hospitalList", hospitalList);
		model.addAttribute("hospitalList2",JsonUtils.getJson(hospitalList));
		model.addAttribute("dataEntity", dataEntity);
		
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
			//服务包value
			int packValue=sVo.getPackValue();
			String packList=NumberUtils.bitand(packValue);
			Map<String, String> map=new HashMap<String,String>();
			map.put("values", packList);
			List<SigServicepackEntity> spList=packService.getServicePacksByValues(map);
			String packName="";
			for(SigServicepackEntity sEntity:spList){
				packName=packName+sEntity.getPackName()+"，";
			}
			packName=packName.substring(0, packName.length() - 1);
			sVo.setPackName(packName);
		}
		
		return JsonUtils.getJson(BaseJsonVo.pageList(list, count));
	}

	
	@ResponseBody
	@RequestMapping(value="/getCountData",method=RequestMethod.GET)
	public String getCountData(HttpServletRequest request, Model model,String orgId,String teamId){
		//查询人数变化
				StatisticsDayTeamBasedataEntity dataEntity=new StatisticsDayTeamBasedataEntity();
				if(teamId !=null && !"".equals(teamId)){
					dataEntity=baseService.getLastInfo(teamId);
					dataEntity.setHyperPercent(getPercent(dataEntity.getHyperCount(), dataEntity.getSignCount()));
					dataEntity.setDiabetesPercent(getPercent(dataEntity.getDiabetesCount(), dataEntity.getSignCount()));
					dataEntity.setChildrenPercent(getPercent(dataEntity.getChildrenCount(), dataEntity.getSignCount()));
					dataEntity.setMajorPsychosisPercent(getPercent(dataEntity.getMajorPsychosisCount(),dataEntity.getSignCount()));
					dataEntity.setOldPercent(getPercent(dataEntity.getOldCount(), dataEntity.getSignCount()));
					dataEntity.setMaternalPercent(getPercent(dataEntity.getMaternalCount(), dataEntity.getSignCount()));
				}else if(orgId !=null && !"".equals(orgId)){
					DoctorDetailVo docVo=new DoctorDetailVo();
					docVo.setOrgId(orgId);
					List<DoctorDetailVo> dlist=docService.getLeaderList(docVo);
					
					int sign=0;
					int hyper=0;
					int diabetes=0;
					int children=0;
					int majorPsychosis=0;
					int old=0;
					int maternal=0;
					for(DoctorDetailVo dVo:dlist){
						teamId=dVo.getTeamId();
						StatisticsDayTeamBasedataEntity dEntity=baseService.getLastInfo(teamId);
						sign+=dEntity.getSignCount();
						hyper+=dEntity.getHyperCount();
						diabetes+=dEntity.getDiabetesCount();
						children+=dEntity.getChildrenCount();
						majorPsychosis+=dEntity.getMajorPsychosisCount();
						old+=dEntity.getOldCount();
						maternal+=dEntity.getMaternalCount();
					}
					dataEntity.setSignCount(sign);
					dataEntity.setHyperCount(hyper);
					dataEntity.setDiabetesCount(diabetes);
					dataEntity.setChildrenCount(children);
					dataEntity.setMajorPsychosisCount(majorPsychosis);
					dataEntity.setOldCount(old);
					dataEntity.setMaternalCount(maternal);
					//求占比
					dataEntity.setHyperPercent(getPercent(hyper, sign));
					dataEntity.setDiabetesPercent(getPercent(diabetes,sign));
					dataEntity.setChildrenPercent(getPercent(children,sign));
					dataEntity.setMajorPsychosisPercent(getPercent(majorPsychosis,sign));
					dataEntity.setOldPercent(getPercent(old,sign));
					dataEntity.setMaternalPercent(getPercent(maternal,sign));
				}
				StatisticsDayBasedataEntity baseEntity=new StatisticsDayBasedataEntity();
				if(StringUtils.isEmpty(teamId) && StringUtils.isEmpty(orgId)){
					//获取签约总人数详情
					baseEntity=baseService.getBasedata();
					dataEntity.setSignCount(baseEntity.getSignCount());
					dataEntity.setHyperCount(baseEntity.getHyperCount());
					dataEntity.setDiabetesCount(baseEntity.getDiabetesCount());
					dataEntity.setChildrenCount(baseEntity.getChildrenCount());
					dataEntity.setMajorPsychosisCount(baseEntity.getMajorPsychosisCount());
					dataEntity.setOldCount(baseEntity.getOldCount());
					dataEntity.setMaternalCount(baseEntity.getMaternalCount());
					//求占比
					dataEntity.setHyperPercent(getPercent(baseEntity.getHyperCount(), baseEntity.getSignCount()));
					dataEntity.setDiabetesPercent(getPercent(baseEntity.getDiabetesCount(), baseEntity.getSignCount()));
					dataEntity.setChildrenPercent(getPercent(baseEntity.getChildrenCount(), baseEntity.getSignCount()));
					dataEntity.setMajorPsychosisPercent(getPercent(baseEntity.getMajorPsychosisCount(),baseEntity.getSignCount()));
					dataEntity.setOldPercent(getPercent(baseEntity.getOldCount(), baseEntity.getSignCount()));
					dataEntity.setMaternalPercent(getPercent(baseEntity.getMaternalCount(), baseEntity.getSignCount()));
				}
			return JsonUtils.getJson(dataEntity);
	}
	
	public static String getPercent(int a,int b){
		if(b==0 ){
			return "0%";
		}else{
		NumberFormat numberFormat = NumberFormat.getInstance();
		DecimalFormat decimalFormat = new DecimalFormat(".#");
		double s=(float) a / (float) b * 100;
		s=Double.parseDouble(decimalFormat.format(s));
		String result = numberFormat.format(s);
		return result+"%";
		}
	}
}
