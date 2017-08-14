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
	
	/**
	 * 查找一类指标下的二类指标
	 * @param parentId
	 * @return
	 *
	 */
	List<AppraisalQuotaEntity>  getByParentId(int parentId);


}
