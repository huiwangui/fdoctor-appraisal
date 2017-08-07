package com.boco.modules.fdoc.dao.system;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.system.DoctorEntity;
import com.boco.modules.fdoc.vo.DoctorDetailVo;
/**
 * 
 * @author lzz
 * 
 */
@MyBatisDao
public interface DoctorDao extends CrudDao<DoctorEntity>{
	/**
	 * 
	 * getDoctorInfo:(查看医生信息). <br/>
	 * @author q
	 * @param id
	 * @return
	 */
	public DoctorDetailVo getDoctorInfo(String id);
	
	/**
	 * 
	 * getDoctorTeamMemberByTeamId:(根据团队ID获取其团队成员). <br/>
	 * @author q
	 * @param teamId
	 * @return
	 */
	public List<DoctorDetailVo> getDoctorTeamMemberByTeamId(String teamId);
	
	/**
	 * 
	 * getDoctorTeamMemberByDocId:(根据医生ID获取其团队成员，排除自己在外). <br/>
	 * @author q
	 * @param docId
	 * @return
	 */
	public List<DoctorDetailVo> getDoctorTeamMemberByDocId(String docId);
	/**
	 * 
	 * getDoctorInfo:(获取团队队长，即为团队内医生的信息). <br/>
	 * @author q
	 * @param id
	 * @return
	 */
	public DoctorDetailVo getTeamLeaderInfo(String teamId);
	/**
	 * 
	 * getDoctorList:(获取医生列表). <br/>
	 * @author q
	 * @param vo
	 * @return
	 */
	public List<DoctorDetailVo> getDoctorList(DoctorDetailVo vo);
	/**
	 * 
	 * getDoctorList:(获取医生列表). <br/>
	 * @author q
	 * @param vo
	 * @return
	 */
	public List<DoctorDetailVo> getDocList(DoctorDetailVo docVo);
	/**
	 * 
	 * getDoctorCount:(获取医生数量). <br/>
	 * @author q
	 * @param docName
	 * @return
	 */
	public Integer getDoctorCount(DoctorDetailVo vo);

	/**
	 * 
	 * getTeamCount:(获取医生团队总数). <br/>
	 * @author q
	 * @return
	 */
	public Integer getTeamCount();
	/**
	 * 
	 * getTeamIdsByHospital:(通过机构ID获取机构下的团队ID集合). <br/>
	 * @author q
	 * @param orgId
	 * @return
	 */
	public List<String> getTeamIdsByHospital(String orgId);

	/**
	 * 获取团队队长信息列表
	 * @param docVo
	 * @return
	 */
	public List<DoctorDetailVo> getLeaderList(DoctorDetailVo docVo);

	/**
	 * 获取队长数
	 * @param countVo
	 * @return
	 */
	public int getLeaderCount(DoctorDetailVo countVo);

	/**
	 * 根据医院和医生种类获取医生列表
	 * @param docVo
	 * @return
	 */
	public List<DoctorDetailVo> getDocByType(DoctorDetailVo docVo);


}
