package com.boco.modules.fdoc.vo;

import com.boco.common.persistence.Page;
import com.boco.modules.fdoc.model.score.HospitalEntity;

public class HospitalVo extends HospitalEntity{

	/**
	 * 团队数量
	 */
	private Integer teamNum;
	
	/**
	 * 区划查询参数，多个区划用逗号隔开
	 */
	private String regions;
	
	/**
	 * 医生团队ID
	 */
	private String docTeamId;
	
	/**
	 * 医生姓名
	 */
	private String docName;
	
	/**
	 * 医生数量
	 */
	private Integer docNum;
	
	/**
	 * 坐标
	 */
	private Double[] point;

	/*
	 * 分页插件
	 */
	private Page<HospitalVo> page;
	
	public Integer getDocNum() {
		return docNum;
	}

	public void setDocNum(Integer docNum) {
		this.docNum = docNum;
	}

	public Integer getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public String getDocTeamId() {
		return docTeamId;
	}

	public void setDocTeamId(String docTeamId) {
		this.docTeamId = docTeamId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Double[] getPoint() {
		return point;
	}

	public void setPoint(Double[] point) {
		this.point = point;
	}

	public Page<HospitalVo> getPage() {
		return page;
	}

	public void setPage(Page<HospitalVo> page) {
		this.page = page;
	}
	

}
