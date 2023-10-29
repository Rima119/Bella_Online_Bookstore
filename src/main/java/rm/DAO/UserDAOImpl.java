package rm.DAO;

import rm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User us) {
		boolean d = false;
		try {
			String sql = "insert into user(firstname,lastname,username,email,password,address,phone) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getFirstname());
			ps.setString(2, us.getLastname());
			ps.setString(3, us.getUsername());
			ps.setString(4, us.getEmail());
			ps.setString(5, us.getPassword());
			ps.setString(6, us.getAddress());
			ps.setString(7, us.getPhone());

			int i = ps.executeUpdate();
			if (i == 1) {
				d = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public User signin(String email, String password) {
		User us = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setUsername(rs.getString(1));
				us.setFirstname(rs.getString(2));
				us.setLastname(rs.getString(3));
				us.setEmail(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setPhone(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;

	}

	public boolean passCheck(String username, String password) {
		boolean f = false;
		try {
			String sql = "select * from user where username=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editUserInfo(User us) {
		boolean d = false;
		try {
			String sql = "update user set firstname=?,lastname=?,email=?,address=?,phone=? where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getFirstname());
			ps.setString(2, us.getLastname());
			ps.setString(3, us.getEmail());
			ps.setString(4, us.getAddress());
			ps.setString(5, us.getPhone());
			ps.setString(6, us.getUsername());

			int i = ps.executeUpdate();
			if (i == 1) {
				d = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean UserCheck(String username) {
		boolean d = true;
		try {
			String sql = "select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		User u = null;
		try {
			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setUsername(rs.getString(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setAddress(rs.getString(6));
				u.setPhone(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public boolean UpdatePassword(User us) {
		boolean d = false;
		try {

			String sql = "update user set password=? where email=? and username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getPassword());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getUsername());

			int i = ps.executeUpdate();
			if (i == 1) {
				d = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public User getUsersByUsername(String username) {
		User u = null;
		try {
			String sql = "select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setUsername(rs.getString(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setAddress(rs.getString(6));
				u.setPhone(rs.getString(7));

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return u;
	}

	public boolean deleteUser(String username) {
		boolean f = false;
		try {
			String sql = "delete from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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
