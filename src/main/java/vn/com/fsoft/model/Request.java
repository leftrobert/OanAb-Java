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
	private int id;

	@Column(name="Email")
	private String email;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="ImageFile")
	private String imageFile;
	
	@Column(name="Status")
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Request() {
		super();
	}

	public Request(int id, String email, String title, String description, String date, String imageFile, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.title = title;
		this.date = date;
		this.description = description;
		this.imageFile = imageFile;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", email=" + email + ", title=" + title + ", description=" + description + ", imageFile="
				+ imageFile + ", status=" + status + "]";
	}

	public String getDate() {
		return date;
	}

	public String enDate() {
		String[] t = date.split("-");
		return t[1]+"/"+t[2]+"/"+t[0];
	}
}
