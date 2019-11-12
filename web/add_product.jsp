<%@page import="model.Product"%>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product("", "", "", -1, -1);
    }
    
    String message[] = (String[])request.getAttribute("message");
    if (message == null) message = new String[5];
    for (int i=0; i<5; i++) {
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
            <td>Product Name:</td>
            <td><input type="text" name="name" value="<%= product.getName() %>"><i> <%= message[1] %></i></td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td><input size="50" type="text" name="desc" value="<%= product.getDescription() %>"><i> <%= message[2] %></i></td>
        </tr>
        <tr>
            <td>Product Weight:</td>
            <td><input type="text" name="weight" value="<%= product.getPrice()>=0?product.getWeight():"" %>"><i> <%= message[3] %></i></td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td><input type="text" name="price" value="<%= product.getPrice()>=0?product.getPrice():"" %>"><i> <%= message[4] %></i></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Add Product">
    <a href="displayProducts"><button type="button">View Products</button></a>
</form>                  
<%@ include file="/includes/footer.jsp" %>