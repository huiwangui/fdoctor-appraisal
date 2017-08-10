package com.boco.modules.fdoc.dao.sign;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;

@MyBatisDao
public interface AppraisalMonthSignOrgIncrementDao extends CrudDao<AppraisalMonthSignOrgIncrementEntity>{
	
	/**
	 * 获取机构签约管理月度数据集合
	 * @param month：月份，格式为yyyyMM
	 * @return
	 */
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignOrgDataList(String month);
	
	/**
	 * 获取机构月签约数据（从原始签约表中获取）
	 * @param paramVo
	 * @return
	 */
	public AppraisalMonthSignOrgIncrementEntity getMonthSignOrgDataSource(AppraisalMonthSignOrgIncrementVo paramVo);
}
