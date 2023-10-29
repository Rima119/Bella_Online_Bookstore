package rm.DAO;

import java.util.List;

import rm.entity.ShoppingCart;

public interface ShopCartDAO {
	
	public ShoppingCart getShopCartById(int id);
	
	public List<ShoppingCart> getBookByUser(String username);
	
	public boolean removeBook(int cartId, int bookId);

}
