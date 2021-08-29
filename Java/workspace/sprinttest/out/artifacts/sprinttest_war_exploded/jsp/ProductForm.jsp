<%--
  Created by IntelliJ IDEA.
  User: wk
  Date: 2020/1/1
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
    <!-- <style type="text/css">@import url(css/main.css);</style> -->
</head>
<body>
    <form method="post" action="save-product">
        <h1>Add Product <span>Please use this for to enter product details</span></h1>
        <label>
        <span>Product Name:</span>
        <input id="name" type="text" name="name" placeholder="The complete product name">
        </label>
        <label>
            <span>Description:</span>
            <input id="description" type="text" name="description" placeholder="The complete product description">
        </label>
        <label>
            <span>Price:</span>
            <input id="price" type="text" name="price" placeholder="The complete product price in #.## format">
        </label>
        <label>
            <span>&nbsp: </span>
            <input type="submit">
        </label>
    </form>
</body>
</html>
