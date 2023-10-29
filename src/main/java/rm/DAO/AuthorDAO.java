package rm.DAO;

import java.util.List;

import rm.entity.authorDB;

public interface AuthorDAO {
	public boolean addAuthor(authorDB a);
	public List<authorDB> getAllAuthor();
	public authorDB getAuthorByName(String Name);
	public boolean UpdateAuthor(authorDB a);
	public boolean deleteAuthor(String name);

}
