<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DAO.ShopCartDAO"%>
<%@page import="rm.DAO.ShopCartDAOImpl"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="rm.entity.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Shopping Cart Page</title>
</head>
<body Style="background-color: #f7f7f7">
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failMsg }">
		<div class="alert alert-danger" role="alert">${failMsg }</div>
		<c:remove var="failMsg" scope="session" />
	</c:if>

	<div class="container">
		<div class="row p-2">
			<div class="col">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col" style="background-color: skyblue;">Cart
										Details</th>
									<th scope="col"><a href="checkout.jsp">Proceed to
											order</a></th>
								</tr>
							</thead>
							<thead>
								<tr>
									<th scope="col">Book Title</th>
									<th scope="col">Price</th>
									<th scope="col">Quantity</th>
									<th scope="col">Sub Total</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User u = (User) session.getAttribute("userobj");
								ShopCartDAOImpl dao = new ShopCartDAOImpl(DBConnect.getConn());
								List<ShoppingCart> shopCart = dao.getBookByUser(u.getUsername());
								double total = 0.0;
								try {
									Connection conn = DBConnect.getConn();
									Statement st = conn.createStatement();
									ResultSet rs1 = st.executeQuery("select sum(totalPrice) from shoppingcart where username='" + u.getUsername()+ "'");
									while (rs1.next()) {
										total = rs1.getDouble(1);
									}
									for (ShoppingCart c : shopCart) {
								%>
								<tr>

									<td><%=c.getBookTitle()%></td>
									<td><i class="fa fa-dollar"></i><%=c.getUnitPrice()%></td>
									<td><a
										href="inDecQuantity?id=<%=c.getCartid()%>&quantity=inc"><i
											class='fas fa-plus-circle'></i></a> <%=c.getQuantity()%> <a
										href="inDecQuantity?id=<%=c.getCartid()%>&quantity=dec"><i
											class='fas fa-minus-circle'></i></a></td>
									<td><i class="fa fa-dollar"></i><%=c.getTotalPrice()%></td>
									<td><a
										href="removeShop?cartid=<%=c.getCartid()%>&&bookid=<%=c.getBookid()%>"
										class="btn btn-sm btn-danger"><i
											class="fas fa-trash-alt"></i> Remove</a></td>
								</tr>

								<%
								}
								%>
								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td></td>
									<td><%=total%></td>
									<%
									} catch (Exception e) {
									e.printStackTrace();
									}
									%>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>