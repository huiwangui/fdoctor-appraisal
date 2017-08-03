package com.boco.modules.fdoc.model.system;

import java.util.Date;

/**
 * 分数线实体类
 * @author q
 *
 */
public class AppraisalGradeLineEntity {
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 分数线名称
    */
    private String name;

    /**
    * 分数线上限，不包含等于
    */
    private Integer upper;

    /**
    * 分数线下限，包含等于
    */
    private Integer lower;

    /**
    * 备注
    */
    private String remark;

    /**
    * 最近修改时间
    */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Integer getLower() {
        return lower;
    }

    public void setLower(Integer lower) {
        this.lower = lower;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}