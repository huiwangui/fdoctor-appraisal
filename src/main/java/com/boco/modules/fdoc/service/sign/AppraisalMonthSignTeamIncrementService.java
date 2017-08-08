package com.boco.modules.fdoc.service.sign;

import java.util.List;

import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
/**
 * 团队月度签约管理service
 * @author q
 *
 */
public interface AppraisalMonthSignTeamIncrementService {
	/**
	 * 获取团队签约管理月度数据集合
	 * @param month：月份，格式为yyyyMM
	 * @return
	 */
	public List<AppraisalMonthSignTeamIncrementVo> getMonthSignTeamDataList(String month);
	
	/**
	 * 获取优秀团队签约管理月度数据集合
	 * @param month：月份，格式为yyyyMM
	 * @return
	 */
	public List<AppraisalMonthSignTeamIncrementVo> getMonthSignExcellentTeamDataList(String month);
}
