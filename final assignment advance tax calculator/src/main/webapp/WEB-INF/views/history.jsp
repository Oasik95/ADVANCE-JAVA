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

<h3> tax input :</h3>
<table class="table">
  <thead>
  <tr>
    <th>SERIAL</th>
    <th>fyear</th>
    <th>zone</th>
    <th>category</th>
    <th>grosssalary</th>
    <th>basicsalary</th>
    <th>houserent</th>
    <th>conveyance</th>
    <th>festival</th>
    <th>others</th>
    <th>medical</th>



  </tr>

  </thead>
  <tbody>
  <c:forEach var="history" items="${historyList}">


    <tr>
      <td data-label="Name">${history.id}</td>
      <td data-label="Name">${history.fyear}</td>
      <td data-label="Name">${history.zoon}</td>
      <td data-label="Name">${history.category}</td>
      <td data-label="Name">${history.grosssalary}</td>
      <td data-label="Name">${history.basicsalary}</td>
      <td data-label="Name">${history.houserent}</td>
      <td data-label="Name">${history.conveyance}</td>
      <td data-label="Name">${history.festival}</td>
      <td data-label="Name">${history.others}</td>
      <td data-label="Name">${history.medical}</td>



    </tr>

  </c:forEach>








  </tbody>
</table>
<h3>Yearly tax Results :</h3>

<table class="table">
  <thead>
  <tr>
    <th>SERIAL</th>
    <th>fyear</th>


    <th>basicsalary</th>
    <th>houserent</th>
    <th>conveyance</th>
    <th>festival</th>
    <th>others</th>
    <th>medical</th>
    <th>total</th>
    <th>totalyearlytax</th>


  </tr>

  </thead>
  <tbody>

  <c:forEach var="result" items="${resultList}">

    <tr>
      <td data-label="Name">${result.id}</td>
      <td data-label="Name">${result.fyear}</td>


      <td data-label="Name">${result.basicsalary}</td>
      <td data-label="Name">${result.houserent}</td>
      <td data-label="Name">${result.conveyance}</td>
      <td data-label="Name">${result.festival}</td>
      <td data-label="Name">${result.others}</td>
      <td data-label="Name">${result.medical}</td>
      <td data-label="Name">${result.total}</td>
      <td data-label="Name">${result.totalyearlytax}</td>


    </tr>

  </c:forEach>








  </tbody>
</table>
</body>
</html>