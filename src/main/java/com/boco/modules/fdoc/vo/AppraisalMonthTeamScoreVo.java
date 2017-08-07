package com.boco.modules.fdoc.vo;

import com.boco.common.persistence.Page;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;

public class AppraisalMonthTeamScoreVo extends AppraisalMonthTeamScoreEntity{
   /**
    * 团队名称
    */
	private String teamName;
	/**
	 * 医生名字
	 */
	private String doctorName;
	
	/**
	 * 机构id
	 */
	private String orgId;
	
	/**
	 * 签约户数/人数
	 */
	private String signFamilyAndPerson;
	/**
	 * 慢病人数
	 */
	private Integer chronicDiseaseNumber;
	
	/**
	 * 机构名称
	 */
	private String orgName;
	
	/**
	 * 机构地址
	 */
	private String orgAddress;
	/*
	 * 分页控件
	 */
	private Page<AppraisalMonthTeamScoreVo> page;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Page<AppraisalMonthTeamScoreVo> getPage() {
		return page;
	}

	public void setPage(Page<AppraisalMonthTeamScoreVo> page) {
		this.page = page;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSignFamilyAndPerson() {
		return signFamilyAndPerson;
	}

	public void setSignFamilyAndPerson(String signFamilyAndPerson) {
		this.signFamilyAndPerson = signFamilyAndPerson;
	}

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
