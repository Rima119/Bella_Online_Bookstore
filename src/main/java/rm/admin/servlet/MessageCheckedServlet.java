package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.ContactDAOImpl;
import rm.DB.DBConnect;
import rm.entity.ContactUs;


@WebServlet("/checkMessage")
public class MessageCheckedServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			ContactDAOImpl dao = new ContactDAOImpl(DBConnect.getConn());
				
				HttpSession session = req.getSession();

				boolean f = dao.UpdateMessageStatus("Checked", id);
				ContactUs a = new ContactUs();
				a.setStatus("Checked");

				if (f) {
					session.setAttribute("succMsg", "Message Checked");
					resp.sendRedirect("admin/allMessages.jsp");

				} else {
					session.setAttribute("failMsg", "Something Wrong on Server");
					resp.sendRedirect("admin/allMessages.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
