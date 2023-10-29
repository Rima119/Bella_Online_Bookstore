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

@WebServlet("/update_pass")
public class UpdateUserPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			User us = new User();
			us.setEmail(email);
			us.setUsername(username);
			us.setPassword(password);

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean f2 = dao.UpdatePassword(us);
			if (f2) {
				session.setAttribute("succMsg", "Password Updated Successfully..");
				resp.sendRedirect("forget_pass.jsp");

			} else {
				session.setAttribute("failMsg", "Email or Username Invalid");
				resp.sendRedirect("forget_pass.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
