package com.boco.modules.fdoc.service.score.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.score.AppraisalMonthOrgScoreDao;
import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
 
@Service
public class AppraisalMonthOrgScoreServiceImpl implements AppraisalMonthOrgScoreService {

	@Resource
	AppraisalMonthOrgScoreDao appraisalMonthOrgScoreDao;
	@Resource
	HospitalDao hospitalDao;
	@Override
	public List<HospitalEntity> getHospitalList() {		 
		return hospitalDao.getHospitalList();
	}
	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity) {
		 
		return  appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByMonth(entity);
	}
	@Override
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month) {
		 
		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreListByMonth(month);
	}

}
