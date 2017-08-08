package com.boco.modules.fdoc.service.sign.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.sign.SigServicepackDao;
import com.boco.modules.fdoc.model.sign.SigServicepackEntity;
import com.boco.modules.fdoc.service.sign.SigServicepackService;


@Service
public class SigServicepackServiceImpl implements SigServicepackService{
	
	@Resource
	SigServicepackDao sigServicepackDao;

	@Override
	public List<SigServicepackEntity> getAll() {
		return sigServicepackDao.findAllList(null);
	}


	@Override
	public Integer getCount() {
		return sigServicepackDao.getCount();
	}


	@Override
	public List<SigServicepackEntity> getServicePacksByValues(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sigServicepackDao.getServicePacksByValues(map);
	}

	
	
}
