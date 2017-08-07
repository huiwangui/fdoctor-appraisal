package com.boco.modules.fdoc.service.system;

import java.util.List;

import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;

public interface AppraisalGradeLineService {
	
	List<AppraisalGradeLineEntity> findAll();
	int insert(AppraisalGradeLineEntity appraisalGradeLineEntity);
	int update(AppraisalGradeLineEntity appraisalGradeLineEntity);
	int delete(AppraisalGradeLineEntity appraisalGradeLineEntity);

}
