package com.boco.modules.fdoc.dao;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.HospitalEntity;
/**
 * 
 * @author sunche
 *
 */
@MyBatisDao
public interface HospitalDao extends CrudDao<HospitalEntity>{

	/**
	 * 
	 * getHospitalList:(获取全部医院列表). <br/>
	 * @author q
	 * @return
	 */
	public List<HospitalEntity> getHospitalList();
	
}
