package com.boco.modules.fdoc.service.score;

import java.util.List;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;

public interface AppraisalMonthOrgScoreService {
	
	/**
	 * Tilte: getorganizationList 
	 * Description:获取所有机构
	 * @return List<AppraisalMonthOrgScoreEntity>
	 * @author h
	 */
	public List<HospitalEntity> getHospitalList();
	
	/**
	 * Tilte: getAppraisalMonthOrgScoreByMonth 
	 * Description:根据月份获取机构当月信息
	 * @param entity
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity);

}
