package com.boco.modules.fdoc.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.system.AppraisalQuotaDao;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.AppraisalQuotaService;
@Service
public class AppraisalQuotaServiceImpl implements  AppraisalQuotaService{
	
	@Resource
	AppraisalQuotaDao appraisalQuotaDao;

	@Override
	public List<AppraisalQuotaEntity> getAll() {
		
		return (List<AppraisalQuotaEntity>) appraisalQuotaDao.getAll();
	}

}
