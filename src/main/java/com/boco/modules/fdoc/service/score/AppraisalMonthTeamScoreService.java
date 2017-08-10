package com.boco.modules.fdoc.service.score;

import java.util.List;
import java.util.Map;

import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;

public interface AppraisalMonthTeamScoreService {

	/**
	 * Tilte: getTeamScoreList 
	 * Description:根据条件获取所有的医疗团队
	 * @return List<AppraisalMonthTeamScoreVo>
	 * @author h
	 * @param vo 
	 */
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList(AppraisalMonthTeamScoreVo vo);

	/**
	 * Tilte: getTeamScoreListCount 
	 * Description:根据条件获取所有的医疗团队总数
	 * @param vo
	 * @return int
	 * @author h
	 */
	public int getTeamScoreListCount(AppraisalMonthTeamScoreVo vo);
	
	/**
	 * Tilte: getAppraisalMonthTeamScoreByMonth 
	 * Description:根据月份查询指定团队信息
	 * @param entity
	 * @return List<AppraisalMonthTeamScoreVo>
	 * @author h
	 */
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByMonth(AppraisalMonthTeamScoreEntity entity);

	/**
	 * Tilte: getAppraisalMonthTeamScoreByTeamId 
	 * Description:根据团队id查询实力
	 * @param teamId
	 * @return AppraisalMonthTeamScoreVo
	 * @author h
	 */
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByTeamId(String teamId);
	
	/**
	 * Tilte: getAppraisalMonthTeamScoreListByMonth 
	 * Description:根据月份获取医生团队列表
	 * @param month
	 * @return List<AppraisalMonthTeamScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthTeamScoreVo> getAppraisalMonthTeamScoreListByMonth(String month);

	/**
	 * 按照分数线对月份团队得分数据进行分组
	 * @param month
	 * @param target：判断优秀的目标字段，比如需要查找“高血压得分”的优秀团队，传入signHyperScore(AppraisalFieldTargetConstans中的静态属性)
	 * @return
	 */
	public Map<String, Object> getAppraisalMonthTeamScoreWithGrade(String month, String target) throws Exception;

}
