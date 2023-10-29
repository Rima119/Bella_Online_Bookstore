package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.DAO.BookDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			boolean f = dao.deleteBook(id);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Book Deleted Successfully...");
				resp.sendRedirect("admin/AllBook.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/AllBook.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
