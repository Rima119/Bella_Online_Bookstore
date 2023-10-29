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

import rm.DAO.AuthorDAOImpl;
import rm.DB.DBConnect;
import rm.entity.authorDB;

@WebServlet("/add_author")
@MultipartConfig
public class AuthorAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName = req.getParameter("fullname");
			String birthDate = req.getParameter("birthdate");
			String description = req.getParameter("description");
			Part part = req.getPart("photo");
			String fileName = part.getSubmittedFileName();

			authorDB a = new authorDB(fullName,birthDate,description,fileName);

			AuthorDAOImpl dao = new AuthorDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean c = dao.addAuthor(a);

			if (c) {
				String path = getServletContext().getRealPath("") + "book";
				File f = new File(path);
				part.write(path + f.separator + fileName);
				session.setAttribute("succMsg", "Author added succesfully");
				resp.sendRedirect("admin/addAuthor.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/addAuthor.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
