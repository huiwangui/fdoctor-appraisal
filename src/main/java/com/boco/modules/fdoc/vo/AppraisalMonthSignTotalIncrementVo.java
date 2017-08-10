package com.boco.modules.fdoc.vo;

import java.util.Date;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;

/**
 * 签约管理总量vo
 * @author q
 *
 */
public class AppraisalMonthSignTotalIncrementVo extends AppraisalMonthSignTotalIncrementEntity{
	
	/**
	 * 一个月开始日期
	 */
	private Date monthBegin;
	
	/**
	 * 一个月结束日期
	 */
	private Date monthEnd;
	
	/**
	 * 高血压占比
	 */
	private double hyperProportion;
	
	/**
	 * 糖尿病占比
	 */
	private double diabetesProportion;
	
	/**
	 * 重性精神病占比
	 */
	private double phychosisProportion;
	
	/**
	 * 老年人占比
	 */
	private double oldProportion;
	
	/**
	 * 孕产妇占比
	 */
	private double maternalProportion;
	
	/**
	 * 儿童占比
	 */
	private double childrenProportion;
	

	public double getHyperProportion() {
		return hyperProportion;
	}

	public void setHyperProportion(double hyperProportion) {
		this.hyperProportion = hyperProportion;
	}

	public double getDiabetesProportion() {
		return diabetesProportion;
	}

	public void setDiabetesProportion(double diabetesProportion) {
		this.diabetesProportion = diabetesProportion;
	}

	public double getPhychosisProportion() {
		return phychosisProportion;
	}

	public void setPhychosisProportion(double phychosisProportion) {
		this.phychosisProportion = phychosisProportion;
	}

	public double getOldProportion() {
		return oldProportion;
	}

	public void setOldProportion(double oldProportion) {
		this.oldProportion = oldProportion;
	}

	public double getMaternalProportion() {
		return maternalProportion;
	}

	public void setMaternalProportion(double maternalProportion) {
		this.maternalProportion = maternalProportion;
	}

	public double getChildrenProportion() {
		return childrenProportion;
	}

	public void setChildrenProportion(double childrenProportion) {
		this.childrenProportion = childrenProportion;
	}

	public Date getMonthBegin() {
		return monthBegin;
	}

	public void setMonthBegin(Date monthBegin) {
		this.monthBegin = monthBegin;
	}

	public Date getMonthEnd() {
		return monthEnd;
	}

	public void setMonthEnd(Date monthEnd) {
		this.monthEnd = monthEnd;
	}
	
	
}
