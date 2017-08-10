package com.boco.modules.fdoc.vo;

import java.sql.Date;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTeamIncrementEntity;

public class AppraisalMonthSignTeamIncrementVo extends AppraisalMonthSignTeamIncrementEntity{
	
	/**
	 * 团队队长姓名
	 */
	private String doctorName;
	
	/**
	 * 一个月开始日期
	 */
	private Date monthBegin;
	
	/**
	 * 一个月结束日期
	 */
	private Date monthEnd;
	
	/**
	 * 团队得分
	 */
	private double resultScore;
	
	/**
	 * 高血压签约得分（二类指标）
	 */
    private double signHyperScore;
    
    /**
	 * 糖尿病得分（二类指标）
	 */
    private double signDiabetesScore;
    
    /**
	 * 重性精神病签约得分（二类指标）
	 */
    private double signPhychosisScore;
    
    /**
	 * 签约管理老年人得分（二类指标）
	 */
    private double signOldScore;
    
    /**
	 * 孕产妇签约得分（二类指标）
	 */
    private double signMaternalScore;
    
    /**
	 * 儿童签约得分
	 */
    private double signChildrenScore;
    
    /**
	 * 签约管理得分（一类指标）
	 */
    private double signManageScore;
    
    /**
	 * 公卫服务高血压得分（二类指标）
	 */
    private double publicHealthHyperScore;
    
    /**
	 * 公卫服务糖尿病得分（二类指标）
	 */
    private double publicHealthDiabetesScore;
    
    /**
	 * 公卫服务重性精神病得分（二类指标）
	 */
    private double publicHealthPhychosisScore;
    
    /**
	 * 公卫服务老年人得分（二类指标）
	 */
    private double publicHealthOldScore;
    
    /**
	 * 公卫服务孕产妇得分
	 */
    private double publicHealthMaternalScore;
    
    /**
	 * 公卫服务儿童得分（二类指标）
	 */
    private double publicHealthChildrenScore;
    
    /**
	 * 公卫服务得分（一类指标）
	 */
    private double publicHealthScore;
    
    /**
	 * 健康管理健康教育得分（二类指标）
	 */
    private double healthManageEduScore;
    
    /**
	 * 健康管理日活跃量得分（二类指标）
	 */
    private double healthManageDailyActivityScore;
    
    /**
	 * 健康管理健康评估得分（二类指标）
	 */
    private double healthManageAssessmentScore;
    
    /**
	 * 健康管理建档得分（二类指标）
	 */
    private double healthManageDocumentScore;
    
    /**
	 * 健康管理得分（一类指标）
	 */
    private double healthManageScore;
    
    /**
	 * 居民满意度得分（一类得分）
	 */
    private double customerScore;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}

	public double getSignHyperScore() {
		return signHyperScore;
	}

	public void setSignHyperScore(double signHyperScore) {
		this.signHyperScore = signHyperScore;
	}

	public double getSignDiabetesScore() {
		return signDiabetesScore;
	}

	public void setSignDiabetesScore(double signDiabetesScore) {
		this.signDiabetesScore = signDiabetesScore;
	}

	public double getSignPhychosisScore() {
		return signPhychosisScore;
	}

	public void setSignPhychosisScore(double signPhychosisScore) {
		this.signPhychosisScore = signPhychosisScore;
	}

	public double getSignOldScore() {
		return signOldScore;
	}

	public void setSignOldScore(double signOldScore) {
		this.signOldScore = signOldScore;
	}

	public double getSignMaternalScore() {
		return signMaternalScore;
	}

	public void setSignMaternalScore(double signMaternalScore) {
		this.signMaternalScore = signMaternalScore;
	}

	public double getSignChildrenScore() {
		return signChildrenScore;
	}

	public void setSignChildrenScore(double signChildrenScore) {
		this.signChildrenScore = signChildrenScore;
	}

	public double getSignManageScore() {
		return signManageScore;
	}

	public void setSignManageScore(double signManageScore) {
		this.signManageScore = signManageScore;
	}

	public double getPublicHealthHyperScore() {
		return publicHealthHyperScore;
	}

	public void setPublicHealthHyperScore(double publicHealthHyperScore) {
		this.publicHealthHyperScore = publicHealthHyperScore;
	}

	public double getPublicHealthDiabetesScore() {
		return publicHealthDiabetesScore;
	}

	public void setPublicHealthDiabetesScore(double publicHealthDiabetesScore) {
		this.publicHealthDiabetesScore = publicHealthDiabetesScore;
	}

	public double getPublicHealthPhychosisScore() {
		return publicHealthPhychosisScore;
	}

	public void setPublicHealthPhychosisScore(double publicHealthPhychosisScore) {
		this.publicHealthPhychosisScore = publicHealthPhychosisScore;
	}

	public double getPublicHealthOldScore() {
		return publicHealthOldScore;
	}

	public void setPublicHealthOldScore(double publicHealthOldScore) {
		this.publicHealthOldScore = publicHealthOldScore;
	}

	public double getPublicHealthMaternalScore() {
		return publicHealthMaternalScore;
	}

	public void setPublicHealthMaternalScore(double publicHealthMaternalScore) {
		this.publicHealthMaternalScore = publicHealthMaternalScore;
	}

	public double getPublicHealthChildrenScore() {
		return publicHealthChildrenScore;
	}

	public void setPublicHealthChildrenScore(double publicHealthChildrenScore) {
		this.publicHealthChildrenScore = publicHealthChildrenScore;
	}

	public double getPublicHealthScore() {
		return publicHealthScore;
	}

	public void setPublicHealthScore(double publicHealthScore) {
		this.publicHealthScore = publicHealthScore;
	}

	public double getHealthManageEduScore() {
		return healthManageEduScore;
	}

	public void setHealthManageEduScore(double healthManageEduScore) {
		this.healthManageEduScore = healthManageEduScore;
	}

	public double getHealthManageDailyActivityScore() {
		return healthManageDailyActivityScore;
	}

	public void setHealthManageDailyActivityScore(
			double healthManageDailyActivityScore) {
		this.healthManageDailyActivityScore = healthManageDailyActivityScore;
	}

	public double getHealthManageAssessmentScore() {
		return healthManageAssessmentScore;
	}

	public void setHealthManageAssessmentScore(double healthManageAssessmentScore) {
		this.healthManageAssessmentScore = healthManageAssessmentScore;
	}

	public double getHealthManageDocumentScore() {
		return healthManageDocumentScore;
	}

	public void setHealthManageDocumentScore(double healthManageDocumentScore) {
		this.healthManageDocumentScore = healthManageDocumentScore;
	}

	public double getHealthManageScore() {
		return healthManageScore;
	}

	public void setHealthManageScore(double healthManageScore) {
		this.healthManageScore = healthManageScore;
	}

	public double getCustomerScore() {
		return customerScore;
	}

	public void setCustomerScore(double customerScore) {
		this.customerScore = customerScore;
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
