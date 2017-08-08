package com.boco.modules.fdoc.dao.sign;

import java.util.List;
import java.util.Map;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.sign.SigServicepackEntity;

@MyBatisDao
public interface SigServicepackDao extends CrudDao<SigServicepackEntity>{
	/**
	 * 
	 * getServicePacksByValues:(根据权值获取列表). <br/>
	 * @author q
	 * @param values 服务包权值，以逗号隔开
	 * @return
	 */
	public List<SigServicepackEntity> getServicePacksByValues(Map<String, String> valuesMap);
	/**
	 * 获取服务包总条数
	 * @return
	 */
	public Integer getCount();
	
} 
