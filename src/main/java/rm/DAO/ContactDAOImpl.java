package rm.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import rm.entity.ContactUs;


public class ContactDAOImpl implements ContactDAO{
	private Connection conn;

	public ContactDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	
	public boolean addMessage(ContactUs c) {
		boolean f = false;
		try {
			String sql = "insert into contact_us(username,email,subject,message) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getSubject());
			ps.setString(4, c.getMessage());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}

	
	public List<ContactUs> getAllMessages() {
		List<ContactUs> list = new ArrayList<ContactUs>();
		ContactUs c = null;
		try {
			String sql = "select * from contact_us";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new ContactUs();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setSubject(rs.getString(4));
				c.setMessage(rs.getString(5));
				c.setMessageDate(rs.getDate(6));
				c.setStatus(rs.getString(7));
				list.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}
	
	public boolean UpdateMessageStatus(String status, int id) {
		boolean f = false;
		try {
			String sql = "update contact_us set status=? where contactid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	

}
