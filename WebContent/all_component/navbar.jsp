<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.DAO.UserDAO"%>
<%@page import="rm.entity.User"%>
<div class="container-fluid"
	style="height: 10px; background-color: #b2c1fc"></div>

<div class="container-fluid p-3 bg-white" style="height: 65px;">
	<div class="row">
		<div class="col-md-3" style="color: #d67d63;">
			<h3>Bella Online Bookstore</h3>
		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0" action="search.jsp"
				method="post">
				<input class="form-control mr-sm-2" type="search" name="search"
					placeholder="Enter Book Title or Category or Publisher" aria-label="Search">
				<button class="btn btn-info my-2 my-sm-0" style="color: white;" type="submit">Search</button>
			</form>
		</div>
		<c:if test="${not empty userobj }">
			<div class="col-md-3">
			<div class="row">
				<a href="shopCart.jsp" class="btn btn-warning mr-1"> <i
					class="fa-solid fa-cart-shopping"></i> Cart</a> 
				<a href="dashboard.jsp"
					class="btn btn-success mr-1"><i class="fa-solid fa-user"></i>
					${userobj.username }</a> 
				<a href="signout" class="btn btn-primary"><i
					class="fa-solid fa-arrow-right-from-bracket"></i> Sign out</a>
			</div>
			</div>
		</c:if>


		<c:if test="${empty userobj }">
			<div class="col-md-3">
				<a href="signin.jsp" class="btn btn-success"><i
					class="fa-solid fa-right-to-bracket"></i> Sign in</a> <a
					href="register.jsp" class="btn btn-primary"><i
					class="fa-solid fa-user-plus"></i> Register</a>
			</div>
		</c:if>


	</div>

</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-personized">
	<a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-house"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="allBooks.jsp"><i class="fa-solid fa-book"></i> Books</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Category </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="tech_books.jsp">Computers and
						Technology</a> <a class="dropdown-item" href="business_books.jsp">Business
						and Investing</a> <a class="dropdown-item" href="health_books.jsp">Health,
						Fitness and Dieting</a> <a class="dropdown-item" href="bio_books.jsp">Biographies
						and Memoirs</a> <a class="dropdown-item" href="litter_books.jsp">Literature
						and Fiction</a> <a class="dropdown-item" href="scfic_books.jsp">Science
						Fiction and Fantasy</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="categoriesList.jsp">All
						Categories</a> <a class="dropdown-item" href="new_books.jsp">New
						Books</a> <a class="dropdown-item" href="reused_books.jsp">Reused
						Books</a>
				</div></li>
				<li class="nav-item active"><a class="nav-link" href="dashboard.jsp">My Dashboard</a></li>
			
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a href="aboutUs.jsp" class="btn btn-light my-2 my-sm-0"
				type="submit"> <i class="fa-solid fa-circle-info"></i> About Us
			</a> <a href="contact_us.jsp" class="btn btn-light my-2 my-sm-0 ml-1"
				type="submit"> <i class="fa-solid fa-square-phone"></i> Contact
				Us
			</a>
		</form>
	</div>
</nav>