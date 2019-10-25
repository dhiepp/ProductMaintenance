<%-- 
    Document   : update_product
    Created on : 17-Oct-2019, 12:30:53
    Author     : Hiep
--%>

<%@page import="model.Product"%>
<%
    Product product = (Product)request.getAttribute("product");
    
    if (product == null) {
        response.sendRedirect("displayProducts");
        return;
    }
  
    String oldProductCode = (String) request.getAttribute("oldProductCode");
    if (oldProductCode == null) {
        oldProductCode = product.getCode();
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

<h1>Update Product</h1>
<form action="updateProduct" method="post">
    <input type="hidden" name="oldProductCode" value="<%= oldProductCode %>" />
    <table>
        <tr>
            <td>Product Code:</td>
            <td><input type="text" name="code" value="<%= product.getCode() %>"> <i><%= message[0] %></i></td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td><input size="50" type="text" name="desc" value="<%= product.getDescription() %>"> <i><%= message[1] %></i></td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td><input type="text" name="price" value="<%= product.getPrice()>=0?product.getPrice():"" %>"> <i><%= message[2] %></i></td>
        </tr>
    </table>
    <br>

    <input type="submit" value="Update Product">
    <a href="displayProducts"><button type="button">View Products</button></a>
</form>
                    
<%@ include file="/includes/footer.jsp" %>