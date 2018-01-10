package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIRTS")
public class Shirt {
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="CatID")
	private String catId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Gender")
	private int gender;
	
	@Column(name="Material")
	private String material;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Price")
	private int price;
	
	@Column(name="Sizes")
	private String sizes;
	
	@Column(name="Colors")
	private String colors;
	
	@Column(name="ImageFile")
	private String imageFile;
	
	@Column(name="Sold")
	private int sold;
	
	@Column(name="Status")
	private boolean status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public String printGender() {
		switch (this.gender) {
		case 0: return "Female";
		case 1: return "Male";
		default: return "Unisex";
		}
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String printPrice() {
		return String.format("%,d", this.price);
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Shirt() {
		super();
	}

	public Shirt(String id, String catId, String name, int gender, String material, String date, int price,
			String sizes, String colors, String imageFile, int sold, boolean status) {
		super();
		this.id = id;
		this.catId = catId;
		this.name = name;
		this.gender = gender;
		this.material = material;
		this.date = date;
		this.price = price;
		this.sizes = sizes;
		this.colors = colors;
		this.imageFile = imageFile;
		this.sold = sold;
		this.status = status;
	}

	public Shirt(String id, String catId, String name, String gender, String date, String price, String sizes, String colors,
			String status) {
		super();
		this.id = id;
		this.catId = catId;
		this.name = name;
		this.gender = Integer.parseInt(gender);
		this.date = date;
		this.price = Integer.parseInt(price);
		this.sizes = sizes;
		this.colors = colors;
		this.status = (status.equals("1")?true:false);
	}

	@Override
	public String toString() {
		return "Shirt [id=" + id + ", catId=" + catId + ", name=" + name + ", gender=" + gender + ", material="
				+ material + ", date=" + date + ", price=" + price + ", sizes=" + sizes + ", colors=" + colors
				+ ", imageFile=" + imageFile + ", sold=" + sold + ", status=" + status + "]";
	}
}
