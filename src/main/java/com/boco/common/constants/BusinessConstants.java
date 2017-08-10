package com.boco.common.constants;

public class BusinessConstants {
	/**
	 * 通用
	 */
	public final static String SUCCESS = "success"; //操作成功
	public final static String FAIL = "fail"; //操作失败
	public final static String YES = "1"; //是
	public final static String NO = "0"; //否
	/**
	 * 逻辑删除标识
	 */
	public final static String DEL_FLAG_YES = "1"; //已删除
	public final static String DEL_FLAG_NO = "0"; //未删除
	
	/**
	 * 用户模块
	 */
	public final static String REGISTER_SUCCESS = "register_success";//注册成功
	public final static String AUTHEN_FLAG_YES = "1"; //已认证
	public final static String AUTHEN_FLAG_NO = "0"; //未认证
	public final static String USER_STATUS_NORMAL = "1"; //正常
	public final static String USER_STATUS_DISABLE = "2"; //禁用
	public final static String AUTHEN_RESULT_REPEAT = "repeat"; //禁用
	public final static String USERNAME_IN_SESSION = "username_in_session";
	/**
	 * 短信验证码
	 */
	public final static Integer SMS_CODE_BUSI = 1001;
	public final static String SMS_SEND_ITEM_USER = "user";	//居民端接收
	public final static String SMS_SEND_ITEM_DOC = "doc";	//医生端接收
	

	/**
	 * 优惠劵营销短信
	 */
	public final static Integer SMS_CODE_BUSI_YES = 1002;

	/**
	 * 常量NUM
	 */
	public final static String ROW_NUM = "rowNum";

	/**
	 * 短信验证 超时时间
	 */
	public final static String SMS_CODE_TIMEOUT = "sms_code_timeout";

	/**
	 * 云片 短信 公司
	 */
	public final static String YP_SMS_COMPANY = "yp_sms_company";

	/**
	 * 短信模板
	 */
	public final static String YP_SMS_TEMPLATE = "yp_sms_template";

	/**
	 * 手机号
	 */
	public final static String APPSTORE_MOBILE = "appstore_mobile";
	public final static String MOBILE_REPEAT = "mobile_repeat";

	/**
	 * 验证码
	 */
	public final static String APPSTORE_CODE = "appstore_code";
	
	/**
	 * 获取最上级区划代码
	 */
	public final static String TOP_REGION = "top_region";
	
	
	/**
	 * 签约相关状态
	 */
	public final static String SIGN_STATUS_SIGNED = "1";//签约有效期内
	public final static String SIGN_STATUS_RENEW = "2";//待续约
	public final static String SIGN_STATUS_CANCLED = "3";//已解约
	
	public final static String SIGN_AGREEMENT_ONGOING = "1";//协议进行中
	public final static String SIGN_AGREEMENT_OVERSTAY = "2";//已过期
	public final static String SIGN_AGREEMENT_CANCLE = "3";//已解除
	
	public final static String ERROR_RE_SIGN = "re_sign";
	public final static String SUCCESS_SIGN = "success";
	
	public final static String SIGN_TYPE_DOC = "1";	//签约类型为医生端主动签约
	public final static String SIGN_TYPE_USER = "2";//签约类型为居民端提出申请签约
	
	/**
	 * 居民相关状态
	 */
	public final static String RESIDENG_STATUS_SYNADD = "0"; //同步增加
	public final static String RESIDENG_STATUS_SYNDEL = "1"; //同步删除
	public final static String RESIDENG_STATUS_SYNUPDATE = "2"; //同步更改
	public final static String RESIDENG_STATUS_SYNSAME = "3";//同步相同
	public final static String RESIDENG_STATUS_SELFUPDATE = "4";//手动修改
	public final static Integer PERSON_SIGN_STATUS_SIGNED = 1;//居民已签约
	public final static Integer PERSON_SIGN_STATUS_NOT = 0;//居民未签约
	
	public final static String PERSON_NOT_FOUND = "person_not_found";//未找到居民
	
	
	/**
	 * json为空、空字符串不序列化
	 */
	public final static String JSON_NOT_EMPTY = "json_not_empty";
	public final static String JSON_ALL = "json_all";
	
	public final static String USER_IN_SESSION = "user_in_session";
	public final static String USER_AND_ORG_IN_SESSION = "user_and_org_in_session";
	
	/*考核占比*/
	public final static String SIGN_ADMIN = "签约管理";
	public final static String SIGN_COUNT = "签约总数";
	public final static String SIGN_HY = "高血压人数";
	public final static String SIGN_DIA= "糖尿病人数";
	public final static String SIGN_OLD = "老年人人数";
	public final static String SIGN_MAT = "孕产妇人数";
	public final static String SIGN_CHI = "儿童人数";
	public final static String SIGN_ZXJ = "重型精神病人数";
	
	public final static String UP_ADMIN = "随访体检";
	public final static String UP_COUNT = "总次数";
	public final static String UP_HY = "高血压人次";
	public final static String UP_DIA = "糖尿病人次";
	public final static String UP_OLD = "老年人人次";
	public final static String UP_MAT = "孕产妇人次";
	public final static String UP_CHI = "儿童人次";
	public final static String UP_ZX = "重型精神病人次";
	
	
	public final static String HEALTH_ADMIN = "健康管理";
	public final static String HEALTH_EDU = "健康教育";
	public final static String HEALTH_WZ = "问诊次数";
	public final static String HEALTH_CP = "健康评估";
	public final static String HEALTH_DOC = "建档数";
	
}
