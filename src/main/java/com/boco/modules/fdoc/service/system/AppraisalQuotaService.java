package com.boco.modules.fdoc.service.system;

import java.util.List;

import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

public interface AppraisalQuotaService {
	
	List<AppraisalQuotaEntity>  getAll();
	
	int updateByPrimaryKey(List<AppraisalQuotaEntity> appraisalQuotaEntitys);

}
