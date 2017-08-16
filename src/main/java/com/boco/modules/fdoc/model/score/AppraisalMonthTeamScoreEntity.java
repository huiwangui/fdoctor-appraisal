package com.boco.modules.fdoc.model.score;

import java.util.Date;

/**
 * Tilte: AppraisalMonthTeamScoreEntity Description:考核管理-团队月得分实体类
 * 
 * @author h
 * @date 2017年8月4日下午5:57:17
 * @version 1.0
 * 
 */
public class AppraisalMonthTeamScoreEntity {

	private int id;
	/**
	 * 医生团队ID
	 */
	private String teamId;
	/**
	 * 签约人数
	 */
	private int signIncrement;
	/**
	 * 签约家庭户数
	 */
	private int familyIncrement;

	/**
	 * 签约人数得分（二类指标）
	 */
	private int signIncrementScore;

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
	/**
	 * 总评得分（最终得分）
	 */
	private double resultScore;
	/**
	 * 统计的目标月份，格式yyyyMM，如201708
	 */
	private String month;
	/**
	 * 统计时间
	 */
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getFamilyIncrement() {
		return familyIncrement;
	}

	public void setFamilyIncrement(int familyIncrement) {
		this.familyIncrement = familyIncrement;
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

	public void setHealthManageAssessmentScore(
			double healthManageAssessmentScore) {
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

	public double getPublicHealthPhychosisScore() {
		return publicHealthPhychosisScore;
	}

	public void setPublicHealthPhychosisScore(double publicHealthPhychosisScore) {
		this.publicHealthPhychosisScore = publicHealthPhychosisScore;
	}

	public double getResultScore() {
		return resultScore;
	}

	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
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

	public int getSignIncrementScore() {
		return signIncrementScore;
	}

	public void setSignIncrementScore(int signIncrementScore) {
		this.signIncrementScore = signIncrementScore;
	}
}
