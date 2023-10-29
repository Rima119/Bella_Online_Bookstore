<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@page import="rm.entity.User"%>

<div class="container-fluid"
	style="height: 10px; background-color: #b2c1fc"></div>

<div class="container-fluid p-3 bg-white" style="height: 65px;">
	<div class="row">
		<div class="col-md-3" style="color: #d67d63;">
			<h3>Bella Online Bookstore</h3>
		</div>

		<div class="col-md-3">
			<c:if test="${not empty userobj }">
				<a class="btn btn-success text-white"><i
					class="fa-solid fa-user"></i> ${ userobj.username}</a>
				<a data-toggle="modal" data-target="#exampleModalCenter"
					class="btn btn-primary text-white"><i
					class="fa-solid fa-right-from-bracket"></i> Sign out</a>
			</c:if>
			<c:if test="${empty userobj }">
				<a href="../signin.jsp" class="btn btn-success"><i
					class="fa-solid fa-right-to-bracket"></i> Sign in</a>
				<a href="../register.jsp" class="btn btn-primary"><i
					class="fa-solid fa-user-plus"></i> Register</a>
			</c:if>
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



<nav class="navbar navbar-expand-lg navbar-dark bg-personized">
	<a class="navbar-brand" href="home.jsp"><i
		class="fa-solid fa-house"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
	</div>
</nav>