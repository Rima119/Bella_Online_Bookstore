package rm.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.BookDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/remove_reuse_book")
public class RemoveReusedBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userEmail=req.getParameter("userEmail");
			int bookid=Integer.parseInt(req.getParameter(req.getParameter("bookid")));
			String status = "Active (Reused)";
			BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
			boolean f= dao.RemoveReusedBooks(userEmail,status,bookid);
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("succMsg", "Book Deleted Successfully");
				resp.sendRedirect("reusedBook_user.jsp");
			} else {
				session.setAttribute("failMsg", "Something Wrong on Server");
				resp.sendRedirect("reusedBook_user.jsp");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
