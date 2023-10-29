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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String check = req.getParameter("check");

			// System.out.println(firstname+" "+lastname+" "+username+" "+email+"
			// "+password+" "+address+" "+phone+" "+check);

			User us = new User();
			us.setFirstname(firstname);
			us.setLastname(lastname);
			us.setUsername(username);
			us.setEmail(email);
			us.setPassword(password);
			us.setAddress(address);
			us.setPhone(phone);

			HttpSession session = req.getSession();

			if (check != null) 
			{
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
				boolean d = dao.UserCheck(username);
				if (d)
				{
					boolean f=dao.userRegister(us);
					if (f) {
					// System.out.println("User Register Success..");

					session.setAttribute("succMsg", "Registration Successfully..");
					resp.sendRedirect("register.jsp");

				     } else {
					// System.out.println("Something wrong on server");

					session.setAttribute("failMsg", "Something wrong on server..");
					resp.sendRedirect("register.jsp");
					} 
				} else {
					session.setAttribute("failMsg", "User Already Exist Try Another Username");
					resp.sendRedirect("register.jsp");
				}
			} else {
				// System.out.println("Please accept Terms of Service");

				session.setAttribute("failMsg", "Please accept Terms of Service");
				resp.sendRedirect("register.jsp");

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
