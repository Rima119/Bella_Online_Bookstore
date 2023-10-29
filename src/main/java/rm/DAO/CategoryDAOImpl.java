package rm.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rm.entity.CategoryDB;

public class CategoryDAOImpl implements CategoryDAO {
	private Connection conn;

	public CategoryDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCategory(CategoryDB c) {
		boolean f = false;
		try {
			String sql = "insert into category(name,description,catePhoto) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setString(3, c.getPhoto());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<CategoryDB> getAllCategory() {
		List<CategoryDB> list = new ArrayList<CategoryDB>();
		CategoryDB c = null;
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new CategoryDB();
				c.setName(rs.getString(1));
				c.setDescription(rs.getString(2));
				c.setPhoto(rs.getString(3));
				list.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	
	public CategoryDB getCategoryByName(String name) {
		CategoryDB c = null;
		try {
			String sql = "select * from category where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new CategoryDB();
				c.setName(rs.getString(1));
				c.setDescription(rs.getString(2));
				c.setPhoto(rs.getString(3));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return c;
	}

	
	public boolean UpdateCategory(CategoryDB c) {
		boolean f = false;
		try {
			String sql = "update category set description=?,catePhoto=? where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getDescription());
			ps.setString(2, c.getPhoto());
			ps.setString(3, c.getName());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public boolean deleteCategory(String name) {
		boolean f = false;
		try {
			String sql = "delete from category where name=?";
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

	
	public List<CategoryDB> AllCategories() {
		List<CategoryDB> list = new ArrayList<CategoryDB>();
		CategoryDB c = null;
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new CategoryDB();
				c.setName(rs.getString(1));
				c.setDescription(rs.getString(2));
				c.setPhoto(rs.getString(3));
				list.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
