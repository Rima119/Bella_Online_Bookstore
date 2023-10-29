package rm.entity;

public class ShoppingCart {
	private int cartid;
	private int bookid;
	private String username;
	private String bookTitle;
	private int quantity;
	private Double unitPrice;
	private Double totalPrice;
	
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart(int cartid, int bookid, String username, String bookTitle, int quantity, Double unitPrice,
			Double totalPrice) {
		super();
		this.cartid = cartid;
		this.bookid = bookid;
		this.username = username;
		this.bookTitle = bookTitle;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}


	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	} 

}

