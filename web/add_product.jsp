<%-- 
    Document   : add_product
    Created on : Sep 28, 2019, 10:13:24 AM
    Author     : Doan Hong Hiep - B16DCPT049 - Nhom 6
--%>

<%@page import="model.Product"%>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product("", "", -1);
    }
    
    String message[] = (String[])request.getAttribute("message");
    if (message == null) message = new String[3];
    for (int i=0; i<3; i++) {
        if (message[i] == null) {
            message[i] = "";
        }
    }
%>

<%@ include file="/includes/header.jsp" %>

<h1>Add Product</h1>
<form action="addProduct" method="post">
    <table>
        <tr>
            <td>Product Code:</td>
            <td><input type="text" name="code" value="<%= product.getCode() %>"><i> <%= message[0] %></i></td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td><input size="50" type="text" name="desc" value="<%= product.getDescription() %>"><i> <%= message[1] %></i></td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td><input type="text" name="price" value="<%= product.getPrice()>=0?product.getPrice():"" %>"><i> <%= message[2] %></i></td>
        </tr>
    </table>
    <br>

    <input type="submit" value="Add Product">
    <a href="displayProducts"><button type="button">View Products</button></a>
</form>
                    
<%@ include file="/includes/footer.jsp" %>