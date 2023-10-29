package rm.user.servlet;

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

@WebServlet("/edit_profile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username=req.getParameter("username");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
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
			boolean f=dao.passCheck(username, password);
			HttpSession session = req.getSession();
			if(f) {
				
				boolean f2=dao.editUserInfo(us);
				if(f2)
				{
					session.setAttribute("succMsg", "Profile Updated Successfully..");
					resp.sendRedirect("editProfile.jsp");
					
				} else {
					session.setAttribute("failMsg", "Something wrong on server..");
					resp.sendRedirect("editProfile.jsp");
				}
				
			} else {
				session.setAttribute("failMsg", "Your Password is Incorrect");
				resp.sendRedirect("editProfile.jsp");	
			}
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
