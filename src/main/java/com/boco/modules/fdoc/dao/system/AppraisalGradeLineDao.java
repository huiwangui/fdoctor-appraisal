package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;

@MyBatisDao
public interface AppraisalGradeLineDao extends CrudDao<AppraisalGradeLineEntity>{

	List<AppraisalGradeLineEntity> findAll();

}
