package com.boco.modules.fdoc.model.score;

import java.util.Date;

public class AppraisalMonthOrgScoreEntity {
	    
	    private Integer id;
	    /**
	     * 团队ID
	     */
	    private String orgId;
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
	     * 团队数量
	     */
	    private Integer teamTotal;
	    /**
	     * 不合格团队数量
	     */
	    private Integer unQualifiedIncrement;
	    /**
	     * 合格团队数量
	     */
	    private Integer qualifiedIncrement;
	    /**
	     * 优秀团队数量
	     */
	    private Integer excellentIncrement;
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
		public String getOrgId() {
			return orgId;
		}
		public void setOrgId(String orgId) {
			this.orgId = orgId;
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
		public Integer getTeamTotal() {
			return teamTotal;
		}
		public void setTeamTotal(Integer teamTotal) {
			this.teamTotal = teamTotal;
		}
		public Integer getUnQualifiedIncrement() {
			return unQualifiedIncrement;
		}
		public void setUnQualifiedIncrement(Integer unQualifiedIncrement) {
			this.unQualifiedIncrement = unQualifiedIncrement;
		}
		public Integer getQualifiedIncrement() {
			return qualifiedIncrement;
		}
		public void setQualifiedIncrement(Integer qualifiedIncrement) {
			this.qualifiedIncrement = qualifiedIncrement;
		}
		public Integer getExcellentIncrement() {
			return excellentIncrement;
		}
		public void setExcellentIncrement(Integer excellentIncrement) {
			this.excellentIncrement = excellentIncrement;
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
