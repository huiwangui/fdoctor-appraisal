package com.boco.modules.fdoc.dao.score;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.modules.fdoc.model.score.HospitalEntity;

@MyBatisDao
public interface AppraisalMonthOrgScoreDao {
	/**
	 * Tilte: getorganizationList 
	 * Description:获取所有医疗机构
	 * @return List<AppraisalMonthOrgScoreEntity>
	 * @author h
	 */
	public List<HospitalEntity> getHospitalList();
}
