package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

@MyBatisDao
public interface AppraisalQuotaDao extends CrudDao<AppraisalQuotaEntity>{
	int updateByPrimaryKey(AppraisalQuotaEntity appraisalQuotaEntity);
	List<AppraisalQuotaEntity>  getAll();
	/**
	 * 查找一类指标下的二类指标
	 * @param parentId
	 * @return
	 *
	 */
	List<AppraisalQuotaEntity>  getByParentId(int parentId);

}
