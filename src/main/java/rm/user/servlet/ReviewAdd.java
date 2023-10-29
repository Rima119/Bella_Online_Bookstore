package rm.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.ReviewDAOImpl;
import rm.DB.DBConnect;
import rm.entity.ReviewsDB;

@WebServlet("/add_review")
@MultipartConfig
public class ReviewAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int bookid = Integer.parseInt(req.getParameter("bookid"));
			String username = req.getParameter("username");
			Double rating = Double.parseDouble(req.getParameter("rating"));
			String comment = req.getParameter("comment");

			ReviewsDB r = new ReviewsDB(username,bookid,rating,comment);

			ReviewDAOImpl dao = new ReviewDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean f = dao.addReview(r);

			if (f) {
				session.setAttribute("succMsg", "Review add succesfully. Thank you!");
				resp.sendRedirect("tech_books.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("tech_books.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
