<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}
</style>
<title>${userobj.username} Dashboard</title>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="signin.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<c:if test="${not empty userobj}">
			<h3 class="text-center mt-3">Hello, ${userobj.firstname} ${userobj.lastname}</h3>
		</c:if>
		<div class="row p-5">
			<div class="col-md-4">
				<a href="userSell.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fa-solid fa-book-open fa-2x"></i>
								<h4>Sell Reused Book</h4>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="reusedBook_user.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fa-solid fa-book-open fa-2x"></i>
								<h4>Reused Book</h4>
							</div>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="editProfile.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-info">
								<i class="fa-solid fa-shield fa-2x"></i>
								<h4>Login & Security (Edit Profile)</h4>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-6 mt-3">
				<a href="userOrder.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-warning">
								<i class="fa-solid fa-box-open fa-2x"></i>
								<h4>My Order</h4>
								<p>Track your order</p>
							</div>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-6 mt-3">
				<a href="support.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-muted">
								<i class="fa-solid fa-headset fa-2x"></i>
								<h4>Help Center</h4>
								<p>24/7 Service</p>
							</div>
						</div>
					</div>
				</a>
			</div>
			
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>