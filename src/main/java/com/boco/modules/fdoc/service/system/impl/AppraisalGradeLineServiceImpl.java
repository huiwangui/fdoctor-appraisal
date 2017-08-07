package com.boco.modules.fdoc.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.system.AppraisalGradeLineService;
@Service
public class AppraisalGradeLineServiceImpl implements AppraisalGradeLineService {
	
	@Resource
	AppraisalGradeLineDao gradeDao;

	@Override
	public List<AppraisalGradeLineEntity> findAll() {
		return gradeDao.findAll();
	}

	@Override
	public int insert(AppraisalGradeLineEntity appraisalGradeLineEntity) {
		return gradeDao.insert(appraisalGradeLineEntity);
	}

	@Override
	public int update(AppraisalGradeLineEntity appraisalGradeLineEntity) {
		return gradeDao.update(appraisalGradeLineEntity);
	}

	@Override
	public int delete(AppraisalGradeLineEntity appraisalGradeLineEntity) {
		return gradeDao.delete(appraisalGradeLineEntity);
	}

}
