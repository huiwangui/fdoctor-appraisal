package com.boco.modules.fdoc.vo;

public class MaptoBeanVo {
	
	
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 机构ID
    */
    private String orgId;
    /**
     * 机构ID
     */
     private String teamId;
     
     /**
     * 签约总人数增量
     */
     private Integer signIncrement;

    
    /**
    * 签约总人数增量分数
    */
    private Double signIncrementScore;

    /**
    * 高血压人数增量分数
    */
    private Double hyperIncrementScore;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public Integer getSignIncrement() {
		return signIncrement;
	}

	public void setSignIncrement(Integer signIncrement) {
		this.signIncrement = signIncrement;
	}

	public Double getSignIncrementScore() {
		return signIncrementScore;
	}

	public void setSignIncrementScore(Double signIncrementScore) {
		this.signIncrementScore = signIncrementScore;
	}

	public Double getHyperIncrementScore() {
		return hyperIncrementScore;
	}

	public void setHyperIncrementScore(Double hyperIncrementScore) {
		this.hyperIncrementScore = hyperIncrementScore;
	}

	public Double getDiabetesIncrementScore() {
		return diabetesIncrementScore;
	}

	public void setDiabetesIncrementScore(Double diabetesIncrementScore) {
		this.diabetesIncrementScore = diabetesIncrementScore;
	}

	public Double getPhychosisIncrementScore() {
		return phychosisIncrementScore;
	}

	public void setPhychosisIncrementScore(Double phychosisIncrementScore) {
		this.phychosisIncrementScore = phychosisIncrementScore;
	}

	public Double getOldIncrementScore() {
		return oldIncrementScore;
	}

	public void setOldIncrementScore(Double oldIncrementScore) {
		this.oldIncrementScore = oldIncrementScore;
	}

	public Double getMaternalIncrementScore() {
		return maternalIncrementScore;
	}

	public void setMaternalIncrementScore(Double maternalIncrementScore) {
		this.maternalIncrementScore = maternalIncrementScore;
	}

	public Double getChildrenIncrementScore() {
		return childrenIncrementScore;
	}

	public void setChildrenIncrementScore(Double childrenIncrementScore) {
		this.childrenIncrementScore = childrenIncrementScore;
	}

	public Integer getFamilyIncrement() {
		return familyIncrement;
	}

	public void setFamilyIncrement(Integer familyIncrement) {
		this.familyIncrement = familyIncrement;
	}

	/**
    * 糖尿病人数增量分数
    */
    private Double diabetesIncrementScore;

    /**
    * 重性精神病人数增量分数
    */
    private Double phychosisIncrementScore;

    /**
    * 老年人人数增量分数
    */
    private Double oldIncrementScore;

    /**
    * 孕产妇人数增量分数
    */
    private Double maternalIncrementScore;

    /**
    * 儿童人数增量分数
    */
    private Double childrenIncrementScore;

    /**
    * 签约家庭户数增量分数
    */
    private Integer familyIncrement;


}
