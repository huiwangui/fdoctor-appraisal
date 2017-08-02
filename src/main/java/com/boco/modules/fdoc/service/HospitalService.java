package com.boco.modules.fdoc.service;

import java.util.List;

import com.boco.modules.fdoc.model.HospitalEntity;

public interface HospitalService {
	/**
	 * 
	 * getHospitalList:(获取全部医院列表). <br/>
	 * @author q
	 * @return
	 */
	public List<HospitalEntity> getHospitalList();
}
