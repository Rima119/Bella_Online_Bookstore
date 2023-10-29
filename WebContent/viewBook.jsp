<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.BookDAOImpl"%>
<%@page import="rm.entity.BookDB"%>
<%@page import="rm.DAO.CategoryDAOImpl"%>
<%@page import="rm.entity.CategoryDB"%>
<%@page import="rm.DAO.AuthorDAOImpl"%>
<%@page import="rm.entity.authorDB"%>
<%@page import="rm.DAO.ReviewDAOImpl"%>
<%@page import="rm.entity.ReviewsDB"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Book Page</title>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<%
	User u = (User) session.getAttribute("userobj");
	int id = Integer.parseInt(request.getParameter("id"));
	BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
	AuthorDAOImpl dao3 = new AuthorDAOImpl(DBConnect.getConn());
	BookDB b = dao.getBookById(id);
	String author = b.getAuthor();
	authorDB a = dao3.getAuthorByName(author);
	%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="book/<%=b.getPhoto()%>"
					style="height: 250px; width: 250px"><br>
				<h4 style="text-align: left; display: flex;" class="mt-5">
					Title:<span class="text-info ml-3"><%=b.getTitle()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Author Name: <span class="text-info ml-3"><%=a.getFullName()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Publisher:<span class="text-info ml-3"><%=b.getPublisher()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Edition: <span class="text-info ml-3"><%=b.getEdition()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Category: <span class="text-info ml-3"><%=b.getCategory()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Available books: <span class="text-danger ml-3"> <%=b.getQuantity()%></span>
				</h4>
			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=b.getTitle()%></h2>
				<br> <br> <br> <br> <br>
				<%
				if ("Inactive".equals(b.getStatus())) {
				%>
				<h5 class="text-primary">Make a special order</h5>
				<h5 class="text-primary">
					<i class="fa-regular fa-envelope"></i>Email:
					contact@bellabookstore.com
				</h5>
				<%
				}
				%>

				<div class="row">
					<div class="col-md-4 text-warning text-center p-2">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-success text-center p-2">
						<i class="fa-solid fa-arrow-rotate-left fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-warning text-center p-2">
						<i class="fa-solid fa-truck fa-2x"></i>
						<p>Free Shipping</p>
					</div>
				</div>

				<br> <br>
				<%
				if ("Inactive".equals(b.getStatus())) {
				%>
				<div class="text-center p-3">
					<a href="allBooks.jsp" class="btn btn-primary"><i
						class="fa-solid fa-cart-shopping"></i> Continue Shopping</a> <a href=""
						class="btn btn-danger"><i class="fa-solid fa-dollar-sign"></i> <%=b.getPrice()%></a>
					<a href="review.jsp?bookid=<%=b.getBookid()%>"
						class="btn btn-warning"><i class="fa-solid fa-star"></i> Review
						This Book</a>
				</div>

				<%
				} else {
				%>
				<%
				if (u == null) {
				%>
				<a href="signin.jsp" class="btn btn-primary"><i
					class="fa-solid fa-cart-shopping"></i> ADD TO CART</a> <a href=""
					class="btn btn-danger"><i class="fa-solid fa-dollar-sign"></i> <%=b.getPrice()%></a>
				<a href="signin.jsp" class="btn btn-warning"><i
					class="fa-solid fa-star"></i> Review This Book</a>
				<%
				} else {
				%>
				<a
					href="ShopCart?bookid=<%=b.getBookid()%>&&username=<%=u.getUsername()%>"
					class="btn btn-primary"><i class="fa-solid fa-cart-shopping"></i>
					ADD TO CART</a> <a href="" class="btn btn-danger"><i
					class="fa-solid fa-dollar-sign"></i> <%=b.getPrice()%></a> <a
					href="review.jsp?bookid=<%=b.getBookid()%>" class="btn btn-warning"><i
					class="fa-solid fa-star"></i> Review This Book</a>
				<%
				}
				%>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<hr>
	<div class="container p-3">
		<h4 class="text-center">About Author</h4>
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="book/<%=a.getPhoto()%>"
					style="height: 300px; width: 300px"><br>
				<h4 style="text-align: left; display: flex;" class="mt-5">
					Full Name:<span class="text-info ml-3"><%=a.getFullName()%></span>
				</h4>
				<h4 style="text-align: left; display: flex;">
					Birth Date:<span class="text-info ml-3"><%=a.getBirthDate()%></span>
				</h4>

			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<h4 class="text-center">Description:</h4>
				<h4 style="text-align: left;">
					<span class="text-black"><font size="+0.5"><%=a.getDescription()%></font></span>
				</h4>
			</div>
		</div>
	</div>
	<hr>
	<div class="container p-4">
		<h3 class="text-center">Reviews</h3>
		<div class="row">
			<%
			ReviewDAOImpl dao5 = new ReviewDAOImpl(DBConnect.getConn());
			List<ReviewsDB> list3 = dao5.getReviewsById(id);
			for (ReviewsDB r : list3) {
			%>
			<div class="col-md-3 mt-2">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<h6 class="mt-3">
							Rating:<span class="text-success"> <%=r.getRating()%>/5</span>
						</h6>
						<h6 style="text-align: left; display: flex;" class="mt-3">
							<span class="text-info"><%=r.getComment()%></span>
						</h6>
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