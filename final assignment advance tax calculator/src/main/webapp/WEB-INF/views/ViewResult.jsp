<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <title>Calculation !</title>
</head>
<body>
 <%
   Integer basic=(Integer) request.getAttribute("Basic");

   Integer house=(Integer) request.getAttribute("House");

   Integer conv=(Integer) request.getAttribute("Conv");

   Integer other=(Integer) request.getAttribute("Other");
   Integer festival=(Integer) request.getAttribute("Festival");
   Integer tot=(Integer) request.getAttribute("Total");
   Double tax=(Double) request.getAttribute("Tax");

     %>


  <h1 align="center">Income Tax Result</h1><br>

  <div align="center">

    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Area</th>

        <th scope="col">Yearly Taxable</th>
      </tr>
      </thead>
      <tbody>

      <tr>
        <th scope="row">1</th>
        <td>Basic Salary</td>

        <td>${taxResult.basicsalary}</td>
      </tr>
      <tr>
        <th scope="row">2</th>
        <td>House Rent</td>

        <td>${taxResult.houserent}</td>
      </tr>

      <tr>
        <th scope="row">3</th>
        <td>Conveyance</td>

        <td>${taxResult.conveyance}</td>
      </tr>


      <tr>
        <th scope="row">4</th>
        <td>Medical Allowance</td>

        <td>${taxResult.medical}</td>
      </tr>
      <tr>
        <th scope="row">5</th>
        <td>Others</td>

        <td>${taxResult.others}</td>
      </tr>

      <tr>
        <th scope="row">6</th>
        <td>Festival Bonus</td>

        <td>${taxResult.festival}</td>
      </tr>

      <tr>
        <th scope="row">6</th>
        <td>Total</td>

        <td>${taxResult.total}</td>
      </tr>


      </tbody>
    </table>
  </div>

 <div align="center">

   <td><h2>Total Yearly tax : ${taxResult.totalyearlytax} </h2></td>
   <td><h2></h2></td>
 </div>

 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>
</body>
</html>