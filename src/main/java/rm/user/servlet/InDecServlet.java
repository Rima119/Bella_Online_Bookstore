package rm.user.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


import rm.DAO.ShopCartDAOImpl;
import rm.DB.DBConnect;
import rm.entity.ShoppingCart;


@WebServlet("/inDecQuantity")
public class InDecServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ShopCartDAOImpl dao = new ShopCartDAOImpl(DBConnect.getConn());
		ShoppingCart s = dao.getShopCartById(id);
		
		String incdec = req.getParameter("quantity");
		
		
		double price = 0;
		double total = 0;
		int quantity = 0;
		double final_total = 0;
		try {
			HttpSession session = req.getSession();
			Connection conn = DBConnect.getConn();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from shoppingcart where bookid='" + s.getBookid() + "'and username='" + s.getUsername() + "'");
			while (rs.next()) {
				price = rs.getDouble(5);
				total = rs.getDouble(7);
				quantity = rs.getInt(6);
			}

			if (quantity == 1 && incdec.equals("dec")) {
				session.setAttribute("failMsg", "There is only one Quantity! So click on remove!");
				resp.sendRedirect("shopCart.jsp");
			} else if (quantity != 1 && incdec.equals("dec")) {
				total = total - price;
				quantity = quantity - 1;
				st.executeUpdate("update shoppingcart set totalPrice='" + total + "',quantity='" + quantity + "'where bookid='"
				+ s.getBookid() + "'and username='" + s.getUsername() + "'");
				session.setAttribute("succMsg", "Quantity Decreased Successfully!");
				resp.sendRedirect("shopCart.jsp");
			} else {
				total = total + price;
				quantity = quantity + 1;
				st.executeUpdate("update shoppingcart set totalPrice='" + total + "',quantity='" + quantity + "'where bookid='"
				+ s.getBookid() + "'and username='" + s.getUsername() + "'");
				session.setAttribute("succMsg", "Quantity Increased Successfully!");
				resp.sendRedirect("shopCart.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
