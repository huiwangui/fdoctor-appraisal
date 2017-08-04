package com.boco.modules.fdoc.web.appraise;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
 

@Controller
@RequestMapping(value="/doctorTeam",produces = "application/json;charset=UTF-8")
public class DoctorTeamController {
	
	@Resource
	AppraisalMonthOrgScoreService appraisalMonthOrgScoreService;
	@Resource
	AppraisalMonthTeamScoreService appraisalMonthTeamScoreService;
	
	@RequestMapping(value = "/homePage",method = RequestMethod.GET)
	public String showPage(HttpServletRequest request, Model model){
		//获取所有医疗机构
		List<HospitalEntity> organizationList = appraisalMonthOrgScoreService.getHospitalList();
		//获取所有医疗团队
		List<AppraisalMonthTeamScoreVo> teamScoreList = appraisalMonthTeamScoreService.getTeamScoreList();
		//设置作用域对象
		model.addAttribute("organizationList", organizationList);
		
		return "/doctorTeam/homePage";
	}
}
