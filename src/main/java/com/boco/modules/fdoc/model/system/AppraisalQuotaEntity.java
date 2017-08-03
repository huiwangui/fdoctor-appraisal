package com.boco.modules.fdoc.model.system;

import java.util.Date;

/**
 * 考核项目实体类
 * @author q
 *
 */
public class AppraisalQuotaEntity {
	/**
	 * 主键ID
	 */
    private Integer id;

    /**
    * 考核项目名称
    */
    private String name;

    /**
    * 所占比例（整数百分比，如50表示50%）
    */
    private Integer rate;

    /**
    * 父考核项ID，一级考核项该字段为空
    */
    private Integer parentId;

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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