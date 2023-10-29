package rm.admin.servlet;

import java.io.File;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import rm.DAO.BookDAOImpl;
import rm.DB.DBConnect;
import rm.entity.BookDB;

@WebServlet("/add_book")
@MultipartConfig
public class BookAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publisher = req.getParameter("publisher");
			String edition = req.getParameter("edition");
			String category = req.getParameter("category");
			String supplier = req.getParameter("supplier");
			String quantity = req.getParameter("quantity");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			Part part = req.getPart("img");
			String fileName = part.getSubmittedFileName();

			BookDB b=new BookDB(title,author,publisher,edition,category,supplier,quantity,price,status,fileName);
			
			BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
			

			
			HttpSession session = req.getSession();
			
			boolean c=dao.addBook(b);
			
			if (c)
			{
				String path=getServletContext().getRealPath("")+"book";
				File f = new File(path);
				part.write(path + f.separator + fileName);
				session.setAttribute("succMsg","Book added succesfully");
				resp.sendRedirect("admin/addbook.jsp");
				
			} else {
				session.setAttribute("failMsg","Something wrong on server");
				resp.sendRedirect("admin/addbook.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
