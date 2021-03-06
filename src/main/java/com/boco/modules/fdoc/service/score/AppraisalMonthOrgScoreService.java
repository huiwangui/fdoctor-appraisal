package com.boco.modules.fdoc.service.score;

import java.util.List;
import java.util.Map;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;

public interface AppraisalMonthOrgScoreService {
	
	/**
	 * Tilte: getorganizationList 
	 * Description:获取所有机构
	 * @return List<AppraisalMonthOrgScoreEntity>
	 * @author h
	 */
	public List<HospitalEntity> getHospitalList();
	
	/**
	 * Tilte: getAppraisalMonthOrgScoreByMonth 
	 * Description:根据月份获取机构当月信息
	 * @param entity
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity);

	/**
	 * Tilte: getAppraisalMonthOrgScoreListByMonth 
	 * Description:根据月份获取机构列表
	 * @param month
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month);
	
	/**
	 * 按照分数线对月份机构得分数据进行分组
	 * @param month
	 * @param target：判断优秀的目标字段，比如需要查找“高血压得分”的优秀团队，传入signHyperScore(AppraisalFieldTargetConstans中的静态属性)
	 * @return
	 */
	public Map<String, Object> getAppraisalMonthOrgScoreWithGrade(String month, String target) throws Exception;

	/**
	 * Tilte: getOrganizationScoreList 
	 * Description:根据月份获取所有医疗机构
	 * @param vo
	 * @return List<AppraisalMonthOrgScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthOrgScoreVo> getOrganizationScoreList(AppraisalMonthOrgScoreVo vo);

	/**
	 * Tilte: getOrganizationScoreListCount 
	 * Description:根据月份获取所有医疗机构总数
	 * @param vo
	 * @return int
	 * @author h
	 */
	public int getOrganizationScoreListCount(AppraisalMonthOrgScoreVo vo);

	/**
	 * Tilte: getAppraisalMonthOrgScoreByOrgId 
	 * Description:获取指定机构的实力
	 * @param orgId
	 * @return AppraisalMonthOrgScoreVo
	 * @author h
	 */
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByOrgId(String orgId);
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(AppraisalMonthOrgScoreEntity entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return 影响行数
	 */
	public int update(AppraisalMonthOrgScoreEntity entity);
    /**
     * 插入数据   （todo:随访体检 和健康管理 要到dozer-mapping.xml下配置对象映射关系）
     * @param list1 机构签约管理增长列表
     * @param listPublicHealthVo 机构随访体检增长列表
     * @param listHealthMange   机构健康管理增长列表
     * @return
     * @throws Exception
     *
     */
	public int insert(List<AppraisalMonthSignOrgIncrementVo> list1,List<?> listPublicHealthVo,List<?> listHealthMange)throws Exception;
	 /**
     * 插入数据   （）
     * @param list 机构列表
     * @param month 插入的月份
     * @return  新增条数
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
     *
     */
	public int insert( List<HospitalEntity> list ,String month) throws IllegalArgumentException, IllegalAccessException;
	
	
	/**
	 * 获取团队数量
	 * @param orgId
	 * @return
	 *
	 */
	public int getTeamCount(String orgId);
	
	/**
	 * 获取得分（通过团队得分表算的平均分）
	 * @param map
	 * @return
	 *
	 */
	AppraisalMonthOrgScoreEntity getScoreByOrgIdAndMonth(Map map);
}
