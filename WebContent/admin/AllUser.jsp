<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.UserDAOImpl"%>
<%@page import="rm.entity.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All User Members</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<h3 class="text-center mt-1">List of Members</h3>
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
				<th scope="col">User Name</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			List<User> list = dao.getAllUsers();
			for (User u : list) {
			%>
			<tr>
				<td><%=u.getUsername()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getAddress()%></td>
				<td><%=u.getPhone()%></td>
				<td><a href="editUser.jsp?username=<%=u.getUsername()%>"
					class="btn btn-sm btn-primary"><i
						class="fa-regular fa-pen-to-square"></i>Edit</a> <a
					href="../deleteUser?username=<%=u.getUsername()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>Delete</a></td>
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