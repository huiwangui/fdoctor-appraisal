package com.boco.modules.fdoc.dao.sign;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTotalIncrementVo;
 

/**
 * Description
 * @author lzz
 * @date 2017年8月4日 下午3:18:59
 */
@MyBatisDao
public interface AppraisalMonthSignTotalIncrementDao extends CrudDao<AppraisalMonthSignTotalIncrementEntity> {
	
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
