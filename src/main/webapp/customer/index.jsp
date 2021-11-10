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
    <link rel="stylesheet" href="../css1.css">
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="customers?action=create">Create new Customer</a><br>
<a href="https://checkerviet.org">Home Page</a>

<form action="">
    <table>
        <c:forEach items="${ds}" var="customerList">
            <tr>
                <td>${customerList.id}</td>
                <td>
                    <a href="customers?action=person&name=${customerList.name}"> ${customerList.name}</a>

                </td>
                <td>${customerList.email}</td>
                <td>
                    <a href="customers?action=address&address=${customerList.address}">${customerList.address}</a>
                </td>
                <td>
                    <a style="border-collapse: collapse; border: 1px solid blue; color: blue " href="/customers?action=delete&id=${customerList.id}">delete</a>
                </td>
                <td>
                    <a href="/customers?action=edit&id=${customerList.id}" style="border-collapse: collapse; border: 1px solid blue; color: blue ">edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>
