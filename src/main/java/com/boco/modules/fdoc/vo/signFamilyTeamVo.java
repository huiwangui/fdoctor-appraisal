package com.boco.modules.fdoc.vo;

import java.util.Date;

import com.boco.common.persistence.Page;

/**
 * Description
 * @author lzz
 * @date 2017年8月7日 下午3:54:54
 */
public class signFamilyTeamVo {
	
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
	 * 签约服务包
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
	private Page<signFamilyTeamVo> page;
	
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
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public Date getSignTime() {
		return signTime;
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
	public Page<signFamilyTeamVo> getPage() {
		return page;
	}
	public void setPage(Page<signFamilyTeamVo> page) {
		this.page = page;
	}
	
}
