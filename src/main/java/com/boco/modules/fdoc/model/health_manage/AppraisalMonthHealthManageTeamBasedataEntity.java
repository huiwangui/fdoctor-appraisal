package com.boco.modules.fdoc.model.health_manage;

import java.util.Date;

/**
 * 考核管理-团队健康管理原始数据月统计实体类
 * @author j
 *
 */
public class AppraisalMonthHealthManageTeamBasedataEntity {
	
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 团队ID
    */
    private String teamId;

    /**
    * 健康教育次数
    */
    private Integer educationIncrement;

    /**
    * 日活跃量
    */
    private Integer dailyActivity;

    /**
    * 健康评估次数
    */
    private Integer assessmentIncrement;

    /**
    * 建档数
    */
    private Integer documentIncrement;

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

	public Integer getDailyActivity() {
        return dailyActivity;
    }

    public void setDailyActivity(Integer dailyActivity) {
        this.dailyActivity = dailyActivity;
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

	public Integer getEducationIncrement() {
		return educationIncrement;
	}

	public void setEducationIncrement(Integer educationIncrement) {
		this.educationIncrement = educationIncrement;
	}

	public Integer getAssessmentIncrement() {
		return assessmentIncrement;
	}

	public void setAssessmentIncrement(Integer assessmentIncrement) {
		this.assessmentIncrement = assessmentIncrement;
	}

	public Integer getDocumentIncrement() {
		return documentIncrement;
	}

	public void setDocumentIncrement(Integer documentIncrement) {
		this.documentIncrement = documentIncrement;
	}
    
    
}