<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.AuthorDAOImpl"%>
<%@page import="rm.entity.authorDB"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Authors</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<h3 class="text-center">List of authors</h3>
	<c:if test="${not empty succMsg }">
		<h5 class="text-center text-success">${succMsg }</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failMsg }">
		<h5 class="text-center text-danger">${failMsg }</h5>
		<c:remove var="failMsg" scope="session" />
	</c:if>
	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Image</th>
				<th scope="col">Full Name</th>
				<th scope="col">Birth Date</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			AuthorDAOImpl dao = new AuthorDAOImpl(DBConnect.getConn());
			List<authorDB> list = dao.getAllAuthor();
			for (authorDB a : list) {
			%>
			<tr>
				<td><img src="../book/<%=a.getPhoto()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=a.getFullName()%></td>
				<td><%=a.getBirthDate()%></td>
				<td><%=a.getDescription()%></td>
				<td><a href="editAuthor.jsp?name=<%=a.getFullName()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-regular fa-pen-to-square"></i>Edit</a> <a
					href="../deleteAuthor?name=<%=a.getFullName()%>"
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