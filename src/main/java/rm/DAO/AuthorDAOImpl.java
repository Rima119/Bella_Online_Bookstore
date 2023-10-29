package rm.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rm.entity.authorDB;

public class AuthorDAOImpl implements AuthorDAO {
	private Connection conn;

	public AuthorDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAuthor(authorDB a) {
		boolean f = false;
		try {
			String sql = "insert into author(fullName,birthDate,description,photo) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getFullName());
			ps.setString(2, a.getBirthDate());
			ps.setString(3, a.getDescription());
			ps.setString(4, a.getPhoto());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<authorDB> getAllAuthor() {
		List<authorDB> list = new ArrayList<authorDB>();
		authorDB a = null;
		try {
			String sql = "select * from author";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new authorDB();
				a.setFullName(rs.getString(1));
				a.setBirthDate(rs.getString(2));
				a.setDescription(rs.getString(3));
				a.setPhoto(rs.getString(4));
				list.add(a);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	
	public authorDB getAuthorByName(String name) {
		authorDB a = null;
		try {
			String sql = "select * from author where fullName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new authorDB();
				a.setFullName(rs.getString(1));
				a.setBirthDate(rs.getString(2));
				a.setDescription(rs.getString(3));
				a.setPhoto(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return a;
	}

	
	
	public boolean UpdateAuthor(authorDB a) {
		boolean f = false;
		try {
			String sql = "update author set birthDate=?,description=?,photo=? where fullName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getBirthDate());
			ps.setString(2, a.getDescription());
			ps.setString(3, a.getPhoto());
			ps.setString(4, a.getFullName());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public boolean deleteAuthor(String name) {
		boolean f = false;
		try {
			String sql = "delete from author where fullName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
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
