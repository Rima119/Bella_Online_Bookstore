package rm.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rm.entity.OrderDetails;


public class OrderDAOImpl implements OrderDAO {

	private Connection conn;

	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveOrder(List<OrderDetails> blist) {
		boolean f = false;

		try {

			String sql = "insert into order_details(orderNo,fullName,username,email,fullAddress,phone,bookid,bookTitle,quantity,price,paymentMethod) values(?,?,?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (OrderDetails o : blist) {
				ps.setString(1, o.getOrderNo());
				ps.setString(2, o.getFullName());
				ps.setString(3, o.getUsername());
				ps.setString(4, o.getEmail());
				ps.setString(5, o.getFullAddress());
				ps.setString(6, o.getPhone());
				ps.setInt(7, o.getBookId());
				ps.setString(8, o.getBookTitle());
				ps.setInt(9, o.getQuantity());
				ps.setString(10, o.getPrice());
				ps.setString(11, o.getPaymentMethod());
				ps.addBatch();
			}

			int[] cont = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<OrderDetails> getOrderedBook(String username, String email) {

		List<OrderDetails> list = new ArrayList<OrderDetails>();
		OrderDetails o = null;
		try {

			String sql = "select * from order_details where username=? and email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new OrderDetails();
				o.setOrderNo(rs.getString(1));
				o.setFullName(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookId(rs.getInt(7));
				o.setBookTitle(rs.getString(8));
				o.setQuantity(rs.getInt(9));
				o.setPrice(rs.getString(10));
				o.setOrderDate(rs.getString(11));
				o.setDeliveryDate(rs.getString(12));
				o.setPaymentMethod(rs.getString(13));
				o.setStatus(rs.getString(14));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<OrderDetails> OrderedBookList() {
		List<OrderDetails> list = new ArrayList<OrderDetails>();
		OrderDetails o = null;
		try {

			String sql = "select * from order_details order by orderDate";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new OrderDetails();
				o.setOrderNo(rs.getString(1));
				o.setFullName(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookId(rs.getInt(7));
				o.setBookTitle(rs.getString(8));
				o.setQuantity(rs.getInt(9));
				o.setPrice(rs.getString(10));
				o.setOrderDate(rs.getString(11));
				o.setDeliveryDate(rs.getString(12));
				o.setPaymentMethod(rs.getString(13));
				o.setStatus(rs.getString(14));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean UpdateStatus(String Status,String orderNo) {
		boolean f = false;
		try {
			String sql = "update order_details set status=? where orderNo=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Status);
			ps.setString(2, orderNo);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public OrderDetails getOrders(String orderNo) {
		OrderDetails o = null;
		try {
			String sql = "select * from order_details where orderNo=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderNo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new OrderDetails();
				o.setOrderNo(rs.getString(1));
				o.setFullName(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookId(rs.getInt(7));
				o.setBookTitle(rs.getString(8));
				o.setQuantity(rs.getInt(9));
				o.setPrice(rs.getString(10));
				o.setOrderDate(rs.getString(11));
				o.setDeliveryDate(rs.getString(12));
				o.setPaymentMethod(rs.getString(13));
				o.setStatus(rs.getString(14));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return o;
	}
}
