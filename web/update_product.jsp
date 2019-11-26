<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<h1>Update Product</h1>
<form action="updateProduct" method="post">
    <table>
        <tr>
            <td>Product Code:</td>
            <td><input type="text" name="code" value="${product.code}" readonly><i> ${message[0]}</i></td>
        </tr>
        <tr>
            <td>Product Name:</td>
            <td><input type="text" name="name" value="${product.name}"><i> ${message[1]}</i></td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td><input size="50" type="text" name="desc" value="${product.description}"><i> ${message[2]}</i></td>
        </tr>
        <tr>
            <td>Product Weight:</td>
            <td><input type="text" name="weight" value="${product.weight<0?'':product.weight}"><i> ${message[3]}</i></td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td><input type="text" name="price" value="${product.price<0?'':product.price}"><i> ${message[4]}</i></td>
        </tr>
    </table>
    <br>

    <input type="submit" value="Update Product">
    <a href="displayProducts"><button type="button">View Products</button></a>
</form>              
<%@ include file="/includes/footer.jsp" %>