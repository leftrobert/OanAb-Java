package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Gender")
	private boolean gender;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="RegDate")
	private String regDate;
	
	@Column(name="FavoriteCat")
	private String favoriteCat;
	
	@Column(name="Status")
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getFavoriteCat() {
		return favoriteCat;
	}

	public void setFavoriteCat(String favoriteCat) {
		this.favoriteCat = favoriteCat;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User() {
		super();
	}

	public User(int id, String password, String name, String phone, boolean gender, String dob, String address,
			String regDate, String favoriteCat, boolean status) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.regDate = regDate;
		this.favoriteCat = favoriteCat;
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", gender="
				+ gender + ", dob=" + dob + ", address=" + address + ", regDate=" + regDate + ", favoriteCat="
				+ favoriteCat + ", status=" + status + "]";
	}
}
