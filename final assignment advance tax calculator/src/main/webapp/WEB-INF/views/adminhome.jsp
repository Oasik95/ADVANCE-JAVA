<%--
  Created by IntelliJ IDEA.
  User: oasik
  Date: 1/1/2023
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Responsive Table</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/styles/css/style.css" />" rel="stylesheet">

</head>


<div align="right">
    <a class="dropdown-item" href="<c:url value="/logout" />" methods="post"  >
        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
        Logout
    </a>
</div>

<table class="table">
    <thead>
    <tr>
        <th>SERIAL</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>USER NAME</th>
        <th>GENDEN</th>
        <th>EMAIL</th>
        <th>DATE OF BIRTH</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="history" items="${historyList}">
        <tr>
            <td data-label="S.No">${history.id}</td>
            <td data-label="S.No">${history.firstname}</td>
            <td data-label="Age">${history.lastname}</td>
            <td data-label="Age">${history.username}</td>
            <td data-label="Name">${history.gender}</td>
            <td data-label="Name">${history.email}</td>
            <td data-label="Name">${history.dob}</td>


        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
