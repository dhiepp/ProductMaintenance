<%-- 
    Document   : display_products
    Created on : Sep 28, 2019, 8:55:33 AM
    Author     : 503
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>

<%@ include file="/includes/header.jsp" %>

<%
    ArrayList<Product> products = (ArrayList)request.getAttribute("products");

    if (products == null) {
        response.sendRedirect("displayProducts");
        return;
    }
%>
<h1>Products</h1>
<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <th><strong>Code</strong></th>
        <th><strong>Description</strong></th>
        <th><strong>Price</strong></th>
    <%
        for (Product pro : products) {
           %>
    <tr>
        <td><%= pro.getCode() %></td>
        <td><%= pro.getDescription() %></td>
        <td><%= "$" + pro.getPrice() %></td>
        <td><a href="updateProduct?productCode=<%= pro.getCode() %>">Edit</a></td>
        <td><a href="deleteProduct?productCode=<%= pro.getCode() %>">Delete</a></td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="addProduct"><button type="button">Add Product</button></a>

<%@ include file="/includes/footer.jsp" %>