<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@include file="allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
				<a href="addbook.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-plus fa-3x text-primary"></i><br>
							<h4>Add Books</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="AllBook.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-book-open fa-3x text-danger"></i> <br>
							<h4>All Books</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="orders.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-check fa-3x text-warning"></i><br>
							<h4>Orders</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="AllUser.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-users fa-3x text-danger"></i><br>
							<h4>All users</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a href="addCategory.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-plus fa-3x text-primary"></i> <br>
							<h4>Add Categories</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a href="allCategories.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-boxes-stacked fa-3x text-danger"></i> <br>
							<h4>All Categories</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a href="addAuthor.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-plus fa-3x text-primary"></i><br>
							<h4>Add Author</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a href="allAuthor.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-user-tie fa-3x text-danger"></i> <br>
							<h4>All Authors</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a href="allMessages.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-envelope-open fa-3x text-success"></i> <br>
							<h4>Messages</h4>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3 mt-2">
				<a data-toggle="modal" data-target="#exampleModalCenter">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-right-from-bracket fa-3x text-secondary"></i>
							<br>
							<h4>Sign out</h4>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<!-- sign out modal -->
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
					<h4>Do You want sign out?</h4>
					<div class="text-center">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<a href="../signout" type="button"
							class="btn btn-primary text-white">Sign out</a>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- end sign out modal -->
	<div style="margin-to: 130px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>