package rm.DAO;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import rm.entity.ShoppingCart;

public class ShopCartDAOImpl implements ShopCartDAO{
	
	private Connection conn;
	public ShopCartDAOImpl(Connection conn)
	{
		this.conn=conn;
	}


	public List<ShoppingCart> getBookByUser(String username) {
		List<ShoppingCart> list=new ArrayList<ShoppingCart>();
		ShoppingCart c=null;
		
		try {
			String sql="select * from shoppingcart where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				c=new ShoppingCart();
				c.setCartid(rs.getInt(1));
				c.setBookid(rs.getInt(2));
				c.setUsername(rs.getString(3));
				c.setBookTitle(rs.getString(4));
				c.setUnitPrice(rs.getDouble(5));
				c.setQuantity(rs.getInt(6));
				c.setTotalPrice(rs.getDouble(7));
				list.add(c);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean removeBook(int cartId, int bookId) {
		boolean f=false;
		try {
		String sql="delete from shoppingcart where cartid=? and bookid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, cartId);
		ps.setInt(2, bookId);
		int i=ps.executeUpdate();
		if (i==1) {
			f=true;
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	public ShoppingCart getShopCartById(int id) {
		ShoppingCart c = null;
		try {
			String sql = "select * from shoppingcart where cartid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new ShoppingCart();
				c.setCartid(rs.getInt(1));
				c.setBookid(rs.getInt(2));
				c.setUsername(rs.getString(3));
				c.setBookTitle(rs.getString(4));
				c.setUnitPrice(rs.getDouble(5));
				c.setQuantity(rs.getInt(6));
				c.setTotalPrice(rs.getDouble(7));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return c;
	}	

	
}
