<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Order Success</title>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container text-center mt-3">
		<i class="fas fa-check-circle fa-5x text-success mt-2 mb-3"></i>
		<h1>Thank You</h1>
		<br>
		<h2>Your Order Has Been Placed Successfully</h2>
		<h5>Your Product will be Delivered In your Address Within 8 days </h5>
		<a href="index.jsp" class="btn btn-primary mt-5 mb-2">Home</a> <a
			href="userOrder.jsp" class="btn btn-danger mt-5 mb-2">View Order</a>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>