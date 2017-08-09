package com.boco.modules.fdoc.vo;

import java.util.HashMap;
import java.util.Map;

import com.boco.common.persistence.Page;
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
	
	/**
	 * 签约户数/人数
	 */
	private String signFamilyAndPerson;
	/**
	 * 存放orgId与month属性
	 */
	private Map<String, Object> map;
	 
	/*
	 * 分页控件
	 */
	private Page<AppraisalMonthOrgScoreVo> page;
	
	public Map<String, Object> getMap() {		 
    	Map<String,Object> map=new HashMap<String,Object> ();
    	map.put("orgId", this.getOrgId());
    	map.put("month", this.getMonth());
		return map;
	 
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

	public String getSignFamilyAndPerson() {
		return signFamilyAndPerson;
	}

	public void setSignFamilyAndPerson(String signFamilyAndPerson) {
		this.signFamilyAndPerson = signFamilyAndPerson;
	}

	public Page<AppraisalMonthOrgScoreVo> getPage() {
		return page;
	}

	public void setPage(Page<AppraisalMonthOrgScoreVo> page) {
		this.page = page;
	}

	 
	
}
