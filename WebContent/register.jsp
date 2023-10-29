<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid p-3 bg-light">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Registration Form</h4>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failMsg }">
							<p class="text-center text-danger">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<br>
						<form action="register" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputfname">Fisrt Name</label> <input type="text"
										class="form-control" id="inputfname" placeholder="First name"
										required="required" name="firstname">
								</div>
								<div class="form-group col-md-6">
									<label for="inputlname">Last Name</label> <input type="text"
										class="form-control" id="inputlname" placeholder="Last Name"
										required="required" name="lastname">
								</div>
							</div>
							<div class="form-group">
								<label for="inputusername">Username</label> <input type="text"
									class="form-control" id="inputuname" placeholder="username"
									required="required" name="username">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Email</label> <input type="email"
										class="form-control" id="inputEmail4"
										placeholder="Enter your email" required="required"
										name="email">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Password</label> <input
										type="password" class="form-control" id="inputPassword4"
										placeholder="Password" required="required" name="password">
								</div>
							</div>
							<div class="form-group">
								<label for="inputAddress">Address</label> <input type="text"
									class="form-control" id="inputAddress"
									placeholder="1234 Main St" name="address">
							</div>
							<div class="form-group">
								<label for="inputphone">Phone No</label> <input type="text"
									class="form-control" id="inputphone" placeholder="Phone number"
									name="phone">
							</div>
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="gridCheck"
										name="check"> <label class="form-check-label"
										for="gridCheck">Agree to Terms of Service</label>
								</div>
							</div>
							<button type="submit" class="btn btn-info">Sign Up</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>