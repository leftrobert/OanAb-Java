package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REQUESTS")
public class Request {
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="Email")
	private String email;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="ImageFile")
	private String imageFile;
	
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

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Request() {
		super();
	}

	public Request(String id, String email, String title, String desc, String imageFile, String status) {
		super();
		this.id = id;
		this.email = email;
		this.title = title;
		this.desc = desc;
		this.imageFile = imageFile;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", email=" + email + ", title=" + title + ", desc=" + desc + ", imageFile="
				+ imageFile + ", status=" + status + "]";
	}
}
