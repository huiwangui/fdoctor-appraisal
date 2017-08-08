package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTeamIncrementEntity;

public class AppraisalMonthSignTeamIncrementVo extends AppraisalMonthSignTeamIncrementEntity{
	
	/**
	 * 团队队长姓名
	 */
	private String doctorName;
	
	/**
	 * 团队得分
	 */
	private double resultScore;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}
	
	
}
