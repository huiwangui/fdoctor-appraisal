package com.boco.modules.fdoc.service.system;

import java.util.List;

import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

public interface AppraisalQuotaService {
	/**
	 * 查询所有占比
	 * @return
	 *
	 */
	List<AppraisalQuotaEntity>  getAll();
	/**
	 * 更新占比
	 * @param appraisalQuotaEntitys
	 * @return
	 *
	 */
	int updateByPrimaryKey(List<AppraisalQuotaEntity> appraisalQuotaEntitys);

}
