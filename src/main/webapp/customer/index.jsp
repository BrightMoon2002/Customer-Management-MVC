<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 09/11/2021
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach khach hang</title>
    <link rel="stylesheet" href="css1.css">
</head>
<body>
<h1>Danh sách khách hàng</h1>
<form action="">
    <table>
        <c:forEach items="${ds}" var="customerList">
            <tr>
                <td>${customerList.id}</td>
                <td>${customerList.name}</td>
                <td>${customerList.email}</td>
                <td>${customerList.address}</td>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>
