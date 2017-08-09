package com.boco.modules.fdoc.web.appraise;

import java.text.ParseException;
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
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
 
 
 
 

@Controller
@RequestMapping(value="/organization",produces = "application/json;charset=UTF-8")
public class OrganizationController {
	
	@Resource
	AppraisalMonthOrgScoreService appraisalMonthOrgScoreService;
	@Resource
	AppraisalMonthTeamScoreService appraisalMonthTeamScoreService;
	
	@RequestMapping(value = "/homePage",method = RequestMethod.GET)
	public String showPage(HttpServletRequest request, Model model){
		//获取所有医疗机构
		List<HospitalEntity> organizationList = appraisalMonthOrgScoreService.getHospitalList();		 
		//设置作用域对象
		model.addAttribute("organizationList", organizationList);
		return "/appraise/organization/homePage";
	}
	
	@ResponseBody
	@RequestMapping(value="organizationScoreList",method=RequestMethod.GET)
	public String teamScoreList(HttpServletRequest request, Model model,String orgId,String  month, 
				Integer pageIndex,Integer pageSize) throws ParseException{
		AppraisalMonthOrgScoreVo vo = new AppraisalMonthOrgScoreVo();
		Page<AppraisalMonthOrgScoreVo> page=new Page<AppraisalMonthOrgScoreVo>(pageIndex, pageSize);
		vo.setOrgId(orgId);	 
		
		if(StringUtils.isNotEmpty(month)){
			vo.setMonth(StringUtils.getStringNum(month));
		} 
		//根据月份获取所有医疗机构总数		
		int count = appraisalMonthOrgScoreService.getOrganizationScoreListCount(vo);
		vo.setPage(page);
		//根据月份获取所有医疗机构
		List<AppraisalMonthOrgScoreVo> organizationScoreList = appraisalMonthOrgScoreService.getOrganizationScoreList(vo);
		for (AppraisalMonthOrgScoreVo organization : organizationScoreList){		 
			int familyIncrement = 0;
			if(organization.getFamilyIncrement()!=null){
				 familyIncrement = organization.getFamilyIncrement();
			}
			int signIncrement = 0;
			if(organization.getSignIncrement()!=null){
				signIncrement = organization.getSignIncrement();
			}			 
			organization.setSignFamilyAndPerson(familyIncrement+"/"+signIncrement);
			if(organization.getSignManageScore()==null){
				organization.setSignManageScore(0.0);
			}
			if(organization.getPublicHealthScore()==null){
				organization.setPublicHealthScore(0.0);
			}
			if(organization.getHealthManageScore()==null){
				organization.setHealthManageScore(0.0);
			}
			if(organization.getCustomerScore()==null){
				organization.setCustomerScore(0.0);
			}
			if(organization.getResultScore()==null){
				organization.setResultScore(0.0);
			}
			 
			 
		}
		//return JsonUtils.getJson(teamScoreList);
		return JsonUtils.getJson(BaseJsonVo.pageList(organizationScoreList,count));
	}
	@RequestMapping(value = "/organizationStrength",method = RequestMethod.GET)
	public String getTeamStrengthNumber(HttpServletRequest request, Model model,String month,String orgId){
	  
		AppraisalMonthOrgScoreEntity entity = new AppraisalMonthOrgScoreEntity();
		entity.setMonth(month);
		entity.setOrgId(orgId);
		//获取指定月份的指定机构数据
		AppraisalMonthOrgScoreVo vo = appraisalMonthOrgScoreService.getAppraisalMonthOrgScoreByMonth(entity);
		//获取指定机构的实力
		AppraisalMonthOrgScoreVo scoreVo =appraisalMonthOrgScoreService.getAppraisalMonthOrgScoreByOrgId(orgId);
		//处理一个机构名称对应多个orgid 比如仁和区卫生局
		if(scoreVo==null){
			//设置作用域对象
			model.addAttribute("organization", new AppraisalMonthOrgScoreVo());	 
			return "/appraise/organization/organizationStrength";
		}
		
		if(StringUtils.isNotEmpty(vo.getOrgAddress())){
			scoreVo.setOrgAddress(vo.getOrgAddress());
		}
		
		if(vo.getFamilyIncrement()==null){
			scoreVo.setFamilyIncrement(0);
		}else{
			scoreVo.setFamilyIncrement(vo.getFamilyIncrement());
		}
		if(vo.getSignIncrement()==null){
			scoreVo.setSignIncrement(0);
		}else{
			scoreVo.setSignIncrement(vo.getSignIncrement());
		}
		if(vo.getTeamTotal()==null){
			scoreVo.setTeamTotal(0);
		}else{
			scoreVo.setTeamTotal(vo.getTeamTotal());
		}
		if(vo.getChronicDiseaseNumber()==null){
			scoreVo.setChronicDiseaseNumber(0);
		}else{
			scoreVo.setChronicDiseaseNumber(vo.getChronicDiseaseNumber());
		}	
		if(vo.getUnQualifiedIncrement()==null){
			scoreVo.setUnQualifiedIncrement(0);
		}else{
			scoreVo.setUnQualifiedIncrement(vo.getUnQualifiedIncrement());
		}	
		if(vo.getExcellentIncrement()==null){
			scoreVo.setExcellentIncrement(0);
		}else{
			scoreVo.setExcellentIncrement(vo.getExcellentIncrement());
		}	
		if(vo.getQualifiedIncrement()==null){
			scoreVo.setQualifiedIncrement(0);
		}else{
			scoreVo.setQualifiedIncrement(vo.getQualifiedIncrement());
		}	
		if(vo.getResultScore()==null){
			scoreVo.setResultScore(0.0);
		}else{
			scoreVo.setResultScore(vo.getResultScore());
		}	
		//设置作用域对象
		model.addAttribute("organization", scoreVo);
 
		return "/appraise/organization/organizationStrength";
	}
}
