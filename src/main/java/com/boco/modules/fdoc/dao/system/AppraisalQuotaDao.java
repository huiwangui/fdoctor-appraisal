package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

@MyBatisDao
public interface AppraisalQuotaDao extends CrudDao<AppraisalQuotaEntity>{
	int updateByPrimaryKey(AppraisalQuotaEntity appraisalQuotaEntity);
	List<AppraisalQuotaEntity>  getAll();

}
