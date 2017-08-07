package com.boco.modules.fdoc.model.system;

/**
 * 考核系统用户实体类
 * @author q
 *
 */
public class AppraisalUserEntity {
	/**
	 * 主键ID
	 */
    private String id;

    /**
    * 用户名
    */
    private String userName;
	/**
    * 密码
    */
    private String password;

    /**
    * 用户类型
    */
    private String type;
    
    public AppraisalUserEntity() {
		super();
	}
    
    public AppraisalUserEntity(String userName, String password, String type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}

	public AppraisalUserEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

    

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}