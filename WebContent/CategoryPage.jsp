<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="rm.DAO.CategoryDAOImpl"%>
<%@page import="rm.entity.CategoryDB"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_component/allCss.jsp"%>
<title>Category Page</title>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<%
	String name = request.getParameter("name");
	CategoryDAOImpl dao = new CategoryDAOImpl(DBConnect.getConn());
	CategoryDB c = dao.getCategoryByName(name);
	%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="book/<%=c.getPhoto()%>"
					style="height: 300px; width: 300px"><br>
				<h4 class="mt-3">
					<span class="text" style="color: purple;"><%=c.getName()%></span>
				</h4>

			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<div class="text-center p-3">
					<h4 class="text-center">Description:</h4>
					<h4 style="text-align: left;">
						<span class="text-black"><font size="+0.5"><%=c.getDescription()%></font></span>
					</h4>
				</div>
				<%
				if (c.getName().equals("Computers and Technology")) {
				%>
				<a href="tech_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>
				<%
				} else if (c.getName().equals("Business and Investing")) {
				%>
				<a href="business_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>
				<%
				} else if (c.getName().equals("Health, Fitness and Dieting")) {
				%>
				<a href="health_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>
				<%
				} else if (c.getName().equals("Biographies and Memoirs")) {
				%>
				<a href="bio_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>
				<%
				} else if (c.getName().equals("Literature and Fiction")) {
				%>
				<a href="litter_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>
				<%
				} else if (c.getName().equals("Science Fiction and Fantasy")) {
				%>
				<a href="scfic_books.jsp" class="btn btn-success btn-sm ml-4"><i
					class="fa-solid fa-eye"></i> View Books of This Category</a>

			</div>
			<%
			}
			%>
		</div>
	</div>


	<%@include file="all_component/footer.jsp"%>
</body>
</html>