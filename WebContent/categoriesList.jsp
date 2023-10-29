<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.entity.CategoryDB"%>
<%@page import="rm.DAO.CategoryDAOImpl"%>
<%@page import="rm.DAO.UserDAO"%>
<%@page import="rm.entity.User"%>

<!DOCTYPE html>
<html>
<head>
<title>Categories List</title>
<%@include file="all_component/allCss.jsp"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.back-img {
	background: url("book/home.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>

</head>
<body Style="background-color: #f7f7f7">
	<%@include file="all_component/navbar.jsp"%>
	
	<div class="container-fluid">
		<h3 class="text-center mt-2">All Categories</h3>
		<div class="row p-3">
			<%
			CategoryDAOImpl dao = new CategoryDAOImpl(DBConnect.getConn());
			List<CategoryDB> list = dao.AllCategories();
			for (CategoryDB c : list) {
			%>
			<div class="col-md-4">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="book/<%=c.getPhoto()%>"
							style="width: 300px; height: 200px" class="img-thumblin">
						<p class="mt-3"><%=c.getName()%></p>

						<div class="text-center">
							<a href="CategoryPage.jsp?name=<%=c.getName()%>"
								class="btn btn-success btn-sm"><i
								class="fa-solid fa-eye"></i> View Category</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<!-- End New Books -->
	<!-- End Category Books -->
	<%@include file="all_component/footer.jsp"%>
</body>
</html>

