package org.mycompany.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity (name="USER_DETAILS")
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@Column (name="USER_ID")
	private int userId;
	
	@Column (name="USER_NAME")
	@Basic
	private String userName;
	
	@Column (name="USER_ADDRESS")
	private String address;
	
	@Column (name="USER_DESCRIPTION")
	private String description;
	
	@Column (name="USER_JOINING_DATE")
	private Date joiningDate;
	
	private static String companyName = "mycompany";
	
	@Column (name="NOT_TO_BE_PERSISTED")
	private String doNotSaveMe;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public static String getCompanyName() {
		return companyName;
	}
	public static void setCompanyName(String companyName) {
		UserDetails.companyName = companyName;
	}
	public String getDoNotSaveMe() {
		return doNotSaveMe;
	}
	public void setDoNotSaveMe(String doNotSaveMe) {
		this.doNotSaveMe = doNotSaveMe;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", address=" + address + ", description="
				+ description + ", joiningDate=" + joiningDate + ", doNotSaveMe=" + doNotSaveMe + "]";
	}
	
}
