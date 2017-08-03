package com.boco.modules.fdoc.model.public_health;

import java.util.Date;

public class AppraisalMonthPublicHealthOrgBasedataEntity {
    private Integer id;

    /**
    * 机构ID
    */
    private String orgId;

    /**
    * 服务总次数
    */
    private Integer serviceCount;

    /**
    * 高血压服务次数
    */
    private Integer hyperCount;

    /**
    * 糖尿病服务次数
    */
    private Integer diabetesCount;

    /**
    * 重性精神病服务次数
    */
    private Integer phychosisCount;

    /**
    * 老年人服务次数
    */
    private Integer oldCount;

    /**
    * 孕产妇服务次数
    */
    private Integer maternalCount;

    /**
    * 儿童服务次数
    */
    private Integer childrenCount;

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

    public Integer getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        this.serviceCount = serviceCount;
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