package rm.entity;

public class BookDB {
	
	private int bookid;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String category;
	private String supplier;
	private String quantity;
	private String price;
	private String status;
	private String photo;
	public BookDB() {
		super();
	}
	public BookDB(String title, String author, String publisher, String edition, String category, String supplier, String quantity, 
			String price, String status, String photo) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.photo = photo;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "BookDB [bookid=" + bookid + ", title=" + title + ", category=" + category + ", author=" + author
				+ ", publisher=" + publisher + ", quantity=" + quantity + ", supplier=" + supplier + ", price=" + price
				+ ", status=" + status + ", photo=" + photo + "]";
	}
	
}
