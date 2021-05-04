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
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>UnTrust Bank</h1>

	<div class="container d-flex justify-content-center">
		<div class="form-group">
			<h1>Please Register Here</h1>
			
			<p class="text-danger"><form:errors path="user.*"/></p>
			
			<form:form method="POST" action="/registration" modelAttribute="user">
				<p>
					<form:label path="firstName">First Name:</form:label>
					<form:input type="text" path="firstName" class="form-control" />
				</p>
				<p>
					<form:label path="lastName">Last Name:</form:label>
					<form:input type="text" path="lastName" class="form-control"/>
				</p>
				<p>
					<form:label path="email">Email:</form:label>
					<form:input type="email" path="email" class="form-control"/>
				</p>
				<p>
					<form:label path="password">Password:</form:label>
					<form:password path="password" class="form-control"/>
				</p>
				<p>
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" class="form-control"/>
				</p>
				<input type="submit" value="Register!" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
	<a href="/">Login?</a>
</body>
</html>