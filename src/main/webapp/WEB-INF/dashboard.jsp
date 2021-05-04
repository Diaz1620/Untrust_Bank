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
	<title>User Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header m-3">
		<h1>UnTrust Bank</h1>
		<p class="d-flex justify-content-center"><a href="">Accounts</a> | <a href="">Transfers</a> | <a href="">Send Money</a> | <a href="">Account Services</a></p>
	</div>
	<div class="container">
		<h1>Welcome ${loggedinuser.firstName} ${loggedinuser.lastName}</h1>
		<c:forEach items="${loggedinuser.accounts}" var="acc">
		<div class="w-50 mt-5 p-1 border" style="height: 100px;">
			<h4>${acc.type}</h4>
			<h5>Current Balance: $ ${acc.balance}</h5>
		</div>
		</c:forEach>
		<div class="w-25 mt-5 p-1 border" style="height: 100px;">
			<h4><a style="color: black;" href="/deposit">Deposit</a></h4>
		</div>
		<div class="w-25 mt-5 p-1 border" style="height: 100px;">
			<h4><a style="color: black;" href="/withdraw">Withdraw</a></h4>
		</div>
	</div>
	<div class="footer">
		<a href="/logout">Logout</a>
	</div>
</body>
</html>