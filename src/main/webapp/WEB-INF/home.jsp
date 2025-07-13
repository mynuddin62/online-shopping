<%--
  User: ratul
  Date: 13/07/2025
  Time: 11:57 am
--%>
<%@ page import="com.faith.oneUmmah.dto.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>
<% List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");%>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    </thead>

    <% for(ProductDTO product: products) {%>
    <tr>
        <td><%= product.getName()%></td>
        <td><%= product.getDescription()%></td>
        <td><%= product.getPrice()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
