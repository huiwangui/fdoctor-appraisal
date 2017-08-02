package com.boco.modules.fdoc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.HospitalDao;
import com.boco.modules.fdoc.model.HospitalEntity;
import com.boco.modules.fdoc.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Resource
	HospitalDao hospitalDao;

	@Override
	public List<HospitalEntity> getHospitalList() {
		return hospitalDao.getHospitalList();
	}

}
