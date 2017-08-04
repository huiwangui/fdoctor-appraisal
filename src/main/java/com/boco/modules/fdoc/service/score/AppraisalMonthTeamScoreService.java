package com.boco.modules.fdoc.service.score;

import java.util.List;

import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;

public interface AppraisalMonthTeamScoreService {

	/**
	 * Tilte: getTeamScoreList 
	 * Description:获取所有的医疗团队
	 * @return List<AppraisalMonthTeamScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList();

}
