package rm.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import rm.entity.BookDB;


public class BookDAOImpl implements BookDAO {
	private Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addBook(BookDB b) {
		boolean f = false;
		try {
			String sql = "insert into book(title,author,publisher,edition,category,supplier,quantity,price,status,photo) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setString(4, b.getEdition());
			ps.setString(5, b.getCategory());
			ps.setString(6, b.getSupplier());
			ps.setString(7, b.getQuantity());
			ps.setString(8, b.getPrice());
			ps.setString(9, b.getStatus());
			ps.setString(10, b.getPhoto());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;

	}

	public List<BookDB> getAllBook() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public BookDB getBookById(int id) {
		BookDB b = null;
		try {
			String sql = "select * from book where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return b;
	}

	public boolean UpdateBook(BookDB b) {
		boolean f = false;
		try {
			String sql = "update book set title=?,author=?,publisher=?,edition=?,category=?,supplier=?,quantity=?, price=?, status=?,photo=? where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setString(4, b.getEdition());
			ps.setString(5, b.getCategory());
			ps.setString(6, b.getSupplier());
			ps.setString(7, b.getQuantity());
			ps.setString(8, b.getPrice());
			ps.setString(9, b.getStatus());
			ps.setString(10, b.getPhoto());
			ps.setInt(11, b.getBookid());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteBook(int id) {
		boolean f = false;
		try {
			String sql = "delete from book where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<BookDB> getNewBooks() {

		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> getReusedBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active (Reused)");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> AllBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allTechBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Computers and Technology");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allLittBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Literature and Fiction");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allNewBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where status=? order by bookid DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allBioBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Biographies and Memoirs");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allBusinessBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Business and Investing");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allHealthBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Health, Fitness and Dieting");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allScFicBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where category=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Science Fiction and Fantasy");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> allReusedBooks() {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active (Reused)");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDB> getReusedBooks(String userEmail, String status) {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where status=? and supplier=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, userEmail);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean RemoveReusedBooks(String userEmail, String status, int bookId) {
		boolean f = false;
		try {
			String sql = "delete from book where supplier=? and status=? and bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userEmail);
			ps.setString(2, status);
			ps.setInt(3, bookId);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<BookDB> getSearchedBook(String search) {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where title like ? or author like ? or publisher like ? or category like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ps.setString(3, "%"+search+"%");
			ps.setString(4, "%"+search+"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	
	
	public List<BookDB> getSearchByPrice(String min, String max) {
		List<BookDB> list = new ArrayList<BookDB>();
		BookDB b = null;
		try {
			String sql = "select * from book where price between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, min);
			ps.setString(2, max);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDB();
				b.setBookid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setEdition(rs.getString(5));
				b.setCategory(rs.getString(6));
				b.setSupplier(rs.getString(7));
				b.setQuantity(rs.getString(8));
				b.setPrice(rs.getString(9));
				b.setStatus(rs.getString(10));
				b.setPhoto(rs.getString(11));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
