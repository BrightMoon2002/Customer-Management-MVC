<%@ page import="model.Customer" %>
<%@ page import="service.ICustomerService" %>
<%@ page import="service.CustomerServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 09/11/2021
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>create customer</title>
</head>
<body>
<h1>Create customer</h1>
<form method="post">
    <input type="text" name="id" placeholder="input Id">
    <input type="text" name="name" placeholder="input name">
    <input type="text" name="email" placeholder="input email">
    <input type="text" name="address" placeholder="input address">
    <button type="submit">Create</button>
</form>


</body>
</html>
