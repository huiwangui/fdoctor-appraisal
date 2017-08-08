package com.boco.modules.fdoc.service.score.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.score.AppraisalMonthTeamScoreDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
@Service
public class AppraisalMonthTeamScoreServiceImpl implements AppraisalMonthTeamScoreService {
	@Resource
	AppraisalMonthTeamScoreDao appraisalMonthTeamScoreDao;
	@Override
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList(AppraisalMonthTeamScoreVo vo) {	 
		return appraisalMonthTeamScoreDao.getTeamScoreList(vo);
	}
	@Override
	public int getTeamScoreListCount(AppraisalMonthTeamScoreVo vo) {		 
		return appraisalMonthTeamScoreDao.getTeamScoreListCount(vo);
	}
	@Override
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByMonth(AppraisalMonthTeamScoreEntity entity) {		 
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreByMonth(entity);
	}
	@Override
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByTeamId(String teamId) {		 
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreByTeamId(teamId);
	}
	@Override
	public List<AppraisalMonthTeamScoreVo> getAppraisalMonthTeamScoreListByMonth(String month) {	 
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreListByMonth(month);
	}

}
