package org.mycompany.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity (name="USER_DETAILS")
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
		UserDetails.objectCount++;
		System.out.println("Object Count = " + UserDetails.getObjectCount());
	}
	
	@Id
	@Column (name="USER_ID")
	@GeneratedValue (strategy=GenerationType.AUTO) //to generate surrogate keys
	private int userId;
	
	@Column (name="USER_NAME")
	@Basic
	private String userName;
	
	//@Column (name="USER_ADDRESS")
	//private String address;
	
	Address address = new Address();
	
	//LOB - Long Objects
	//CLOB - Character-stream LOBs
	//BLOB - Byte-stream LOBs
	@Column (name="USER_DESCRIPTION")
	@Lob
	private String description;
	
	@Column (name="USER_JOINING_DATE")
	@Temporal (TemporalType.DATE)
	private Date joiningDate;
	
	private static String companyName = "mycompany";
	private static int objectCount = 0;
	
	@Column (name="NOT_TO_BE_PERSISTED")
	@Transient
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
	public static int getObjectCount() {
		return objectCount;
	}
	public static void setObjectCount(int objectCount) {
		UserDetails.objectCount = objectCount;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", address=" + address + ", description="
				+ description + ", joiningDate=" + joiningDate + ", doNotSaveMe=" + doNotSaveMe + "]";
	}
	
}
