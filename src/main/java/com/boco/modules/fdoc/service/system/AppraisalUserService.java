package com.boco.modules.fdoc.service.system;

import com.boco.modules.fdoc.model.system.AppraisalUserEntity;

public interface AppraisalUserService {
	/**
	 * 登录验证
	 * @param appraisalUserEntity
	 * @return
	 *
	 */
	AppraisalUserEntity selectByUserNameAndPassword(AppraisalUserEntity appraisalUserEntity);
	/**
	 * 更新密码
	 * @param appraisalUserEntity
	 * @return
	 *
	 */
	int updateByPrimaryKeySelective(AppraisalUserEntity appraisalUserEntity);
	/**
	 * 查找用户
	 * @param id
	 * @return
	 *
	 */
	AppraisalUserEntity selectByPrimaryKey(String id);

}
