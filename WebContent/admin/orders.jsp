<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.entity.OrderDetails"%>
<%@page import="rm.DAO.OrderDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Orders List</title>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<c:if test="${not empty succMsg }">
		<p class="alert alert-success">${succMsg }</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failMsg }">
		<p class="alert alert-danger">${failMsg }</p>
		<c:remove var="failMsg" scope="session" />
	</c:if>


	<h3 class="text-center mt-1">List of Orders</h3>
	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
			
				<th scope="col" >Order No</th>
				<th scope="col">Full Name</th>
				<th scope="col">UserName</th>
				<th scope="col">Email</th>
				<th scope="col">Full Address</th>
				<th scope="col">Phone number</th>
				<th scope="col" >Book ID</th>
				<th scope="col">Book Title</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
				<th scope="col">Order Date</th>
				<th scope="col">Order Delivery</th>
				<th scope="col">Payment type</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
			List<OrderDetails> blist = dao.OrderedBookList();
			for (OrderDetails o : blist) {
			%>
			
			<tr>
				<th scope="row"><%=o.getOrderNo()%></th>
				<td><%=o.getFullName()%></td>
				<td><%=o.getUsername()%></td>
				<td><%=o.getEmail()%></td>
				<td><%=o.getFullAddress()%></td>
				<td><%=o.getPhone()%></td>
				<td><%=o.getBookId()%></td>
				<td><%=o.getBookTitle()%></td>
				<td><%=o.getQuantity()%></td>
				<td><%=o.getPrice()%></td>
				<td><%=o.getOrderDate()%></td>
				<td><%=o.getDeliveryDate()%></td>
				<td><%=o.getPaymentMethod()%></td>
				<td><%=o.getStatus()%></td>
				<td><a href="../update_status?orderNo=<%=o.getOrderNo()%>&username=<%=o.getUsername()%>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-truck"></i> Deliver</a> <a href="../cancel_status?orderNo=<%=o.getOrderNo()%>&username=<%=o.getUsername()%>"
					class="btn btn-sm btn-danger mt-2"><i class="fa-solid fa-xmark"></i> Cancel</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>


	<%@include file="footer.jsp"%>
</body>
</html>