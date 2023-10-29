package rm.user.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import rm.DAO.BookDAOImpl;
import rm.DB.DBConnect;
import rm.entity.BookDB;

@WebServlet("/ShopCart")
public class ShopCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int bookid = Integer.parseInt(req.getParameter("bookid"));
		String username=req.getParameter("username");

		BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
		BookDB b = dao.getBookById(bookid);

		int quantity = 1;
		double unitPrice = 0.0;
		double totalPrice = 0.0;
		double cartPrice = 0.0;

		int z = 0;
		try {
			Connection conn = DBConnect.getConn();
			Statement st = conn.createStatement();
			HttpSession session = req.getSession();
			ResultSet rs = st.executeQuery("select * from book where bookid='" + bookid + "'");
			while (rs.next()) {
				unitPrice = rs.getDouble(9);
				totalPrice = unitPrice;
			}
			ResultSet rs1 = st.executeQuery(
					"select * from shoppingcart where bookid='" + bookid + "'and username='" + username + "'");
			while (rs1.next()) {
				cartPrice = rs1.getDouble(7);
				cartPrice = cartPrice + totalPrice;
				quantity = rs1.getInt(6);
				quantity = quantity + 1;
				z = 1;
			}
			if (z == 1) {
				st.executeUpdate("update shoppingcart set totalPrice='" + cartPrice + "',quantity='" + quantity
						+ "' where bookid='" + bookid + "' and username='" + username + "'");
				session.setAttribute("succMsg", "Book in already in cart. Quantity increased");
				resp.sendRedirect("allBooks.jsp");
			}
			if (z == 0) {
				PreparedStatement ps = conn.prepareStatement(
						"insert into shoppingcart(bookid, username, bookTitle, unitPrice, quantity,totalPrice) values (?,?,?,?,?,?)");
				ps.setInt(1, bookid);
				ps.setString(2, username);
				ps.setString(3, b.getTitle());
				ps.setDouble(4, unitPrice);
				ps.setInt(5, quantity);
				ps.setDouble(6, totalPrice);
				ps.executeUpdate();
				session.setAttribute("succMsg", "Book added to cart");
				resp.sendRedirect("allBooks.jsp");
			}
			else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("allBooks.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
