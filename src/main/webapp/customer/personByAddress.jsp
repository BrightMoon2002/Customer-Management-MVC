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
<form action="">
    <table>
        <c:forEach items="${ds1}" var="customerList1">
            <tr>
                <td>${customerList1.id}</td>
                <td>
                    <a href="customers?action=person&name=${customerList1.name}"> ${customerList1.name}</a>

                </td>
                <td>${customerList1.email}</td>
                <td>
                    <a href="customers?action=address&address=${customerList1.address}">${customerList1.address}</a>
                </td>
                <td>
                    <a style="border-collapse: collapse; border: 1px solid blue; color: blue " href="/customers?action=delete">delete</a>
                </td>
                <td>
                    <a href="/customers?action=edit" style="border-collapse: collapse; border: 1px solid blue; color: blue ">edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>
