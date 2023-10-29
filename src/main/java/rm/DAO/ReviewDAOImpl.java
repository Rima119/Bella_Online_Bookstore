package rm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rm.entity.ReviewsDB;

public class ReviewDAOImpl implements ReviewDAO {
	private Connection conn;

	public ReviewDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addReview(ReviewsDB r) {
		boolean f = false;
		try {
			String sql = "insert into review(username,bookid,rating,comment) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getUsername());
			ps.setInt(2, r.getBookid());
			ps.setDouble(3, r.getRating());
			ps.setString(4, r.getComment());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<ReviewsDB> getReviewsById(int bookid) {
		List<ReviewsDB> list = new ArrayList<ReviewsDB>();
		ReviewsDB r = null;
		try {
			String sql = "select * from review where bookid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new ReviewsDB();
				r.setRevId(rs.getInt(1));
				r.setUsername(rs.getString(2));
				r.setBookid(rs.getInt(3));
				r.setRating(rs.getDouble(4));
				r.setComment(rs.getString(5));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

}
