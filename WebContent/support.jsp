<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Support Contact</title>
</head>
<body Style="background-color: #f7f7f7">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3 text-center">
				<div class="text-center" style="color: #50d4ab;">
					<i class="fa-solid fa-square-phone fa-5x"></i>
				</div>
				<h3>24/7 Support</h3>
				<h4>Phone Number</h4>
				<h5>254-522-232</h5>
			</div>
		</div>
		<div class="row p-5">
			<div class="col-md-6 offset-md-3 text-center">
				<div class="text-center" style="color: #8c7dfc;">
					<i class="fa-solid fa-envelope fa-5x"></i>
				</div>
				<h3>Response in 2-3 Business days</h3>
				<h4>Email</h4>
				<h5>support@bellabookstore.com</h5>
				<a href="contact_us.jsp" class="btn btn-primary">Contact us by
					email</a>
			</div>
		</div>
		<br>
		<div class="text-center">
			<a href="index.jsp" class="btn btn-primary">Home</a>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>