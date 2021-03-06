package com.boco.modules.fdoc.model.sign;

import java.util.Date;

/**
 * Description 考核管理-团队签约管理原始数据月统计实体类
 * @author lzz
 * @date 2017年8月4日 下午3:05:22
 */
public class AppraisalMonthSignTeamIncrementEntity {
	
	/**
	 * 主键Id
	 */
	private Integer id;
	
	/**
	 * 团队Id
	 */
	private String teamId;

    /**
    * 签约总人数增量
    */
    private int signIncrement;

    /**
    * 高血压人数增量
    */
    private int hyperIncrement;

    /**
    * 糖尿病人数增量
    */
    private int diabetesIncrement;

    /**
    * 重性精神病人数增量
    */
    private int phychosisIncrement;

    /**
    * 老年人人数增量
    */
    private int oldIncrement;

    /**
    * 孕产妇人数增量
    */
    private int maternalIncrement;

    /**
    * 儿童人数增量
    */
    private int childrenIncrement;

    /**
    * 签约家庭户数增量
    */
    private int familyIncrement;

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

	public int getSignIncrement() {
		return signIncrement;
	}

	public void setSignIncrement(int signIncrement) {
		this.signIncrement = signIncrement;
	}

	public int getHyperIncrement() {
		return hyperIncrement;
	}

	public void setHyperIncrement(int hyperIncrement) {
		this.hyperIncrement = hyperIncrement;
	}

	public int getDiabetesIncrement() {
		return diabetesIncrement;
	}

	public void setDiabetesIncrement(int diabetesIncrement) {
		this.diabetesIncrement = diabetesIncrement;
	}

	public int getPhychosisIncrement() {
		return phychosisIncrement;
	}

	public void setPhychosisIncrement(int phychosisIncrement) {
		this.phychosisIncrement = phychosisIncrement;
	}

	public int getOldIncrement() {
		return oldIncrement;
	}

	public void setOldIncrement(int oldIncrement) {
		this.oldIncrement = oldIncrement;
	}

	public int getMaternalIncrement() {
		return maternalIncrement;
	}

	public void setMaternalIncrement(int maternalIncrement) {
		this.maternalIncrement = maternalIncrement;
	}

	public int getChildrenIncrement() {
		return childrenIncrement;
	}

	public void setChildrenIncrement(int childrenIncrement) {
		this.childrenIncrement = childrenIncrement;
	}

	public int getFamilyIncrement() {
		return familyIncrement;
	}

	public void setFamilyIncrement(int familyIncrement) {
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
