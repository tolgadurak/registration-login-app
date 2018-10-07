<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param value="Login Page" name="title"/>
</jsp:include>
<body>
	<div class="container-fluid">
		<section class="container container-width-500">
			<c:if test="${not empty validationErrors}">
				<div id="validationErrors" class="alert alert-danger alert-dismissible fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<ul>
						<c:forEach items="${validationErrors}" var="validationError">
							<li>${validationError}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<form:form action="login" method="post" modelAttribute="loginDto">
				<h3 class="dark-grey">Login</h3>

				<div class="form-group col-lg-12">
					<label>Username:</label>
					<form:input name="username" path="username" class="form-control"
						id="username" placeholder="Username" />
				</div>

				<div class="form-group col-lg-12">
					<label>Password:</label>
					<form:input type="password" name="password" path="password"
						class="form-control" id="password" placeholder="Password" />
				</div>

				<div class="form-group col-lg-12">
					<button type="submit" class="btn btn-success pull-right">Login</button>
				</div>
			</form:form>
		</section>
	</div>
</body>
</html>