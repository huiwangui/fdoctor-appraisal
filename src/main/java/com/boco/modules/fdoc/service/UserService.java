package com.boco.modules.fdoc.service;

import com.boco.modules.fdoc.model.system.AppraisalUserEntity;

public interface UserService {
	/**
	 * 登录验证
	 * @param appraisalUserEntity
	 * @return
	 *
	 */
	AppraisalUserEntity	getUser(AppraisalUserEntity appraisalUserEntity);

}
