package rm.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.DB.DBConnect;

import rm.DAO.ShopCartDAOImpl;

@WebServlet("/removeShop")
public class RemoveShopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int cartid = Integer.parseInt(req.getParameter("cartid"));
			int bookid = Integer.parseInt(req.getParameter("bookid"));
			
			ShopCartDAOImpl dao = new ShopCartDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();
			
			boolean f = dao.removeBook(cartid, bookid);
			

			if (f) {
				session.setAttribute("succMsg", "Book Removed from Shopping Cart");
				resp.sendRedirect("shopCart.jsp");
			} else {
				session.setAttribute("failMsg", "Something Wrong on Server");
				resp.sendRedirect("shopCart.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
