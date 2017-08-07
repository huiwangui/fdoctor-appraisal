package com.boco.modules.fdoc.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boco.modules.fdoc.dao.system.AppraisalQuotaDao;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;

@Service
public class AppraisalQuotaServiceImpl implements  AppraisalQuotaService{
	
	@Resource
	AppraisalQuotaDao appraisalQuotaDao;

	@Override
	public List<AppraisalQuotaEntity> getAll() {
		
		return (List<AppraisalQuotaEntity>) appraisalQuotaDao.getAll();
	}



	@Override
	@Transactional
	public int updateByPrimaryKey(List<AppraisalQuotaEntity> appraisalQuotaEntitys) {
		int result=0;
		for (AppraisalQuotaEntity appraisalQuotaEntity:appraisalQuotaEntitys) {
		  result=appraisalQuotaDao.updateByPrimaryKey(appraisalQuotaEntity);
		}
		return result;
	}

}
