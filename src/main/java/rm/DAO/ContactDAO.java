package rm.DAO;

import java.util.List;


import rm.entity.ContactUs;

public interface ContactDAO {
	
	public boolean addMessage(ContactUs c);
	public List<ContactUs> getAllMessages();

}
