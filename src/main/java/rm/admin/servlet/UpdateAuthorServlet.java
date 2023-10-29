package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.entity.authorDB;
import rm.DAO.AuthorDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/editAuthor")
public class UpdateAuthorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName = req.getParameter("fullname");
			String birthDate = req.getParameter("birthdate");
			String description = req.getParameter("description");
			String photo = req.getParameter("photo");
			
			authorDB a=new authorDB();;
			a.setFullName(fullName);
			a.setBirthDate(birthDate);
			a.setDescription(description);
			a.setPhoto(photo);
			
			AuthorDAOImpl dao=new AuthorDAOImpl(DBConnect.getConn());
			boolean f=dao.UpdateAuthor(a);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Author Updated Successfully...");
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
