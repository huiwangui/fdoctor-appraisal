package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.HospitalVo;
import com.boco.sp.pojo.cmms.hospital.HospitalInfo;
/**
 * 
 * @author sunche
 *
 */
@MyBatisDao
public interface HospitalDao extends CrudDao<HospitalEntity>{
	/**
	 * 
	 * getHospitalListWithTeamNum:(查询机构列表，包含团队个数 ). <br/>
	 * @author q
	 * @param vo
	 * @return
	 */
	public List<HospitalVo> getHospitalListWithTeamNum(HospitalVo vo);
	/**
	 * 
	 * getTeamInHospital:(获取机构下的医生团队列表 ). <br/>
	 * @author q
	 * @param orgId
	 * @return
	 */
	public List<HospitalVo> getTeamInHospital(String orgId);
	/**
	 * 
	 * getHospitalInfo:(获取医院信息). <br/>
	 * @author q
	 * @return
	 */
	public HospitalEntity getHospitalInfo(String orgId);
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
	 * 分页查询医院列表
	 * @param hosVo
	 * @return
	 */
	public List<HospitalVo> getHosList(HospitalVo hosVo);
	/**
	 * 新增医院
	 * @param hosEntity
	 * @return
	 */
	public int saveHos(HospitalEntity hosEntity);
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
