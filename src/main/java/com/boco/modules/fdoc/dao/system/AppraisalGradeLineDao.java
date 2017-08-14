package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;

@MyBatisDao
public interface AppraisalGradeLineDao extends CrudDao<AppraisalGradeLineEntity>{

	/**
	 * 查询所有分数线
	 * @return
	 */
	public List<AppraisalGradeLineEntity> findAll();

	/**
	 * 获取优秀分数线
	 * @return
	 */
	public AppraisalGradeLineEntity getExcellentGradeLine();
	
	/**
	 * 获取不合格分数线
	 * @return
	 */
	public AppraisalGradeLineEntity getUnQualified_incrementGradeLine();
}
