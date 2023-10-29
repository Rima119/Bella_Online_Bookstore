package rm.DAO;

import java.util.List;

import rm.entity.User;

public interface UserDAO {
	public boolean userRegister(User us);
	
	public User signin(String email,String password);
	
	public boolean passCheck(String username, String password);
	
	public boolean editUserInfo(User us);
	
	public boolean UserCheck(String username);
	
	public List<User> getAllUsers();
	
	public boolean UpdatePassword(User us);
	
	public User getUsersByUsername(String username);
	
	public boolean deleteUser(String username);
}
