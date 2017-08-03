package com.boco.modules.fdoc.model.sign;

import java.util.Date;

/**
 * 考核管理-机构签约管理原始数据月统计实体类
 * @author q
 *
 */
public class AppraisalMonthSignOrgBasedataEntity {
	
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 机构ID
    */
    private String orgId;

    /**
    * 签约总人数
    */
    private Integer signCount;

    /**
    * 高血压人数
    */
    private Integer hyperCount;

    /**
    * 糖尿病人数
    */
    private Integer diabetesCount;

    /**
    * 重性精神病人数
    */
    private Integer phychosisCount;

    /**
    * 老年人人数
    */
    private Integer oldCount;

    /**
    * 孕产妇人数
    */
    private Integer maternalCount;

    /**
    * 儿童人数
    */
    private Integer childrenCount;

    /**
    * 签约家庭户数
    */
    private Integer familyCount;

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

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getHyperCount() {
        return hyperCount;
    }

    public void setHyperCount(Integer hyperCount) {
        this.hyperCount = hyperCount;
    }

    public Integer getDiabetesCount() {
        return diabetesCount;
    }

    public void setDiabetesCount(Integer diabetesCount) {
        this.diabetesCount = diabetesCount;
    }

    public Integer getPhychosisCount() {
        return phychosisCount;
    }

    public void setPhychosisCount(Integer phychosisCount) {
        this.phychosisCount = phychosisCount;
    }

    public Integer getOldCount() {
        return oldCount;
    }

    public void setOldCount(Integer oldCount) {
        this.oldCount = oldCount;
    }

    public Integer getMaternalCount() {
        return maternalCount;
    }

    public void setMaternalCount(Integer maternalCount) {
        this.maternalCount = maternalCount;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public Integer getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(Integer familyCount) {
        this.familyCount = familyCount;
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