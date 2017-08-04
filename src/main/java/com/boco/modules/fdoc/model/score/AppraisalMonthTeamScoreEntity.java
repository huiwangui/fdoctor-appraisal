package com.boco.modules.fdoc.model.score;

import java.util.Date;

public class AppraisalMonthTeamScoreEntity {
	
	private Integer id;
	/**
	 * 团队ID
	 */
    private String teamId;
    /**
     * 签约人数
     */
    private Integer signIncrement;
    /**
     * 签约家庭户数
     */
    private Integer familyIncrement;
    /**
     * 签约管理得分
     */
    private Double signManageScore;
    /**
     * 公卫服务得分
     */
    private Double publicHealthScore;
    /**
     * 健康管理得分
     */
    private Double healthManageScore;
    /**
     * 居民满意度得分
     */
    private Double customerScore;
    /**
     * 总评得分
     */
    private Double resultSocre;
    /**
     * 统计的目标月份，格式yyyyMM，如201708
     */
    private String month;
    /**
     * 统计时间
     */
    private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getFamilyIncrement() {
		return familyIncrement;
	}
	public void setFamilyIncrement(Integer familyIncrement) {
		this.familyIncrement = familyIncrement;
	}
	public Double getSignManageScore() {
		return signManageScore;
	}
	public void setSignManageScore(Double signManageScore) {
		this.signManageScore = signManageScore;
	}
	public Double getPublicHealthScore() {
		return publicHealthScore;
	}
	public void setPublicHealthScore(Double publicHealthScore) {
		this.publicHealthScore = publicHealthScore;
	}
	public Double getHealthManageScore() {
		return healthManageScore;
	}
	public void setHealthManageScore(Double healthManageScore) {
		this.healthManageScore = healthManageScore;
	}
	public Double getCustomerScore() {
		return customerScore;
	}
	public void setCustomerScore(Double customerScore) {
		this.customerScore = customerScore;
	}
	public Double getResultSocre() {
		return resultSocre;
	}
	public void setResultSocre(Double resultSocre) {
		this.resultSocre = resultSocre;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
    
}
