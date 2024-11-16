<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KA Inventory System | New Product</title>
    <%@include file="lib-css.jsp" %>
</head>
<body>
	<div class="container position-relative" aria-live="polite" aria-atomic="true">
	    <h1>Add New Product</h1>

        <div class="toast-container p-3 top-0 start-50 translate-middle-x">
            <div class="toast text-danger border-0 <c:if test="${not empty errMsg}">show</c:if>" role="alert" aria-live="assertive" aria-atomic="true">
              <div class="d-flex">
                <div class="toast-body">
                  ${errMsg}
                </div>
                <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
              </div>
            </div>
        </div>

        <form:form method="post" action="/products/new" modelattribute="product">
            <div class="mb-3" style="margin-top: 10px; margin-bottom: 10px;">
                <label class="form-label" for="name">Name</label>
                <input class="form-control type="text" id="name" name="name" />
            </div>

            <div class="mb-3" style="margin-top: 10px; margin-bottom: 10px;">
                <label class="form-label" for="description">Description</label>
                <input class="form-control" type="text" id="description" name="description" />
            </div>

            <div class="mb-3" style="margin-top: 10px; margin-bottom: 10px;">
                <label class="form-label" for="category">Category</label>
                <input class="form-control" type="text" id="category" name="category" />
            </div>

            <div class="mb-3" style="margin-top: 10px; margin-bottom: 10px;">
                <label class="form-label" for="price">Price</label>
                <input class="form-control" type="number" id="price" name="price" />
            </div>

            <div class="mb-3" style="margin-top: 10px; margin-bottom: 10px;">
                <label class="form-label" for="quantity">Quantity</label>
                <input class="form-control" type="number" id="quantity" name="quantity" />
            </div>

            <div class="mb-3" style="margin-top: 20px; margin-bottom: 10px;">
                <a href="/products" class="btn btn-danger" role="button">Cancel</a>
                <button class="btn btn-success" type="submit">Create</button>
            </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>

	    <%@include file="footer.html" %>
	</div>


	<%@include file="lib-js.jsp" %>
</body>
</html>