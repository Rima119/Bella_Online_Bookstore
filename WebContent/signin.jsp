<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid p-3 bg-light">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Sign in</h4>
						<br>
						<c:if test="${not empty failMsg }">
							<h5 class="text-center text-danger">${failMsg}</h5>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="signin" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									required="required" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" required="required" name="password">
							</div>
							<br>
							<div class="text-center">
								<button type="submit" class="btn btn-info">Sign in</button>
							</div>
							<p style="color: black; padding-left: 15px;">
								<br> <a style="color: blue; text-decoration: none;" href="forget_pass.jsp">Forgot
									password?&emsp;&emsp;&emsp;&emsp;</a> <a style="color: blue; text-decoration: none;"
									href="register.jsp">&emsp;&emsp;&emsp;&emsp;Sign Up</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="all_component/footer.jsp"%>
</body>
</html>