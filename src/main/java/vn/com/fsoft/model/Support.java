package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUPPORTS")
public class Support {
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="Email")
	private String email;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="Status")
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Support() {
		super();
	}

	public Support(String id, String email, String title, String desc, String status) {
		super();
		this.id = id;
		this.email = email;
		this.title = title;
		this.desc = desc;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Support [id=" + id + ", email=" + email + ", title=" + title + ", desc=" + desc + ", status=" + status
				+ "]";
	}
}
