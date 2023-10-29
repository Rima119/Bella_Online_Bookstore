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
<%@include file="all_component/allCss.jsp"%>
<title>${userobj.username}: Reused Books List</title>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failMsg }">
		<p class="text-center text-danger">${failMsg }</p>
		<c:remove var="failMsg" scope="session" />
	</c:if>
	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Book Title</th>
					<th scope="col">Author</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("userobj");
				String userEmail = u.getEmail();
				BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
				List<BookDB> list = dao.getReusedBooks(userEmail, "Active (Reused)");
				for (BookDB b : list) {
				%>
				<tr>
					<td><%=b.getTitle()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getCategory()%></td>
					<td><%=b.getQuantity()%></td>
					<td><i class="fa-solid fa-dollar-sign"></i><%=b.getPrice()%></td>
					<td><%=b.getStatus()%></td>
					<td><a
						href="remove_reuse_book?userEmail=<%=b.getSupplier()%>&&bookid=<%=b.getBookid()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div class="col-md-4"></div>
	</div>

	<div style="bottom: 0;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>