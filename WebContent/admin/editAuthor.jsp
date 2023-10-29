<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.AuthorDAOImpl"%>
<%@page import="rm.entity.authorDB"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Edit Author</title>
<%@include file="allCss.jsp"%>

</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3 bg-light">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Author</h4>

						<%
						String fullname = request.getParameter("name");
						AuthorDAOImpl dao = new AuthorDAOImpl(DBConnect.getConn());
						authorDB a = dao.getAuthorByName(fullname);
						%>
						<br>
						<form action="../editAuthor" method="post">
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Full Name</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="fullname" readonly value="<%=a.getFullName()%>">
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputTitle">Birth Date</label> <input type="text"
										class="form-control" id="inputuname" required="required"
										name="birthdate" value="<%=a.getBirthDate()%>">
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<label for="inputusername">Description</label>
									<textarea id="text" name="description" rows="9" cols="46"
										value="<%=a.getDescription()%>"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="photo" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>
							<button type="submit" class="btn btn-primary">Edit Author</button>
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