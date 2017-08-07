package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;

public class AppraisalMonthOrgScoreVo extends AppraisalMonthOrgScoreEntity{

	/**
	 * 慢病人数
	 */
	private Integer chronicDiseaseNumber;
	
	/**
	 * 机构名称
	 */
	private String orgName;
	
	/**
	 * 机构名称
	 */
	private String orgAddress;

	public Integer getChronicDiseaseNumber() {
		return chronicDiseaseNumber;
	}

	public void setChronicDiseaseNumber(Integer chronicDiseaseNumber) {
		this.chronicDiseaseNumber = chronicDiseaseNumber;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	 
	
}
