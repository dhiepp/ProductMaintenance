<%-- 
    Document   : delete_product
    Created on : 17-Oct-2019, 11:20:25
    Author     : Hiep
--%>

<%@page import="model.Product"%>
<%
    Product product = (Product)request.getAttribute("product");
    
    if (product == null) {
        response.sendRedirect("displayProducts");
        return;
    }
%>

<%@ include file="/includes/header.jsp" %>

<h1>Are you sure you want to delete this product?</h1>
<table>
    <tr>
        <td>Product Code:</td>
        <td><%= product.getCode() %></td>
    </tr>
    <tr>
        <td>Product Description:</td>
        <td><%= product.getDescription() %></td>
    </tr>
    <tr>
        <td>Product Price:</td>
        <td><%= product.getPrice() %></td>
    </tr>
</table>
<br>
<form action="deleteProduct" method="post">
    <input type="hidden" name="productCode" value="<%= product.getCode() %>" />
    <input type="submit" value="Yes" />
    <a href="displayProducts"><button type="button">No</button></a>
</form>

<%@ include file="/includes/footer.jsp" %>