package com.boco.modules.fdoc.service.sign;

import java.util.Date;
import java.util.List;

import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
/**
 * 机构月度签约管理service
 * @author q
 *
 */
public interface AppraisalMonthSignOrgIncrementService {
	/**
	 * 获取机构签约管理月度数据集合
	 * @param month：月份，格式为yyyyMM
	 * @return
	 */
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignOrgDataList(String month);
	
	/**
	 * 获取优秀的机构签约管理数据
	 * @param target：判断优秀的目标字段，比如需要查找“高血压得分”的优秀机构，传入signHyperScore(AppraisalFieldTargetConstans中的静态属性)
	 * @return
	 */
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignExcellentOrgDataList(String month, String target)  throws Exception;
	
	/**
	 * 统计并插入数据
	 * @return
	 */
	public String doMonthSignOrgIncrementStatistics(Date monthBegin, Date monthEnd);
}
