package com.boco.modules.fdoc.dao.score;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.common.persistence.CrudDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;

@MyBatisDao
public interface AppraisalMonthTeamScoreDao extends CrudDao<AppraisalMonthTeamScoreEntity>{
	/**
	 * Tilte: getTeamScoreList 
	 * Description:获取所有的医疗团队
	 * @return List<AppraisalMonthTeamScoreVo>
	 * @author h
	 */
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList();
}
