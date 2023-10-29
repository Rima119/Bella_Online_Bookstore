package rm.DAO;

import rm.entity.BookDB;

import java.util.List;


public interface BookDAO {
	
	public boolean addBook(BookDB b);
	public List<BookDB> getAllBook();
	public BookDB getBookById(int id);
	public boolean UpdateBook(BookDB b);
	public boolean deleteBook(int id);
	public List<BookDB> getNewBooks();
	public List<BookDB> getReusedBooks();
	public List<BookDB> AllBooks();
	public List<BookDB> allTechBooks();
	public List<BookDB> allLittBooks();
	public List<BookDB> allNewBooks();
	public List<BookDB> allBioBooks();
	public List<BookDB> allBusinessBooks();
	public List<BookDB> allHealthBooks();
	public List<BookDB> allScFicBooks();
	public List<BookDB> allReusedBooks();
	public List<BookDB> getReusedBooks(String userEmail, String status);
	public boolean RemoveReusedBooks(String userEmail, String status, int bookId);
	public List<BookDB> getSearchedBook(String search);
	public List<BookDB> getSearchByPrice(String min, String max);
}
