package com.boco.modules.fdoc.model.health_manage;

import java.util.Date;

/**
 * 考核管理-机构健康管理原始数据月统计实体类
 * @author q
 *
 */
public class AppraisalMonthHealthManageOrgBasedataEntity {
	
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 机构ID
    */
    private String orgId;

    /**
    * 健康教育次数
    */
    private Integer educationCount;

    /**
    * 日活跃量
    */
    private Integer dailyActivity;

    /**
    * 健康评估次数
    */
    private Integer assessmentCount;

    /**
    * 建档数
    */
    private Integer documentCount;

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

    public Integer getEducationCount() {
        return educationCount;
    }

    public void setEducationCount(Integer educationCount) {
        this.educationCount = educationCount;
    }

    public Integer getDailyActivity() {
        return dailyActivity;
    }

    public void setDailyActivity(Integer dailyActivity) {
        this.dailyActivity = dailyActivity;
    }

    public Integer getAssessmentCount() {
        return assessmentCount;
    }

    public void setAssessmentCount(Integer assessmentCount) {
        this.assessmentCount = assessmentCount;
    }

    public Integer getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(Integer documentCount) {
        this.documentCount = documentCount;
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