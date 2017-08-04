package com.boco.modules.fdoc.model.public_health;

import java.util.Date;

public class AppraisalMonthPublicHealthTeamIncrementEntity {
	   
	    private Integer id;
        /**
         * 机构ID
         */
	    private String teamId;
	    /**
         * 服务次数
         */
	    private Integer serviceIncrement;
	    /**
         * 高血压服务次数
         */
	    private Integer hyperIncrement;
	    /**
         * 糖尿病服务次数
         */
	    private Integer diabetesIncrement;
	    /**
         * 重性精神病服务次数
         */
	    private Integer phychosisIncrement;
	    /**
         * 老年人服务次数
         */
	    private Integer oldIncrement;
	    /**
         * 孕产妇服务次数
         */
	    private Integer maternalIncrement;
	    /**
         * 儿童服务次数
         */
	    private Integer childrenIncrement;
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
		public Integer getServiceIncrement() {
			return serviceIncrement;
		}
		public void setServiceIncrement(Integer serviceIncrement) {
			this.serviceIncrement = serviceIncrement;
		}
		public Integer getHyperIncrement() {
			return hyperIncrement;
		}
		public void setHyperIncrement(Integer hyperIncrement) {
			this.hyperIncrement = hyperIncrement;
		}
		public Integer getDiabetesIncrement() {
			return diabetesIncrement;
		}
		public void setDiabetesIncrement(Integer diabetesIncrement) {
			this.diabetesIncrement = diabetesIncrement;
		}
		public Integer getPhychosisIncrement() {
			return phychosisIncrement;
		}
		public void setPhychosisIncrement(Integer phychosisIncrement) {
			this.phychosisIncrement = phychosisIncrement;
		}
		public Integer getOldIncrement() {
			return oldIncrement;
		}
		public void setOldIncrement(Integer oldIncrement) {
			this.oldIncrement = oldIncrement;
		}
		public Integer getMaternalIncrement() {
			return maternalIncrement;
		}
		public void setMaternalIncrement(Integer maternalIncrement) {
			this.maternalIncrement = maternalIncrement;
		}
		public Integer getChildrenIncrement() {
			return childrenIncrement;
		}
		public void setChildrenIncrement(Integer childrenIncrement) {
			this.childrenIncrement = childrenIncrement;
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
