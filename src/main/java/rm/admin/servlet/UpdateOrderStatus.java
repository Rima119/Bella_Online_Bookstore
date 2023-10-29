package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rm.DAO.OrderDAOImpl;
import rm.DB.DBConnect;
import rm.entity.OrderDetails;


@WebServlet("/update_status")
public class UpdateOrderStatus extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String orderNo = req.getParameter("orderNo");
			OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
			OrderDetails o = dao.getOrders(orderNo);
				
				HttpSession session = req.getSession();

				boolean f = dao.UpdateStatus("Delivered", o.getOrderNo());
				OrderDetails a = new OrderDetails();
				a.setStatus("Delivered");

				if (f) {
					session.setAttribute("succMsg", "Book is being delivred Successfully...");
					resp.sendRedirect("admin/orders.jsp");

				} else {
					session.setAttribute("failMsg", "Something Wrong on Server");
					resp.sendRedirect("admin/orders.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}