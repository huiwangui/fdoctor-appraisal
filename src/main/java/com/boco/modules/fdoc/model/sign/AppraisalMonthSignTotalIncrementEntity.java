package com.boco.modules.fdoc.model.sign;

import java.util.Date;

/**
 * Description 考核管理-签约管理原始总数据月统计实体类
 * @author lzz
 * @date 2017年8月4日 下午3:13:10
 */
public class AppraisalMonthSignTotalIncrementEntity {
	/**
	 * 主键Id
	 */
	private Integer id;
	
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
