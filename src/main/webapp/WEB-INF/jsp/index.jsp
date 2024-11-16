<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Homepage</title>
    <%@include file="lib-css.jsp" %>
</head>
</head>
<body>
	<div class="container">
	    <h2>Welcome to KA Inventory Management System!</h2>

		<ul>
			<li><a href="/about">About</a></li>
			<li><a href="/contact">Contact</a></li>
			<li><a href="/products">Products</a></li>
			<li><a href="/register">Register</a></li>
            <li><a href="/login">Login</a></li>
		</ul>

        <%@include file="footer.html" %>
	</div>

	<%@include file="lib-js.jsp" %>
</body>
</html>