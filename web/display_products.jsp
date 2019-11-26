<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/includes/header.jsp" %>
<h1>Products</h1>
<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <th><strong>Code</strong></th>
        <th><strong>Name</strong></th>
        <th><strong>Description</strong></th>
        <th><strong>Weight</strong></th>
        <th><strong>Price</strong></th>
    <c:forEach var="pro" items="${products}">
    <tr>
        <td>${pro.code}</td>
        <td>${pro.name}</td>
        <td>${pro.description}</td>
        <td>${pro.weight}g</td>
        <td>$${pro.price}</td>
        <td><a href="updateProduct?productCode=${pro.code}">Edit</a></td>
        <td><a href="deleteProduct?productCode=${pro.code}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<br>
<a href="addProduct"><button type="button">Add Product</button></a>
<%@ include file="/includes/footer.jsp" %>