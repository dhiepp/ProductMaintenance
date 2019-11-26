<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<h1>Are you sure you want to delete this product?</h1>
<table>
    <tr>
        <td>Product Code:</td>
        <td>${product.code}</td>
    </tr>
    <tr>
        <td>Product Name:</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Product Description:</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Product Weight:</td>
        <td>${product.weight}</td>
    </tr>
    <tr>
        <td>Product Price:</td>
        <td>${product.price}</td>
    </tr>
</table>
<br>
<form action="deleteProduct" method="post">
    <input type="hidden" name="productCode" value="${product.code}" />
    <input type="submit" value="Yes" />
    <a href="displayProducts"><button type="button">No</button></a>
</form>
<%@ include file="/includes/footer.jsp" %>