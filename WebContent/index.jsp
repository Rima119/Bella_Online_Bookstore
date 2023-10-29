<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.entity.BookDB"%>
<%@page import="rm.DAO.BookDAOImpl"%>
<%@page import="rm.DAO.UserDAO"%>
<%@page import="rm.entity.User"%>
<%@page import="rm.DAO.ReviewDAOImpl"%>
<%@page import="rm.entity.ReviewsDB"%>

<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<%@include file="all_component/allCss.jsp"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.back-img {
	background: url("book/op.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>

</head>
<body Style="background-color: #f7f7f7">
	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-secondary">Welcome to Bella Online
			Bookstore</h2>
	</div>

	<!--
	Connection conn = DBConnect.getConn();
	out.println(conn);
	 -->

	<!-- New books -->
	<div class="container">
		<h3 class="text-center">New Books</h3>
		<div class="row">

			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDB> list = dao.getNewBooks();
			for (BookDB b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p class="mt-3"><%=b.getTitle()%></p>
						<p>
							By
							<%=b.getAuthor()%></p>

						<p>
							<%
							if (b.getStatus().equals("inactive")) {
							%>
							This Book is out of stock
						</p>

						<div class="row">
							<a href="viewBook.jsp?id=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-5"><i
								class="fa-solid fa-eye"></i> VIEW</a><a href=""
								class="btn btn-danger btn-sm ml-5"><i
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
							<a href="signin.jsp" class="btn btn-info btn-sm ml-3"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							} else {
							%>
							<a
								href="ShopCart?bookid=<%=b.getBookid()%>&&username=<%=u.getUsername()%>"
								class="btn btn-info btn-sm ml-3"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							}
							%>
							<a href="viewBook.jsp?id=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-3"><i
								class="fa-solid fa-eye"></i> VIEW</a>
							<h6 class="btn btn-secondary btn-sm mt-2 ml-5 text-center">
								<i class="fa-solid fa-dollar-sign"></i><%=b.getPrice()%></h6>
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
		<div class="text-center mt-1">
			<a href="new_books.jsp" class="btn btn-sm text-white"
				style="background-color: #d67d63;">View All</a>
		</div>
	</div>
	<!-- End New Books -->
	<hr>
	<!-- Start Category Books -->
	<div class="container">
		<h3 class="text-center">Reused Books</h3>
		<div class="row">
			<%
			BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getConn());
			List<BookDB> list2 = dao2.getReusedBooks();
			for (BookDB b : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p class="mt-3"><%=b.getTitle()%></p>
						<p>By <%=b.getAuthor()%></p>
						<p>
							Category:
							<%=b.getCategory()%>
						</p>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="signin.jsp" class="btn btn-info btn-sm ml-3"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							} else {
							%>
							<a
								href="ShopCart?bookid=<%=b.getBookid()%>&&username=<%=u.getUsername()%>"
								class="btn btn-info btn-sm ml-3"><i
								class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
							<%
							}
							%>
							<a href="viewBook.jsp?id=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-3"><i
								class="fa-solid fa-eye"></i> VIEW</a>
							<h6 class="btn btn-secondary btn-sm mt-2 ml-5 text-center">
								<i class="fa-solid fa-dollar-sign"></i><%=b.getPrice()%></h6>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<div class="text-center mt-3">
			<a href="reused_books.jsp" class="btn btn-sm text-white"
				style="background-color: #d67d63;">View All</a>
		</div>
	</div>
	<hr>
	<!-- End Category Books -->
	<%@include file="all_component/footer.jsp"%>
</body>
</html>

