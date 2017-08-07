package com.boco.modules.fdoc.service.sign;

import com.boco.modules.fdoc.vo.AppraisalMonthSignTotalIncrementVo;

/**
 * 签约管理总量service
 * @author q
 *
 */
public interface AppraisalMonthSignTotalIncrementService {
	
	/**
	 * 获取签约总量数据，传入参数为月份时，为本月份数据，否则为年份数据
	 * @param monthOrYear ：月份、年份参数，格式为yyyy或yyyyMM，如：201708或2017
	 * @return
	 */
	public AppraisalMonthSignTotalIncrementVo getSignTotalData(String monthOrYear);
}
