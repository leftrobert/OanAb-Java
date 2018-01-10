package vn.com.fsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BILLS")
public class Bill {
	@Id
	@Column(name="ID")
	private String id;

	@Column(name="Date")
	private String date;
	
	@Column(name="UserID")
	private String userId;
	
	@Column(name="ReceiverName")
	private String receiverName;
	
	@Column(name="ReceiverPhone")
	private String receiverPhone;
	
	@Column(name="ReceiverAddress")
	private String receiverAddress;
	
	@Column(name="TotalPrice")
	private int totalPrice;
	
	@Column(name="PaymentStatus")
	private boolean paymentStatus;
	
	@Column(name="Comment")
	private String comment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String enDate() {
		String s[] = date.split("-");
		return s[1]+"/"+s[2]+"/"+s[0];
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String printTotalPrice() {
		return String.format("%,d", totalPrice);
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Bill() {
		super();
	}

	public Bill(String id, String date, String receiverName, String receiverPhone, String receiverAddress,
			int totalPrice, boolean paymentStatus) {
		super();
		this.id = id;
		this.date = date;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}

	public Bill(String id, String date, String userId, String receiverName, String receiverPhone,
			String receiverAddress, int totalPrice, boolean paymentStatus, String comment) {
		super();
		this.id = id;
		this.date = date;
		this.userId = userId;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
		this.comment = comment;
	}
}
