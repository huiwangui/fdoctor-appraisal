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
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;

@Controller
@RequestMapping(value = "/organization", produces = "application/json;charset=UTF-8")
public class OrganizationController {

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
		return "/appraise/organization/homePage";
	}

	@ResponseBody
	@RequestMapping(value = "organizationScoreList", method = RequestMethod.GET)
	public String teamScoreList(HttpServletRequest request, Model model,
			String orgId, String month, Integer pageIndex, Integer pageSize)
			throws ParseException {
		AppraisalMonthOrgScoreVo vo = new AppraisalMonthOrgScoreVo();
		Page<AppraisalMonthOrgScoreVo> page = new Page<AppraisalMonthOrgScoreVo>(
				pageIndex, pageSize);
		vo.setOrgId(orgId);

		if (StringUtils.isNotEmpty(month)) {
			vo.setMonth(StringUtils.getStringNum(month));
		}
		// 根据月份获取所有医疗机构总数
		int count = appraisalMonthOrgScoreService
				.getOrganizationScoreListCount(vo);
		vo.setPage(page);
		// 根据月份获取所有医疗机构
		List<AppraisalMonthOrgScoreVo> organizationScoreList = appraisalMonthOrgScoreService
				.getOrganizationScoreList(vo);
		for (AppraisalMonthOrgScoreVo organization : organizationScoreList) {
			int familyIncrement = organization.getFamilyIncrement();
			int signIncrement = organization.getSignIncrement();
			organization.setSignFamilyAndPerson(familyIncrement + "/"
					+ signIncrement);

		}
		// return JsonUtils.getJson(teamScoreList);
		return JsonUtils.getJson(BaseJsonVo.pageList(organizationScoreList,
				count));
	}

	@RequestMapping(value = "/organizationStrength", method = RequestMethod.GET)
	public String getTeamStrengthNumber(HttpServletRequest request,
			Model model, String month, String orgId) {

		AppraisalMonthOrgScoreEntity entity = new AppraisalMonthOrgScoreEntity();
		entity.setMonth(month);
		entity.setOrgId(orgId);
		// 获取指定月份的指定机构数据
		AppraisalMonthOrgScoreVo vo = appraisalMonthOrgScoreService
				.getAppraisalMonthOrgScoreByMonth(entity);
		// 获取指定机构的实力
		AppraisalMonthOrgScoreVo scoreVo = appraisalMonthOrgScoreService
				.getAppraisalMonthOrgScoreByOrgId(orgId);
		// 处理一个机构名称对应多个orgid 比如仁和区卫生局
		if (scoreVo == null) {
			// 设置作用域对象
			model.addAttribute("organization", new AppraisalMonthOrgScoreVo());
			return "/appraise/organization/organizationStrength";
		}

		if (StringUtils.isNotEmpty(vo.getOrgAddress())) {
			scoreVo.setOrgAddress(vo.getOrgAddress());
		}

		scoreVo.setFamilyIncrement(vo.getFamilyIncrement());
		scoreVo.setSignIncrement(vo.getSignIncrement());
		scoreVo.setTeamTotal(vo.getTeamTotal());
		scoreVo.setChronicDiseaseNumber(vo.getChronicDiseaseNumber());
		scoreVo.setUnQualifiedIncrement(vo.getUnQualifiedIncrement());
		scoreVo.setExcellentIncrement(vo.getExcellentIncrement());
		scoreVo.setQualifiedIncrement(vo.getQualifiedIncrement());
		scoreVo.setResultScore(vo.getResultScore());
		// 设置作用域对象
		model.addAttribute("organization", scoreVo);

		return "/appraise/organization/organizationStrength";
	}
}
