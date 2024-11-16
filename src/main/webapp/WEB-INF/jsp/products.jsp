<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KA Inventory System | Products</title>
    <%@include file="lib-css.jsp" %>
</head>
<body>
	<div class="container">
	    <section class="user">
            <h1>Welcome, <c:if test="${ not empty username }">${username}</c:if>!</h1>
            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                <button class="btn btn-outline-secondary" type="submit">Logout</button>
            </form:form>
        </div>

        <section class="table">
            <h1>KA Products</h1>

            <c:if test="${empty products}">
            <p style="color: red;">No product(s) found.</p>
            </c:if>

            <c:if test="${not empty products}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Category</th>
                            <th scope="col">Price Per Unit (MYR)</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">#Action</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="product" items="${products}" varStatus="row">
                            <tr>
                                <td>${row.index+1}</td>
                                <td><a href="/products/${product.id}">${product.name}</a></td>
                                <td>${product.description}</td>
                                <td>${product.category}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>
                                    <a href="/products/${product.id}/delete" class="btn btn-outline-danger btn-sm" role="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </section>

        <section class="product-new">
            <p>
                <a href="/products/new" class="btn btn-primary" role="button">Create New Product</a>
            </p>
        </section>

        <%@include file="footer.html" %>
    </div>

	<%@include file="lib-js.jsp" %>
</body>
</html>