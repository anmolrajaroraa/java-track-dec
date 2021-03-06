package org.mycompany.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

//@Entity (name="USER_DETAILS")
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
		//UserDetails.objectCount++;
		//System.out.println("Object Count = " + UserDetails.getObjectCount());
	}
	
	//@Id
	//@Column (name="USER_ID")
	//@GeneratedValue (strategy=GenerationType.AUTO) //to generate surrogate keys
	//private int userId;
	
	//@Column (name="USER_NAME")
	//@Basic
	//private String userName;
	
	//@Column (name="USER_ADDRESS")
	//private String address;
	
	//@Id
	//@Embedded
	@EmbeddedId
	private User_Id_And_Name userIdAndName;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column= @Column(name="OFFICE_STREET_NAME")),
		@AttributeOverride(name="city", column= @Column(name="OFFICE_CITY_NAME")),
		@AttributeOverride(name="state", column= @Column(name="OFFICE_STATE_NAME")),
		@AttributeOverride(name="pincode", column= @Column(name="OFFICE_PIN_CODE"))
	})
	private Address officeAddress;
	
	//@JoinColumn (name="USER_ID",referencedColumnName="USERDETAILS_USER_ID")
		/*@JoinColumns ({
			@JoinColumn(name="USER_ID",referencedColumnName="USER_ID"),
			@JoinColumn(name="USER_NAME",referencedColumnName="USER_NAME")
		})*/
	
	/*@JoinTable (
			name="USER_PREV_ADDRESSES",
			joinColumns=@JoinColumn(name="USER_ID")
	)*/
	@ElementCollection()
	@JoinTable(
			name="USER_PREV_ADDRESSES",
			joinColumns= {
					@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
					@JoinColumn(name="USER_NAME", referencedColumnName="USER_NAME")
			}
	)
	@GenericGenerator(name="generic-generator", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "generic-generator", type = @Type(type="int"))
	private Collection<Address> listOfPrevAddresses = new ArrayList<>();
	//private Set<Address> listOfPrevAddresses = new HashSet<>();
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;*/
	
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	/*@JoinTable(
			name="USER_VEHICLES",
			joinColumns= {
					@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
					@JoinColumn(name="USER_NAME", referencedColumnName="USER_NAME")
			},
			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
	)*/
	//private Collection<Vehicle> vehicles = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="USER_VEHICLES",
			joinColumns= {
					@JoinColumn(name="USER_ID", referencedColumnName="USER_ID"),
					@JoinColumn(name="USER_NAME", referencedColumnName="USER_NAME")
			},
			inverseJoinColumns = @JoinColumn(name="VEHICLE_ID")
	)
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
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
	
	public void assignVehicle(Vehicle vehicle) {
		this.getVehicles().add(vehicle);
		//vehicle.setUser(this);
		vehicle.getUserList().add(this);
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	} 
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public User_Id_And_Name getUserIdAndName() {
		return userIdAndName;
	}
	public void setUserIdAndName(User_Id_And_Name userIdAndName) {
		this.userIdAndName = userIdAndName;
	}
	public Collection<Address> getListOfPrevAddresses() {
		return listOfPrevAddresses;
	}
	public void setListOfPrevAddresses(Collection<Address> listOfPrevAddresses) {
		this.listOfPrevAddresses = listOfPrevAddresses;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "UserDetails [userIdAndName=" + userIdAndName + ", homeAddress=" + homeAddress + ", officeAddress="
				+ officeAddress + ", listOfPrevAddresses=" + listOfPrevAddresses + ", vehicles=" + vehicles
				+ ", description=" + description + ", joiningDate=" + joiningDate + ", doNotSaveMe=" + doNotSaveMe
				+ "]";
	}
}
