package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.DAO.CategoryDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			CategoryDAOImpl dao = new CategoryDAOImpl(DBConnect.getConn());
			boolean f = dao.deleteCategory(name);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Category Deleted Successfully...");
				resp.sendRedirect("admin/allCategories.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/allCategories.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
