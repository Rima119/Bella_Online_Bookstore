<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.BookDAOImpl"%>
<%@page import="rm.entity.BookDB"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Books</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<h3 class="text-center">List of books</h3>
	<c:if test="${not empty succMsg }">
		<h5 class="alert alert-success">${succMsg }</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failMsg }">
		<h5 class="alert alert-danger">${failMsg }</h5>
		<c:remove var="failMsg" scope="session" />
	</c:if>
	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">Title</th>
				<th scope="col">Author</th>
				<th scope="col">Publisher</th>
				<th scope="col">Edition</th>
				<th scope="col">Category</th>
				<th scope="col">Supplier</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDB> list = dao.getAllBook();
			for (BookDB b : list) {
			%>
			<tr>
				<td><%=b.getBookid()%></td>
				<td><img src="../book/<%=b.getPhoto()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPublisher()%></td>
				<td><%=b.getEdition()%></td>
				<td><%=b.getCategory()%></td>
				<td><%=b.getSupplier()%></td>
				<td><%=b.getQuantity()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href="editBook.jsp?id=<%=b.getBookid()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-regular fa-pen-to-square"></i>Edit</a> <a
					href="../deleteBook?id=<%=b.getBookid()%>"
					class="btn btn-sm btn-danger mt-1"><i class="fa-solid fa-trash"></i>Delete</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>

	<div style="margin-to: 130px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>