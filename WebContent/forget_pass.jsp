<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
body {
	height: 850px;
	background-image: url("book/pass.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.wrapper {
	width: 400px;
	height: 450px;
	margin: 100px auto;
	background-color: black;
	opacity: .8;
	color: white;
	padding: 27px 15px;
}

.form-control {
	width: 300px;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${not empty succMsg }">
		<p class="alert alert-success">${succMsg }</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failMsg }">
		<p class="alert alert-danger">${failMsg }</p>
		<c:remove var="failMsg" scope="session" />
	</c:if>

	<div class="wrapper">
		<div style="text-align: center;">
			<h1
				style="text-align: center; font-size: 35px; font-family: monospace; color: white;">Change
				Your Password</h1>
			<br> <br>
		</div>
		<div style="padding-left: 30px;">
			<form action="update_pass" method="post">
				<input type="text" name="email" class="form-control"
					placeholder="Email" required="required"><br> <input
					type="text" name="username" class="form-control"
					placeholder="username" required="required"><br> <input
					type="password" name="password" class="form-control"
					placeholder="New Password" required="required"><br>
				<button class="btn btn-dark" type="submit" name="submit">Update</button>
			</form>

		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>