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
<%@include file="all_component/allCss.jsp"%>
<title>Track Order</title>
</head>
<body Style="background-color: #f7f7f7">
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="signin.jsp"></c:redirect>
	</c:if>

	<div class="container p-1">
		<h3 class="text-center text-primary mt-3">Your Order List</h3>
		<table class="table table-striped mt-5">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order No</th>
					<th scope="col">Username</th>
					<th scope="col">Email</th>
					<th scope="col">Book Title</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Order Date</th>
					<th scope="col">Delivery Date</th>
					<th scope="col">Payment Method</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("userobj");
				OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
				List<OrderDetails> blist = dao.getOrderedBook(u.getUsername(), u.getEmail());
				for (OrderDetails o : blist) {
				%>
				<tr>
					<th scope="row"><%=o.getOrderNo()%></th>
					<td><%=o.getUsername()%></td>
					<td><%=o.getEmail()%></td>
					<td><%=o.getBookTitle()%></td>
					<td><%=o.getQuantity()%></td>
					<td><i class="fa-solid fa-dollar-sign"></i><%=o.getPrice()%></td>
					<td><%=o.getOrderDate()%></td>
					<td><%=o.getDeliveryDate()%></td>
					<td><%=o.getPaymentMethod()%></td>
					<td><%=o.getStatus()%></td>
				</tr>
				<tr>
					<%
					}
					%>
				
			</tbody>
		</table>
	</div>

	<div style="margin-to: 130px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>