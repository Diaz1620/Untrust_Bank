<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:foreach; c:if -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- formatting things like dates -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<h1>UnTrust Bank</h1>
	</div>
	<div class="container d-flex justify-content-center">
		<div class="form-group">
			<h1>Please sign in</h1>
			<p class="text-danger"><c:out value="${error}" /></p>
			<form method="post" action="/login">
				<p>
					<label for="email">Email</label>
					<input type="text" id="email" name="email" class="form-control"/>
				</p>
				<p>
					<label for="password">Password</label>
					<input type="password" id="password" name="password" class="form-control"/>
				</p>
				<input type="submit" value="Login!" class="btn btn-primary"/>
			</form>    
			<br><br>
			<h5>Don't have an account? <a href="/register">Register here!</a></h5>
		</div>
	</div>
</body>
</html>