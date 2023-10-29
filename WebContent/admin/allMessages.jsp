<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.ContactDAOImpl"%>
<%@page import="rm.entity.ContactUs"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Messages</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<h3 class="text-center mt-1">List of Messages</h3>
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
				<th scope="col">ID</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
				<th scope="col">Subject</th>
				<th scope="col">Message</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			ContactDAOImpl dao = new ContactDAOImpl(DBConnect.getConn());
			List<ContactUs> list = dao.getAllMessages();
			for (ContactUs c : list) {
			%>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getUsername()%></td>
				<td><%=c.getEmail()%></td>
				<td><%=c.getSubject()%></td>
				<td><%=c.getMessage()%></td>
				<td><%=c.getMessageDate()%></td>
				<td><%=c.getStatus()%></td>
				<td><a href="../checkMessage?id=<%=c.getId()%>"
					class="btn btn-sm btn-success"><i class="fa-solid fa-check"></i></a></td>
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