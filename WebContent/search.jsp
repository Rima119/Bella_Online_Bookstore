<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.BookDAOImpl"%>
<%@page import="rm.entity.BookDB"%>
<%@page import="rm.DAO.UserDAO"%>
<%@page import="rm.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
<title>Search For Books</title>
</head>
<body>
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			String search = request.getParameter("search");
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDB> list = dao.getSearchedBook(search);
			for (BookDB b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p class="mt-3"><%=b.getTitle()%></p>
						<p>By <%=b.getAuthor()%></p>
						<p>

							<%
							if (b.getStatus().equals("Inactive")) {
							%>
							This Book is out of stock
						</p>

						<div class="row">
							<a href="viewBook.jsp?id=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-5"><i
								class="fa-solid fa-eye"></i> VIEW</a><a href=""
								class="btn btn-secondary btn-sm ml-5"><i
								class="fa-solid fa-dollar-sign"></i><%=b.getPrice()%></a>
						</div>
						<%
						} else {
						%>
						<p>
							Category:
							<%=b.getCategory()%>
						</p>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="signin.jsp" class="btn btn-info btn-sm ml-4"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							} else {
							%>
							<a
								href="ShopCart?bookid=<%=b.getBookid()%>&&userid=<%=u.getUsername()%>"
								class="btn btn-info btn-sm ml-4"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							}
							%>
							<a href="viewBook.jsp?id=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-4"><i
								class="fa-solid fa-eye"></i> VIEW</a><a href=""
								class="btn btn-secondary btn-sm mt-2 ml-5"><i
								class="fa-solid fa-dollar-sign"></i><%=b.getPrice()%></a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>

	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>