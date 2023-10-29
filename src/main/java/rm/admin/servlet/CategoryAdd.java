package rm.admin.servlet;

import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import rm.DAO.CategoryDAOImpl;
import rm.DB.DBConnect;
import rm.entity.CategoryDB;

@WebServlet("/add_category")
@MultipartConfig
public class CategoryAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			Part part = req.getPart("catphoto");
			String fileName = part.getSubmittedFileName();

			CategoryDB b = new CategoryDB(name,description,fileName);

			CategoryDAOImpl dao = new CategoryDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean c = dao.addCategory(b);

			if (c) {
				String path = getServletContext().getRealPath("") + "book";
				File f = new File(path);
				part.write(path + f.separator + fileName);
				session.setAttribute("succMsg", "Category added succesfully");
				resp.sendRedirect("admin/addCategory.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/addCategory.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
