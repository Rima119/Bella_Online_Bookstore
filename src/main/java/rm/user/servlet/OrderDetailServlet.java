package rm.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.OrderDAOImpl;
import rm.DAO.ShopCartDAOImpl;
import rm.DB.DBConnect;
import rm.entity.OrderDetails;
import rm.entity.ShoppingCart;

@WebServlet("/order_details")
public class OrderDetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();

			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String zip = req.getParameter("zip");
			String paymentMethod = req.getParameter("paymentMethod");

			String fullName = firstname + " " + lastname;
			String fullAddress = address + "," + city + "," + state + "," + zip;

			// System.out.println(fullName+" "+username+" "+email+" "+phone+"
			// "+fullAddress+" "+paymentMethod);

			ShopCartDAOImpl dao = new ShopCartDAOImpl(DBConnect.getConn());

			List<ShoppingCart> blist = dao.getBookByUser(username);

			if (blist.isEmpty()) {
				session.setAttribute("failMsg", "Add Item");
				resp.sendRedirect("shopCart.jsp");

			} else {
				OrderDAOImpl dao2 = new OrderDAOImpl(DBConnect.getConn());
				OrderDetails o = null;

				ArrayList<OrderDetails> orderList = new ArrayList<OrderDetails>();
				Random r = new Random();
				for (ShoppingCart c : blist) {

					o = new OrderDetails();
					o.setOrderNo("ORDER-NO-000" + r.nextInt(1000));
					o.setFullName(fullName);
					o.setUsername(username);
					o.setEmail(email);
					o.setPhone(phone);
					o.setFullAddress(fullAddress);
					o.setBookId(c.getBookid());
					o.setBookTitle(c.getBookTitle());
					o.setQuantity(c.getQuantity());
					o.setPrice(c.getTotalPrice() + "");
					o.setPaymentMethod(paymentMethod);
					orderList.add(o);
				}

				if ("noSelect".equals(paymentMethod)) {
					session.setAttribute("failMsg", "Please Choose Payment Method");
					resp.sendRedirect("checkout.jsp");
				} else {

					boolean f = dao2.saveOrder(orderList);
					if (f) {
						resp.sendRedirect("orderSucc.jsp");
					} else {
						session.setAttribute("failMsg", "Order Failed");
						resp.sendRedirect("checkout.jsp");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
