<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DAO.BookDAOImpl"%>
<%@page import="rm.entity.BookDB"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Review Page</title>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="all_component/navbar.jsp"%>

	<%
	User u = (User) session.getAttribute("userobj");
	int id = Integer.parseInt(request.getParameter("bookid"));
	BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
	BookDB b = dao.getBookById(id);
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
						<h4 class="text-center">Review Us</h4>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failMsg }">
							<p class="text-center text-danger">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>
						<br>
						<form action="add_review" method="post"
							enctype="multipart/form-data">
							
							<input type="hidden" name="bookid" value="<%=b.getBookid()%>">
							
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Username</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="username" value="<%=u.getUsername()%>" readonly>
								</div>
							</div>

							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Rating (out of 5)</label> <input
										type="text" class="form-control" id="inputuname"
										required="required" name="rating">
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputusername">Comment</label>
									<textarea class="form-control" id="text" name="comment"
										rows="7"></textarea>
								</div>
							</div>
							<button type="submit" class="btn btn-info">Send Review</button>
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