package com.boco.modules.fdoc.model.system;

import java.util.List;

public class MenuEntity {
	/**
	 * 基础平台菜单ID
	 */
	private Integer id;
	/**
	 * 菜单标题
	 */
	private String title;
	/**
	 * 是否默认展开
	 */
	private Boolean spread;
	/**
	 * 图标字符串
	 */
	private String icon;
	/**
	 * 链接
	 */
	private String href;
	/**
	 * 父菜单ID
	 */
	private Integer parentId;
	/**
	 * 子菜单集合
	 */
	private List<MenuEntity> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public List<MenuEntity> getChildren() {
		return children;
	}
	public void setChildren(List<MenuEntity> children) {
		this.children = children;
	}
	
}
