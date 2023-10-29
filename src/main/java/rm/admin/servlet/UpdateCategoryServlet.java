package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.entity.CategoryDB;
import rm.DAO.CategoryDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/editCategory")
public class UpdateCategoryServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String photo = req.getParameter("catphoto");
			
			CategoryDB c=new CategoryDB();
			c.setName(name);
			c.setDescription(description);
			c.setPhoto(photo);
			
			CategoryDAOImpl dao=new CategoryDAOImpl(DBConnect.getConn());
			boolean f=dao.UpdateCategory(c);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Category Updated Successfully...");
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
