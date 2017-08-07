package com.boco.modules.fdoc.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.system.HospitalService;
import com.boco.modules.fdoc.vo.HospitalVo;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Resource
	HospitalDao hospitalDao;

	@Override
	public List<HospitalEntity> getHospitalList() {
		return hospitalDao.getHospitalList();
	}

	@Override
	public int getCount(HospitalVo hosVo) {
		return hospitalDao.getCount(hosVo);
	}

	@Override
	public List<HospitalVo> getHosList(HospitalVo hosVo) {
		return hospitalDao.getHosList(hosVo);
	}

	@Override
	public int saveHos(HospitalEntity hosEntity) {
		return hospitalDao.saveHos(hosEntity);
	}

	@Override
	public HospitalEntity getHospatal(String orgId) {
		return hospitalDao.getHospitalInfo(orgId);
	}

	@Override
	public int updateHos(HospitalEntity hosEntity) {
		return hospitalDao.updateHos(hosEntity);
	}

	@Override
	public int deleteHos(String id) {
		return hospitalDao.deleteHos(id);
	}

}
