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
.form-horizontal {
	display: block;
	width: 20%;
	margin: 0 auto;
}
</style>
<title>Biographies and Memoirs Books</title>
</head>
<body>
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_component/navbar.jsp"%>
	
	<div class=form-horizontal>
		<div class="card-body">
			<div class="col-md-6 ">
				<form class="form-inline my-2 my-lg-0" action="Search_price.jsp"
					method="post">
					<div class="form-group">
						<input class="form-control col-md-1 mr-sm-2" type="search"
							name="min" aria-label="Search"> | <input
							class="form-control col-md-1 ml-2 mr-sm-2" type="search"
							name="max" aria-label="Search">
						<button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="container-fluid">
		<div class="row p-3">
			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDB> list = dao.allBioBooks();
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
								href="ShopCart?bookid=<%=b.getBookid()%>&&username=<%=u.getUsername()%>"
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