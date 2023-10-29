package rm.user.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import rm.DAO.ContactDAOImpl;
import rm.DB.DBConnect;
import rm.entity.ContactUs;

@WebServlet("/add_message")
@MultipartConfig
public class MessageAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String subject = req.getParameter("subject");
			String message = req.getParameter("message");

			ContactUs c = new ContactUs(username,email,subject,message);

			ContactDAOImpl dao = new ContactDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean f = dao.addMessage(c);

			if (f) {
				session.setAttribute("succMsg", "Message sent succesfully. Thank you!");
				resp.sendRedirect("contact_us.jsp");

			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("contact_us.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
