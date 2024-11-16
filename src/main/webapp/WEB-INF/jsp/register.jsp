<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <%@include file="lib-css.jsp" %>
</head>
<body>
	<div class="container position-relative"  aria-live="polite" aria-atomic="true">
	    <h2>Register</h2>

	    <div class="toast-container p-3 top-0 start-50 translate-middle-x">
            <div class="toast text-danger border-0 <c:if test="${not empty errMsg}">show</c:if>" role="alert" aria-live="assertive" aria-atomic="true">
              <div class="d-flex">
                <div class="toast-body">
                  ${errMsg} Please try again.
                </div>
                <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
              </div>
            </div>
        </div>

        <form:form action="/register" modelatrribute="user" method="post">
            <label class="form-label" for="username">Username</label><br>
            <input class="form-control" type="text" id="username" name="username" required /><br>

            <label class="form-label" for="email">Email</label><br>
            <input class="form-control" type="email" id="email" name="email" required /><br>

            <label class="form-label" for="password">Password</label><br>
            <input class="form-control" type="password" id="password" name="password" required /><br>

            <label class="form-label" for="cpassword">Confirm password</label><br>
            <input class="form-control" type="password" id="cpassword" name="cpassword" required /><br>

            <button class="btn btn-info" type="submit" style="margin-top: 20px;">Register</button>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>

        <%@include file="footer.html" %>
	</div>

	<%@include file="lib-js.jsp" %>
</body>
</html>