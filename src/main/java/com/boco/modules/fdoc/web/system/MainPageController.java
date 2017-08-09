package com.boco.modules.fdoc.web.system;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boco.common.enums.ApiStatusEnum;
import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.DateUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTotalIncrementService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTotalIncrementVo;

/**
 * 首页控制器
 * @author q
 *
 */
@Controller
@RequestMapping(value = "/main", produces = "application/json;charset=UTF-8")
public class MainPageController {
	
	@Resource
	AppraisalMonthSignTotalIncrementService totalIncrementService;
	@Resource
	AppraisalMonthSignOrgIncrementService orgIncrementService;
	@Resource
	AppraisalMonthOrgScoreService orgScoreService;
	
	/**
	 * 首页跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String mainPage(HttpServletRequest request, Model model) {
		
		//获取有数据的年份集合，用于年份下拉框
		List<String> years = totalIncrementService.getYears();
		model.addAttribute("years", years);
		
		return "/main";
	}
	
	/**
	 * 获取签约年度总数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getSignTotalData", method = RequestMethod.GET)
	@ResponseBody
	public String getSignTotalData(HttpServletRequest request, String year) {
		AppraisalMonthSignTotalIncrementVo signTotalData = totalIncrementService.getSignTotalData(year);
		
		return JsonUtils.getJson(BaseJsonVo.success(signTotalData));
	}
	
	/**
	 * 获取月度签约数据集合
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMonthSignList", method = RequestMethod.GET)
	@ResponseBody
	public String getMonthSignList(HttpServletRequest request, String year) {
		List<AppraisalMonthSignTotalIncrementEntity> yearSignDataList = totalIncrementService.getYearSignDataList(year);
		
		return JsonUtils.getJson(BaseJsonVo.success(yearSignDataList));
	}
	
	/**
	 * 获取月度优秀签约机构集合
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMonthSignExcellentOrgList", method = RequestMethod.GET)
	@ResponseBody
	public String getMonthSignExcellentOrgList(HttpServletRequest request, String month, String target) {
		
		try {
			//返回优秀机构集合
			List<AppraisalMonthSignOrgIncrementVo> list = orgIncrementService.getMonthSignExcellentOrgDataList(month, target);
			return JsonUtils.getJson(BaseJsonVo.success(list));
			
		} catch (Exception e) {
			//出现反射调用异常，提示后台错误
			e.printStackTrace();
			return JsonUtils.getJson(BaseJsonVo.empty(ApiStatusEnum.ERROR_CODE.getKey(),
					ApiStatusEnum.ERROR_CODE.getValue()));
		}
		
	}
	
	/**
	 * 获取机构得分详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOrgDetail", method = RequestMethod.GET)
	@ResponseBody
	public String getOrgDetail(HttpServletRequest request, String month, String orgId) {
		//封装查询参数
		AppraisalMonthOrgScoreEntity entity = new AppraisalMonthOrgScoreEntity();
		entity.setMonth(month);
		entity.setOrgId(orgId);
		
		//调用service获取结果
		AppraisalMonthOrgScoreVo orgScore = orgScoreService.getAppraisalMonthOrgScoreByMonth(entity);
		
		return JsonUtils.getJson(BaseJsonVo.success(orgScore));
	}
}
