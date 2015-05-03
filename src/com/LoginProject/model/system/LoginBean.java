package com.LoginProject.model.system;

import java.util.Date;

public class LoginBean {
	private Integer id;
	private String  userName;
	private String  userMail;
	private String  password;
	private String  keySecurity;
	private Date    registrationDate;
	private Date    updateDate;
	
	public LoginBean(String userName, String userMail, String password){
		this.userName = userName;
		this.userMail = userMail;
		this.password = password;
	}
	public LoginBean(){}
	public String getKeySecurity() {
		return keySecurity;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setKeySecurity(String keySecurity) {
		this.keySecurity = keySecurity;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
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
	
}
