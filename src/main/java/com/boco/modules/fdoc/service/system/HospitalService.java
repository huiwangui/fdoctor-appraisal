package com.boco.modules.fdoc.service.system;

import java.util.List;

import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.HospitalVo;

public interface HospitalService {
	/**
	 * 
	 * getHospitalList:(获取全部医院列表). <br/>
	 * @author q
	 * @return
	 */
	public List<HospitalEntity> getHospitalList();

	/**
	 * 获取总条数
	 * @param hosVo
	 * @return
	 */
	public int getCount(HospitalVo hosVo);

	/**
	 * 获取分页医院列表
	 * @param hosVo
	 * @return
	 */
	public List<HospitalVo> getHosList(HospitalVo hosVo);

	/**
	 * 保存医院
	 * @param hosEntity
	 * @return
	 */
	public int saveHos(HospitalEntity hosEntity);

	/**
	 * 获取医院详细信息
	 * @param id
	 * @return
	 */
	public HospitalEntity getHospatal(String id);
	
	/**
	 * 修改医院
	 * @param hosEntity
	 * @return
	 */
	public int updateHos(HospitalEntity hosEntity);

	/**
	 * 删除医院
	 * @param id
	 * @return
	 */
	public int deleteHos(String id);
}
