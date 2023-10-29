package rm.entity;

public class OrderDetails {
	
	private String orderNo;
	private String fullName;
	private String username;
	private String email;
	private String phone;
	private String fullAddress;
	private int bookid;
	private String bookTitle;
	private int quantity;
	private String orderDate;
	private String deliveryDate;
	private String price;
	private String paymentMethod;
	private String status;

	
	
	
	public OrderDetails() {
		super();
	}
	
	

	public OrderDetails(String orderNo,String fullName, String username, String email, String phone,
			String fullAddress, int bookid, String bookTitle, int quantity, String price, String orderDate, String deliveryDate,
			String paymentMethod, String status) {
		super();
		this.orderNo = orderNo;
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.fullAddress = fullAddress;
		this.bookid = bookid;
		this.bookTitle = bookTitle;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}



	public int getBookId() {
		return bookid;
	}

	public void setBookId(int bookid) {
		this.bookid = bookid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
