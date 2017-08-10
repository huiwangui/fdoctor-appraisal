package com.boco.modules.fdoc.service.system;

import java.util.List;

import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;

public interface AppraisalGradeLineService {
	/**
	 * 获取所有的分数线
	 * @return
	 *
	 */
	List<AppraisalGradeLineEntity> findAll();
	/**
	 * 添加分数线
	 * @param appraisalGradeLineEntity
	 * @return
	 *
	 */
	int insert(AppraisalGradeLineEntity appraisalGradeLineEntity);
	/**
	 * 更新分数线
	 * @param appraisalGradeLineEntity
	 * @return
	 *
	 */
	int update(AppraisalGradeLineEntity appraisalGradeLineEntity);
	/**
	 * 删除分数线
	 * @param appraisalGradeLineEntity
	 * @return
	 *
	 */
	int delete(AppraisalGradeLineEntity appraisalGradeLineEntity);

}
