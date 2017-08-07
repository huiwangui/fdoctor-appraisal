package com.boco.modules.fdoc.service.score.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.score.AppraisalMonthOrgScoreDao;
 
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
 
@Service
public class AppraisalMonthOrgScoreServiceImpl implements AppraisalMonthOrgScoreService {

	@Resource
	AppraisalMonthOrgScoreDao appraisalMonthOrgScoreDao;
	@Override
	public List<HospitalEntity> getHospitalList() {		 
		return appraisalMonthOrgScoreDao.getHospitalList();
	}
	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity) {
		 
		return  appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByMonth(entity);
	}

}
