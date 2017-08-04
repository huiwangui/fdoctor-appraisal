package com.boco.modules.fdoc.service.score;

import java.util.List;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;

public interface AppraisalMonthOrgScoreService {
	
	/**
	 * Tilte: getorganizationList 
	 * Description:获取所有机构
	 * @return List<AppraisalMonthOrgScoreEntity>
	 * @author h
	 */
	public List<HospitalEntity> getHospitalList();

}
