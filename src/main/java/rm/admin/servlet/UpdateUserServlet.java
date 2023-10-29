package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.UserDAOImpl;
import rm.DB.DBConnect;
import rm.entity.User;

@WebServlet("/editUser")
public class UpdateUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username=req.getParameter("username");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			
			User us=new User();
			us.setFirstname(firstname);
			us.setLastname(lastname);
			us.setUsername(username);
			us.setEmail(email);
			us.setAddress(address);
			us.setPhone(phone);
			
			
			UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
			boolean f=dao.editUserInfo(us);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Member Info Updated Successfully...");
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

