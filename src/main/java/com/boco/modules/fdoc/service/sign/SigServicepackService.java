package com.boco.modules.fdoc.service.sign;

import java.util.List;
import java.util.Map;

import com.boco.modules.fdoc.model.sign.SigServicepackEntity;


public interface SigServicepackService {
	/**
	 * 获取服务包总条数
	 * @return
	 */
	public Integer getCount();
	
	/**
	 * 获取所有服务包信息
	 * @return
	 */
	public List<SigServicepackEntity> getAll();
	
	/**
	 * 根据权值获取实力列表
	 */
	public List<SigServicepackEntity> getServicePacksByValues(Map<String, String> map);
	
}
