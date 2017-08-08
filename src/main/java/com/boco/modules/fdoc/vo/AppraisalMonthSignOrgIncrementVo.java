package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;

/**
 * 考核管理-机构签约管理原始数据月统计VO
 * @author q
 *
 */
public class AppraisalMonthSignOrgIncrementVo extends AppraisalMonthSignOrgIncrementEntity{
	/**
	 * 机构名
	 */
	private String orgName;
	
	/**
	 * 总计得分
	 */
	private double resultScore;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}
	
}
