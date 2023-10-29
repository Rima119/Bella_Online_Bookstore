package rm.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rm.entity.BookDB;
import rm.DAO.BookDAOImpl;
import rm.DB.DBConnect;

@WebServlet("/editBook")
public class UpdateBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publisher = req.getParameter("publisher");
			String edition = req.getParameter("edition");
			String category = req.getParameter("category");
			String supplier = req.getParameter("supplier");
			String quantity = req.getParameter("quantity");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			String photo = req.getParameter("photo");
			
			BookDB b=new BookDB();
			b.setBookid(id);
			b.setTitle(title);
			b.setAuthor(author);
			b.setPublisher(publisher);
			b.setEdition(edition);
			b.setCategory(category);
			b.setSupplier(supplier);
			b.setQuantity(quantity);
			b.setPrice(price);
			b.setStatus(status);
			b.setPhoto(photo);
			
			BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
			boolean f=dao.UpdateBook(b);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Book Updated Successfully...");
				resp.sendRedirect("admin/AllBook.jsp");
				
			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/AllBook.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
