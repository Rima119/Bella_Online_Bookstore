<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Add Books</title>
<%@include file="allCss.jsp"%>

</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../signin.jsp" />
	</c:if>
	<div class="container-fluid p-3 bg-light">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Add Books</h4>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failMsg }">
							<p class="text-center text-danger">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>
						<br>
						<form action="../add_book" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Title</label> <input type="text"
										class="form-control" id="inputuname" placeholder="Book Title"
										required="required" name="title">
								</div>
							</div>
							<div class="form-group">
								<label for="inputusername">Author</label> <input type="text"
									class="form-control" id="inputuname" placeholder="Book Author"
									required="required" name="author">
							</div>
							<div class="form-group">
								<label for="inputusername">Publisher</label> <input type="text"
									class="form-control" id="inputuname" placeholder="Publisher"
									required="required" name="publisher">
							</div>
							<div class="form-group">
								<label for="inputusername">Edition</label> <input type="text"
									class="form-control" id="inputuname" placeholder="Edition"
									required="required" name="edition">
							</div>
							<div class="form-group">
								<label for="inputState">Category</label> <select
									class="form-control" id="inputState" required="required"
									name="category">
									<option selected>--select--</option>
									<option value="Computers and Technology">Computers and Technology</option>
									<option value="Business and Investing">Business and Investing</option>
									<option value="Health, Fitness and Dieting">Health, Fitness and Dieting</option>
									<option value="Biographies and Memoirs">Biographies and Memoirs</option>
									<option value="Literature and Fiction">Literature and Fiction</option>
									<option value="Science Fiction and Fantasy">Science Fiction and Fantasy</option>
								</select>
							</div>
							<div class="form-group">
								<label for="inputusername">Supplier</label> <input type="text"
									class="form-control" id="inputuname" placeholder="Supplier"
									required="required" name="supplier">
							</div>
							<div class="form-group">
								<label for="inputusername">Quantity</label> <input type="number"
									class="form-control" id="inputuname"
									placeholder="Available quantity" required="required"
									name="quantity">
							</div>
							<div class="form-group">
								<label for="inputusername">Price</label> <input type="text"
									class="form-control" id="inputuname" placeholder="Price"
									required="required" name="price">
							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select
									class="form-control" id="inputState" required="required"
									name="status">
									<option selected>--select--</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="img" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>
							<button type="submit" class="btn btn-primary">Add Book</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-to: 130px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>