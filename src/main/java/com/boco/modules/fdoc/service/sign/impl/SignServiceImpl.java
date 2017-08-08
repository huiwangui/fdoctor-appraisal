package com.boco.modules.fdoc.service.sign.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.sign.SignDao;
import com.boco.modules.fdoc.model.sign.SigServicepackEntity;
import com.boco.modules.fdoc.service.sign.SignService;
import com.boco.modules.fdoc.vo.SignFamilyTeamVo;

@Service
public class SignServiceImpl implements SignService {

	@Resource
	SignDao signDao;
	
	@Override
	public List<SignFamilyTeamVo> getSignListByType(SignFamilyTeamVo signVo) {
		return signDao.getSignListByType(signVo);
	}

	@Override
	public Integer getSignListByTypecCount(SignFamilyTeamVo signVo) {
		return signDao.getSignListByTypeCount(signVo);
	}


	
}
