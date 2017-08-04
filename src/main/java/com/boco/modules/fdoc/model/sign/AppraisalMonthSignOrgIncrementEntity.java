package com.boco.modules.fdoc.model.sign;

import java.util.Date;

/**
 * 考核管理-机构签约管理原始数据月统计实体类
 * @author q
 *
 */
public class AppraisalMonthSignOrgIncrementEntity {
	
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 机构ID
    */
    private String orgId;
    
    /**
    * 签约总人数增量
    */
    private Integer signIncrement;

    /**
    * 高血压人数增量
    */
    private Integer hyperIncrement;

    /**
    * 糖尿病人数增量
    */
    private Integer diabetesIncrement;

    /**
    * 重性精神病人数增量
    */
    private Integer phychosisIncrement;

    /**
    * 老年人人数增量
    */
    private Integer oldIncrement;

    /**
    * 孕产妇人数增量
    */
    private Integer maternalIncrement;

    /**
    * 儿童人数增量
    */
    private Integer childrenIncrement;

    /**
    * 签约家庭户数增量
    */
    private Integer familyIncrement;

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

	public Integer getFamilyIncrement() {
		return familyIncrement;
	}

	public void setFamilyIncrement(Integer familyIncrement) {
		this.familyIncrement = familyIncrement;
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