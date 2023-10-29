package rm.entity;

public class ReviewsDB {

	private int revId;
	private String username;
	private int bookid;
	private Double rating;
	private String comment;

	public ReviewsDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewsDB(String username, int bookid, Double rating, String comment) {
		super();
		this.username = username;
		this.bookid = bookid;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
