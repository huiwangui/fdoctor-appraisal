package com.boco.modules.fdoc.service.score.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.score.AppraisalMonthTeamScoreDao;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
@Service
public class AppraisalMonthTeamScoreServiceImpl implements AppraisalMonthTeamScoreService {
	@Resource
	AppraisalMonthTeamScoreDao appraisalMonthTeamScoreDao;
	@Override
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList() {	 
		return appraisalMonthTeamScoreDao.getTeamScoreList();
	}

}
