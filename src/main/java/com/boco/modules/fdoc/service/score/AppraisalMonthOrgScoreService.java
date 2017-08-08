package com.boco.modules.fdoc.service.score;

import java.util.List;
import java.util.Map;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;

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
	 * @return
	 */
	public Map<String, Object> getAppraisalMonthOrgScoreWithGrade(String month);

}
