package com.boco.modules.fdoc.vo;

import java.util.Date;

import com.boco.common.persistence.Page;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;

/**
 * Description
 * @author lzz
 * @date 2017年8月7日 下午3:54:54
 */
public class SignFamilyTeamVo {
	
	/*
	 * 合同id
	 */
	private int id;
	
	/*
	 * 签约家庭户主
	 */
	private String personName;
	
	/*
	 * 签约团队队长名字
	 */
	private String docName;
	
	/*
	 * 签约机构名字
	 */
	private String orgName;
	
	/*
	 * 签约服务包权值
	 */
	private int packValue;
	
	/*
	 * 签约服务包名
	 */
	private String packName;
	/*
	 * 签约时间
	 */
	private Date signTime;
	
	/*
	 * 签约结束时间
	 */
	private Date dueTime;
	
	/*
	 * 签约时间字符串
	 */
	private String signTimeStr;
	
	/*
	 * 持续时间
	 */
	private String lastTime;
	
	/*
	 * 分页控件
	 */
	private Page<SignFamilyTeamVo> page;
	
	/*
	 * 机构id
	 */
	private String orgId;
	
	/*
	 * 团队id
	 */
	private String teamId;
	
	/*
	 * 查询人员类型
	 */
	private String personType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Date getSignTime() {
		return signTime;
	}
	public String getOrgId() {
		return orgId;
	}
	public int getPackValue() {
		return packValue;
	}
	public void setPackValue(int packValue) {
		this.packValue = packValue;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
	public String getSignTimeStr() {
		return signTimeStr;
	}
	public void setSignTimeStr(String signTimeStr) {
		this.signTimeStr = signTimeStr;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public Page<SignFamilyTeamVo> getPage() {
		return page;
	}
	public void setPage(Page<SignFamilyTeamVo> page) {
		this.page = page;
	}
	
}
