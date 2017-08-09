package com.boco.modules.fdoc.vo;

import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;

/**
 * 考核管理-机构签约管理原始数据月统计VO
 * @author q
 *
 */
public class AppraisalMonthSignOrgIncrementVo extends AppraisalMonthSignOrgIncrementEntity{
	/**
	 * 机构名
	 */
	private String orgName;
	
	/**
	 * 总计得分
	 */
	private double resultScore;
	
	/**
	 * 高血压签约得分（二类指标）
	 */
    private Double signHyperScore;
    
    /**
	 * 糖尿病得分（二类指标）
	 */
    private Double signDiabetesScore;
    
    /**
	 * 重性精神病签约得分（二类指标）
	 */
    private Double signPhychosisScore;
    
    /**
	 * 签约管理老年人得分（二类指标）
	 */
    private Double signOldScore;
    
    /**
	 * 孕产妇签约得分（二类指标）
	 */
    private Double signMaternalScore;
    
    /**
	 * 儿童签约得分
	 */
    private Double signChildrenScore;
    
    /**
	 * 签约管理得分（一类指标）
	 */
    private Double signManageScore;
    
    /**
	 * 公卫服务高血压得分（二类指标）
	 */
    private Double publicHealthHyperScore;
    
    /**
	 * 公卫服务糖尿病得分（二类指标）
	 */
    private Double publicHealthDiabetesScore;
    
    /**
	 * 公卫服务重性精神病得分（二类指标）
	 */
    private Double publicHealthPhychosisScore;
    
    /**
	 * 公卫服务老年人得分（二类指标）
	 */
    private Double publicHealthOldScore;
    
    /**
	 * 公卫服务孕产妇得分
	 */
    private Double publicHealthMaternalScore;
    
    /**
	 * 公卫服务儿童得分（二类指标）
	 */
    private Double publicHealthChildrenScore;
    
    /**
	 * 公卫服务得分（一类指标）
	 */
    private Double publicHealthScore;
    
    /**
	 * 健康管理健康教育得分（二类指标）
	 */
    private Double healthManageEduScore;
    
    /**
	 * 健康管理日活跃量得分（二类指标）
	 */
    private Double healthManageDailyActivityScore;
    
    /**
	 * 健康管理健康评估得分（二类指标）
	 */
    private Double healthManageAssessmentScore;
    
    /**
	 * 健康管理建档得分（二类指标）
	 */
    private Double healthManageDocumentScore;
    
    /**
	 * 健康管理得分（一类指标）
	 */
    private Double healthManageScore;
    
    /**
	 * 居民满意度得分（一类得分）
	 */
    private Double customerScore;
    

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}

	public Double getSignHyperScore() {
		return signHyperScore;
	}

	public void setSignHyperScore(Double signHyperScore) {
		this.signHyperScore = signHyperScore;
	}

	public Double getSignDiabetesScore() {
		return signDiabetesScore;
	}

	public void setSignDiabetesScore(Double signDiabetesScore) {
		this.signDiabetesScore = signDiabetesScore;
	}

	public Double getSignPhychosisScore() {
		return signPhychosisScore;
	}

	public void setSignPhychosisScore(Double signPhychosisScore) {
		this.signPhychosisScore = signPhychosisScore;
	}

	public Double getSignOldScore() {
		return signOldScore;
	}

	public void setSignOldScore(Double signOldScore) {
		this.signOldScore = signOldScore;
	}

	public Double getSignMaternalScore() {
		return signMaternalScore;
	}

	public void setSignMaternalScore(Double signMaternalScore) {
		this.signMaternalScore = signMaternalScore;
	}

	public Double getSignChildrenScore() {
		return signChildrenScore;
	}

	public void setSignChildrenScore(Double signChildrenScore) {
		this.signChildrenScore = signChildrenScore;
	}

	public Double getSignManageScore() {
		return signManageScore;
	}

	public void setSignManageScore(Double signManageScore) {
		this.signManageScore = signManageScore;
	}

	public Double getPublicHealthHyperScore() {
		return publicHealthHyperScore;
	}

	public void setPublicHealthHyperScore(Double publicHealthHyperScore) {
		this.publicHealthHyperScore = publicHealthHyperScore;
	}

	public Double getPublicHealthDiabetesScore() {
		return publicHealthDiabetesScore;
	}

	public void setPublicHealthDiabetesScore(Double publicHealthDiabetesScore) {
		this.publicHealthDiabetesScore = publicHealthDiabetesScore;
	}

	public Double getPublicHealthPhychosisScore() {
		return publicHealthPhychosisScore;
	}

	public void setPublicHealthPhychosisScore(Double publicHealthPhychosisScore) {
		this.publicHealthPhychosisScore = publicHealthPhychosisScore;
	}

	public Double getPublicHealthOldScore() {
		return publicHealthOldScore;
	}

	public void setPublicHealthOldScore(Double publicHealthOldScore) {
		this.publicHealthOldScore = publicHealthOldScore;
	}

	public Double getPublicHealthMaternalScore() {
		return publicHealthMaternalScore;
	}

	public void setPublicHealthMaternalScore(Double publicHealthMaternalScore) {
		this.publicHealthMaternalScore = publicHealthMaternalScore;
	}

	public Double getPublicHealthChildrenScore() {
		return publicHealthChildrenScore;
	}

	public void setPublicHealthChildrenScore(Double publicHealthChildrenScore) {
		this.publicHealthChildrenScore = publicHealthChildrenScore;
	}

	public Double getPublicHealthScore() {
		return publicHealthScore;
	}

	public void setPublicHealthScore(Double publicHealthScore) {
		this.publicHealthScore = publicHealthScore;
	}

	public Double getHealthManageEduScore() {
		return healthManageEduScore;
	}

	public void setHealthManageEduScore(Double healthManageEduScore) {
		this.healthManageEduScore = healthManageEduScore;
	}

	public Double getHealthManageDailyActivityScore() {
		return healthManageDailyActivityScore;
	}

	public void setHealthManageDailyActivityScore(
			Double healthManageDailyActivityScore) {
		this.healthManageDailyActivityScore = healthManageDailyActivityScore;
	}

	public Double getHealthManageAssessmentScore() {
		return healthManageAssessmentScore;
	}

	public void setHealthManageAssessmentScore(Double healthManageAssessmentScore) {
		this.healthManageAssessmentScore = healthManageAssessmentScore;
	}

	public Double getHealthManageDocumentScore() {
		return healthManageDocumentScore;
	}

	public void setHealthManageDocumentScore(Double healthManageDocumentScore) {
		this.healthManageDocumentScore = healthManageDocumentScore;
	}

	public Double getHealthManageScore() {
		return healthManageScore;
	}

	public void setHealthManageScore(Double healthManageScore) {
		this.healthManageScore = healthManageScore;
	}

	public Double getCustomerScore() {
		return customerScore;
	}

	public void setCustomerScore(Double customerScore) {
		this.customerScore = customerScore;
	}
}
