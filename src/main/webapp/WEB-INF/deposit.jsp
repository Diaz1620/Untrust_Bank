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
	<title>Deposit</title>
	<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header m-3">
		<h1>UnTrust Bank</h1>
		<a href="/dashboard">Home</a>
		<p class="d-flex justify-content-center"><a href="">Accounts</a> | <a href="">Transfers</a> | <a href="">Send Money</a> | <a href="">Account Services</a></p>
	</div>

	<div class="container p-5 m-5">
		<form action="/makedeposit" method="post" class="form-group">
			<div class="m-3">
				<label>Select Account you would like to deposit to:</label>
				<select name="selectedAcct" class="form-control col-3">
					<c:forEach items="${allaccounts}" var="acc">
						<option value="${acc.id}">${acc.type}</option>
					</c:forEach>
				</select>
			</div>
			<div class="m-3">
				<label path="balance">Specify amount you would like to deposit:</label>
				<errors path="balance" class="text-danger"/>
				<input type="number" step=".01" name="amount" class="form-control col-3"/>
			</div>
			<input class="btn btn-danger m-3" type="submit" value="Deposit"/>
	</form>

	</div>
</body>
</html>