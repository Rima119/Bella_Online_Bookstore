package rm.DAO;

import java.util.List;



import rm.entity.OrderDetails;


public interface OrderDAO {
	
	public boolean saveOrder(List<OrderDetails> blist);

	public List<OrderDetails> getOrderedBook(String username, String email);
	
	public List<OrderDetails> OrderedBookList();
	
	public boolean UpdateStatus(String Status,String orderNo);
	
	public OrderDetails getOrders(String OrderNo);
}
