<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Contact Us</title>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="all_component/navbar.jsp"%>
	<%
	User u = (User) session.getAttribute("userobj");
	%>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failMsg }">
		<div class="alert alert-danger" role="alert">${failMsg }</div>
		<c:remove var="failMsg" scope="session" />
	</c:if>


	<div class="container-fluid p-3 bg-light">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Contact Us</h4>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failMsg }">
							<p class="text-center text-danger">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>
						<br>
						<form action="add_message" method="post"
							enctype="multipart/form-data">
							
							
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Username</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="username"  value="<%=u.getUsername()%>"  readonly>
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Email</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="email" value="<%=u.getEmail()%>"  readonly>
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Subject</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="subject">
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputusername">Message</label>
									<textarea class="form-control" id="text" name="message"
										rows="7"></textarea>
								</div>
							</div>
							<button type="submit" class="btn btn-info">Send Message</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-to: 130px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>