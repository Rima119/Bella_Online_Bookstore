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

@WebServlet("/signin")
public class signinServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			// System.out.println(email+" "+password);

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User us = new User();
				us.setUsername("Admin");
				session.setAttribute("userobj", us);
				resp.sendRedirect("admin/home.jsp");
			} else {
				User us = dao.signin(email, password);
				if (us != null) {
					session.setAttribute("userobj", us);
					resp.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failMsg", "Email or Password Invalid");
					resp.sendRedirect("signin.jsp");

				}
				resp.sendRedirect("index.jsp");
			}

			/*
			 * User us = new User(); us.setEmail(email); us.setPassword(password);
			 * 
			 * 
			 * if (check != null) {
			 * 
			 * boolean d = dao.userRegister(us); if (d) { //
			 * System.out.println("User Register Success..");
			 * 
			 * 
			 * 
			 * } else { // System.out.println("Something wrong on server");
			 * 
			 * 
			 * 
			 * } } else { // System.out.println("Please accept Terms of Service");
			 * 
			 * session.setAttribute("failMsg", "Please accept Terms of Service");
			 * resp.sendRedirect("register.jsp");
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}