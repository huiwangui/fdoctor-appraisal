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

import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.DateUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTotalIncrementService;
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
	
	
}
