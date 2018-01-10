package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARTS")
public class Cart {
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="BillID")
	private String billId;
	
	@Column(name="ShirtID")
	private String shirtId;
	
	@Column(name="Size")
	private String size;
	
	@Column(name="Color")
	private String color;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Price")
	private int price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getShirtId() {
		return shirtId;
	}

	public void setShirtId(String shirtId) {
		this.shirtId = shirtId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public Cart() {
		super();
	}

	public Cart(String id, String billId, String shirtId, String size, String color, int amount, int price) {
		super();
		this.id = id;
		this.billId = billId;
		this.shirtId = shirtId;
		this.size = size;
		this.color = color;
		this.amount = amount;
		this.price = price;
	}

	public Cart(String id, String billId, String shirtId, String size, String color, int amount) {
		super();
		this.id = id;
		this.billId = billId;
		this.shirtId = shirtId;
		this.size = size;
		this.color = color;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", billId=" + billId + ", shirtId=" + shirtId + ", size=" + size + ", color=" + color
				+ ", amount=" + amount + ", price=" + price + "]";
	}
}
