<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.CategoryDAOImpl"%>
<%@page import="rm.entity.CategoryDB"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Categories</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<h3 class="text-center">List of categories</h3>
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
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			CategoryDAOImpl dao = new CategoryDAOImpl(DBConnect.getConn());
			List<CategoryDB> list = dao.getAllCategory();
			for (CategoryDB c : list) {
			%>
			<tr>
				<td><img src="../book/<%=c.getPhoto()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=c.getName()%></td>
				<td><%=c.getDescription()%></td>
				<td><a href="editCategory.jsp?name=<%=c.getName()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-regular fa-pen-to-square"></i>Edit</a> <a
					href="../deleteCategory?name=<%=c.getName()%>"
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