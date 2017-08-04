package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;

public class AppraisalMonthTeamScoreVo extends AppraisalMonthTeamScoreEntity{
   /**
    * 团队名称
    */
	private String teamName;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
