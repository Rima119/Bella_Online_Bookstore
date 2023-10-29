<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DAO.ShopCartDAO"%>
<%@page import="rm.DAO.ShopCartDAOImpl"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="rm.entity.ShoppingCart"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Checkout Page</title>
</head>
<body Style="background-color: #f7f7f7">

	<%@include file="all_component/navbar.jsp"%>


	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<c:if test="${empty userobj }">
		<c:redirect url="signin.jsp"></c:redirect>
	</c:if>

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
						<h3 class="text-center text-success mb-3">Your Order Details</h3>
						<form action="order_details" method="post">
							<div class="form-row">
								<div class="form-group col-md-4 mb-3">
									<label for="validationDefault01">First name</label> <input
										type="text" class="form-control" id="validationDefault01"
										name="firstname" value="<%=u.getFirstname()%>"
										readonly="readonly" required>
								</div>
								<div class="form-group col-md-4 mb-3">
									<label for="validationDefault02">Last name</label> <input
										type="text" class="form-control" id="validationDefault02"
										name="lastname" value="<%=u.getLastname()%>"
										readonly="readonly" required>
								</div>
								<div class="form-group col-md-4 mb-3">
									<label for="validationDefaultUsername">Username</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroupPrepend2">@</span>
										</div>
										<input type="text" class="form-control"
											id="validationDefaultUsername" name="username"
											value="<%=u.getUsername()%>"
											aria-describedby="inputGroupPrepend2" readonly="readonly"
											required>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="validationDefault01">Email</label> <input
										type="email" class="form-control" id="validationDefault01"
										name="email" value="<%=u.getEmail()%>" readonly="readonly"
										required>
								</div>
								<div class="form-group col-md-6">
									<label for="validationDefault02">Phone number</label> <input
										type="text" class="form-control" id="validationDefault02"
										name="phone" value="<%=u.getPhone()%>" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="validationDefault03">Address</label> <input
										type="text" class="form-control" id="validationDefault03"
										name="address" value="<%=u.getAddress()%>" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6 mb-3">
									<label for="validationDefault03">City</label> <input
										type="text" class="form-control" id="validationDefault03"
										placeholder="City" name="city" required>
								</div>
								<div class="form-group col-md-3 mb-3">
									<label for="validationDefault04">State</label> <input
										type="text" class="form-control" id="validationDefault04"
										placeholder="State" name="state" required>
								</div>
								<div class="form-group col-md-3 mb-3">
									<label for="validationDefault05">Zip</label> <input type="text"
										class="form-control" id="validationDefault05"
										placeholder="Zip" name="zip" required>
								</div>
							</div>
							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control"
									name="paymentMethod">
									<option selected value="noSelect">--Select--</option>
									<option value="COD">Cash On Delivery</option>
									<option value="PayPal">PayPal</option>
									<option value="Credit Card">Credit Card</option>
								</select>
							</div>
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value=""
										id="invalidCheck2" required> <label
										class="form-check-label" for="invalidCheck2"> Agree to
										terms and conditions </label>
								</div>
							</div>
							<div class="text-center">
								<a href="shopCart.jsp" class="btn btn-primary" type="submit">
									Back</a> <button class="btn btn-warning"
									type="submit">Order Now</button> <a href="index.jsp"
									class="btn btn-success">Continue Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>