package com.boco.common.constants;

/**
 * 记录统计评估中判断优秀标准的字段名
 * @author q
 *
 */
public class AppraisalFieldTargetConstans {
	/**
	 * 签约管理
	 */
	public static String SIGN_HYPER = "signHyperScore";	//签约-高血压
	public static String SIGN_DIABETES = "signDiabetesScore";	//签约-糖尿病
	public static String SIGN_PHYCHOSIS = "signPhychosisScore";		//签约-重性精神病
	public static String SIGN_OLD = "signOldScore";		//签约-老年人
	public static String SIGN_MATERNAL = "signMaternalScore";	//签约-孕产妇
	public static String SIGN_CHILDREN = "signChildrenScore";	//签约-儿童
	public static String SIGN_MANAGE = "signManageScore";	//签约管理（一类）
	
	/**
	 * 公卫服务
	 */
	public static String PUBLIC_HEALTH_HYPER = "publicHealthHyperScore";	//高血压
	public static String PUBLIC_HEALTH_DIABETES = "publicHealthDiabetesScore";	//糖尿病
	public static String PUBLIC_HEALTH_PHYCHOSIS = "publicHealthPhychosisScore";	//精神病
	public static String PUBLIC_HEALTH_OLD = "publicHealthOldScore";	//老年人
	public static String PUBLIC_HEALTH_MATERNAL = "publicHealthMaternalScore";	//孕产妇
	public static String PUBLIC_HEALTH_CHILDREN = "publicHealthChildrenScore";	//儿童
	public static String PUBLIC_HEALTH = "publicHealthScore";	//公卫服务（一类）
	
	/**
	 * 健康管理
	 */
	public static String HEALTH_MANAGE_EDU = "healthManageEduScore";	//健康教育
	public static String HEALTH_MANAGE_DAILY_ACTIVITY = "healthManageEduScore";	//日活跃量
	public static String HEALTH_MANAGE_ASSESSMENT = "healthManageAssessmentScore";	//健康评估
	public static String HEALTH_MANAGE_DOCUMENT = "healthManageDocumentScore";	//建档数
	public static String HEALTH_MANAGE = "healthManageScore";	//健康管理（一类）
	
	/**
	 * 居民满意度
	 */
	public static String CUSTOMER = "customerScore";	//居民满意度（一类）
	
	/**
	 * 总评
	 */
	public static String RESULT = "resultScore";	//总评得分
	
}
