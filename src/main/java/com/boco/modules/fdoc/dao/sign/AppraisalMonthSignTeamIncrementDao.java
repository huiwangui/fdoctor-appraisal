package com.boco.modules.fdoc.dao.sign;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTeamIncrementEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;

/**
 * Description
 * @author lzz
 * @date 2017年8月4日 下午3:17:09
 */
@MyBatisDao
public interface AppraisalMonthSignTeamIncrementDao extends CrudDao<AppraisalMonthSignTeamIncrementEntity> {
	/**
	 * 获取团队签约管理月度数据集合
	 * @param month：月份，格式为yyyyMM
	 * @return
	 */
	public List<AppraisalMonthSignTeamIncrementVo> getMonthSignTeamDataList(String month);
}
