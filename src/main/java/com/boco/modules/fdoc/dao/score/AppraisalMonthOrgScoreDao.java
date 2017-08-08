package com.boco.modules.fdoc.dao.score;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;

@MyBatisDao
public interface AppraisalMonthOrgScoreDao extends CrudDao<AppraisalMonthOrgScoreEntity>{
	 
	/**
	 * Tilte: getAppraisalMonthOrgScoreByMonth 
	 * Description:根据月份获取机构当月信息
	 * @param entity
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity);
	/**
	 * Tilte: getAppraisalMonthOrgScoreListByMonth 
	 * Description:根据月份获取机构列表
	 * @param month
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month);
}
