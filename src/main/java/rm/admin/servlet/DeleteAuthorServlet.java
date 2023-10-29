package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.DAO.AuthorDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/deleteAuthor")
public class DeleteAuthorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			AuthorDAOImpl dao = new AuthorDAOImpl(DBConnect.getConn());
			boolean f = dao.deleteAuthor(name);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Author Deleted Successfully...");
				resp.sendRedirect("admin/allAuthor.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/allAuthor.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
