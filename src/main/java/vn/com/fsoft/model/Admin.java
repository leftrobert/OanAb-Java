package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMINS")
public class Admin {
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="RoleID")
	private String roleId;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="Gender")
	private boolean gender;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="StartDate")
	private String startDate;
	
	@Column(name="Status")
	private boolean status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String enDob() {
		String s[] = dob.split("-");
		return s[1]+"/"+s[2]+"/"+s[0];
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Admin() {
		super();
	}

	public Admin(String id, String roleId, String password, String name, String dob, boolean gender, String phone,
			String email, String startDate, boolean status) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.startDate = startDate;
		this.status = status;
	}

	public Admin(String id, String roleId, String password, String name, String dob, String gender, String phone,
			String email, String startDate, String status) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.gender = (gender.equals("1")?true:false);
		this.phone = phone;
		this.email = email;
		this.startDate = startDate;
		this.status = (status.equals("1")?true:false);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", roleId=" + roleId + ", password=" + password + ", name=" + name + ", dob=" + dob
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", startDate=" + startDate + ", status="
				+ status + "]";
	}
}
