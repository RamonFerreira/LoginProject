package com.LoginProject.model.user;

import java.util.Date;

import com.LoginProject.model.system.LoginBean;




/*



tipo            enum('A','U'),
id_login_fk     int,
foreign key (id_login_fk) references tb_login(id),
dtcadastro date,
dtmodificacao date
);
 */
public class UserBean {
	private Integer id;
	private String  firstName;
	private String  lastName;
	private String  userMailForContact;
	
	private String  celPhone;
	private String  telPhone;
	private Date    birthDate;
	private String  type;
	
	private Date    registrationDate;
	private Date    updateDate;
	private LoginBean login;
	public UserBean(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName  = lastName;
	}
	public UserBean(String firstName, String lastName, String userMailForContact){
		this.firstName = firstName;
		this.lastName  = lastName;
		this.userMailForContact =userMailForContact;
	}
	public UserBean(String firstName, String lastName, LoginBean login){
		this.firstName = firstName;
		this.lastName  = lastName;
		this.login     = login;
	}
	
	
	public String getUserMailForContact() {
		return userMailForContact;
	}
	public void setUserMailForContact(String userMailForContact) {
		this.userMailForContact = userMailForContact;
	}
	public LoginBean getLogin() {
		return login;
	}


	public void setLogin(LoginBean login) {
		this.login = login;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	
	
}
