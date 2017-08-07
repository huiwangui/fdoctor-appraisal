package com.boco.modules.fdoc.service.sign;

import java.util.List;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;
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
	
	/**
	 * 获取某年签约数据集合
	 * @param year：年份，格式为yyyy
	 * @return
	 */
	public List<AppraisalMonthSignTotalIncrementEntity> getYearSignDataList(String year);
}
