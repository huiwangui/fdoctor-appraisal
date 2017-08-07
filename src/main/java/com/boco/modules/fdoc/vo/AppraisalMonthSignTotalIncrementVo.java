package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;

/**
 * 签约管理总量vo
 * @author q
 *
 */
public class AppraisalMonthSignTotalIncrementVo extends AppraisalMonthSignTotalIncrementEntity{
	/**
	 * 高血压占比
	 */
	private Double hyperProportion;
	
	/**
	 * 糖尿病占比
	 */
	private Double diabetesProportion;
	
	/**
	 * 重性精神病占比
	 */
	private Double phychosisProportion;
	
	/**
	 * 老年人占比
	 */
	private Double oldProportion;
	
	/**
	 * 孕产妇占比
	 */
	private Double maternalProportion;
	
	/**
	 * 儿童占比
	 */
	private Double childrenProportion;
	

	public Double getHyperProportion() {
		return hyperProportion;
	}

	public void setHyperProportion(Double hyperProportion) {
		this.hyperProportion = hyperProportion;
	}

	public Double getDiabetesProportion() {
		return diabetesProportion;
	}

	public void setDiabetesProportion(Double diabetesProportion) {
		this.diabetesProportion = diabetesProportion;
	}

	public Double getPhychosisProportion() {
		return phychosisProportion;
	}

	public void setPhychosisProportion(Double phychosisProportion) {
		this.phychosisProportion = phychosisProportion;
	}

	public Double getOldProportion() {
		return oldProportion;
	}

	public void setOldProportion(Double oldProportion) {
		this.oldProportion = oldProportion;
	}

	public Double getMaternalProportion() {
		return maternalProportion;
	}

	public void setMaternalProportion(Double maternalProportion) {
		this.maternalProportion = maternalProportion;
	}

	public Double getChildrenProportion() {
		return childrenProportion;
	}

	public void setChildrenProportion(Double childrenProportion) {
		this.childrenProportion = childrenProportion;
	}
	
	
}
