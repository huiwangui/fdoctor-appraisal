package com.boco.modules.fdoc.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.system.AppraisalUserDao;
import com.boco.modules.fdoc.model.system.AppraisalUserEntity;
import com.boco.modules.fdoc.service.system.AppraisalUserService;
@Service
public class AppraisalUserServiceImpl implements AppraisalUserService {
	
	@Resource
	AppraisalUserDao userDao;

	@Override
	public AppraisalUserEntity selectByUserNameAndPassword(AppraisalUserEntity appraisalUserEntity) {
		return userDao.selectByUserNameAndPassword(appraisalUserEntity);
	}

	@Override
	public int updateByPrimaryKeySelective(AppraisalUserEntity appraisalUserEntity) {
		return userDao.updateByPrimaryKeySelective(appraisalUserEntity);
	}

	@Override
	public AppraisalUserEntity selectByPrimaryKey(String id) {
		return userDao.selectByPrimaryKey(id);
	}

}
