package rm.DAO;

import java.util.List;

import rm.entity.ReviewsDB;


public interface ReviewDAO {

	public boolean addReview(ReviewsDB r);
	public List<ReviewsDB> getReviewsById(int bookid);
}
