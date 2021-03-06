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
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;

@Controller
@RequestMapping(value = "/doctorTeam", produces = "application/json;charset=UTF-8")
public class DoctorTeamController {

	@Resource
	AppraisalMonthOrgScoreService appraisalMonthOrgScoreService;
	@Resource
	AppraisalMonthTeamScoreService appraisalMonthTeamScoreService;

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String showPage(HttpServletRequest request, Model model) {
		// 获取所有医疗机构
		List<HospitalEntity> organizationList = appraisalMonthOrgScoreService
				.getHospitalList();
		// 设置作用域对象
		model.addAttribute("organizationList", organizationList);
		return "/appraise/doctorTeam/homePage";
	}

	@ResponseBody
	@RequestMapping(value = "teamScoreList", method = RequestMethod.GET)
	public String teamScoreList(HttpServletRequest request, Model model,
			String orgId, String month, String doctorName, Integer pageIndex,
			Integer pageSize) throws ParseException {
		AppraisalMonthTeamScoreVo vo = new AppraisalMonthTeamScoreVo();
		Page<AppraisalMonthTeamScoreVo> page = new Page<AppraisalMonthTeamScoreVo>(
				pageIndex, pageSize);
		vo.setOrgId(orgId);

		if (StringUtils.isNotEmpty(month)) {
			vo.setMonth(StringUtils.getStringNum(month));
		}
		vo.setDoctorName(doctorName);
		// 获取所有医疗团队总数
		int count = appraisalMonthTeamScoreService.getTeamScoreListCount(vo);
		vo.setPage(page);
		// 获取所有医疗团队
		List<AppraisalMonthTeamScoreVo> teamScoreList = appraisalMonthTeamScoreService
				.getTeamScoreList(vo);
		for (AppraisalMonthTeamScoreVo team : teamScoreList) {
			team.setDoctorName(team.getDoctorName() + "团队");
			int familyIncrement = team.getFamilyIncrement();
			int signIncrement = team.getSignIncrement();
			team.setSignFamilyAndPerson(familyIncrement + "/" + signIncrement);

		}
		// return JsonUtils.getJson(teamScoreList);
		return JsonUtils.getJson(BaseJsonVo.pageList(teamScoreList, count));
	}

	@RequestMapping(value = "/teamStrength", method = RequestMethod.GET)
	public String getTeamStrengthNumber(HttpServletRequest request,
			Model model, String month, String teamId) {
		AppraisalMonthTeamScoreEntity entity = new AppraisalMonthTeamScoreEntity();
		entity.setMonth(month);
		entity.setTeamId(teamId);
		// 获取指定月份的指定团队数据
		AppraisalMonthTeamScoreVo vo = appraisalMonthTeamScoreService
				.getAppraisalMonthTeamScoreByMonth(entity);
		// 获取指定团队的实力
		AppraisalMonthTeamScoreVo scoreVo = appraisalMonthTeamScoreService
				.getAppraisalMonthTeamScoreByTeamId(teamId);
		if (scoreVo == null) {
			// 设置作用域对象
			model.addAttribute("team", new AppraisalMonthTeamScoreVo());
			return "/appraise/doctorTeam/teamStrength";
		}
		scoreVo.setResultScore(vo.getResultScore());
		scoreVo.setSignIncrement(vo.getSignIncrement());
		scoreVo.setFamilyIncrement(vo.getFamilyIncrement());
		scoreVo.setChronicDiseaseNumber(vo.getChronicDiseaseNumber());
		scoreVo.setOrgAddress(vo.getOrgAddress());
		scoreVo.setOrgName(vo.getOrgName());
		scoreVo.setDoctorName(vo.getDoctorName());

		// 设置作用域对象
		model.addAttribute("team", scoreVo);

		return "/appraise/doctorTeam/teamStrength";
	}
}
