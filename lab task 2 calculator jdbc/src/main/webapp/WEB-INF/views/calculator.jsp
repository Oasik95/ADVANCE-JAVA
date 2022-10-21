<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/13/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>calculator</title>
</head>
<body>

<form method="post" action="calculate">
  <fieldset >
    <legend>addtion</legend>
  <table>
  <tr>
    <td>1st number</td>
    <td> <input type="number" name="number1" id="x"/></td>
  </tr>
    <tr>
      <td>2nd number</td>
      <td> <input type="number" name="number2" id="y"/></td>
    </tr>
  <td><input type="submit" value="calculate"></td>
    <tr>
    <td>ANS =</td>
    <td>${id}</td>
    </tr>
  </table>
  </fieldset>
</form>
<form method="post" action="calculatesub">
  <fieldset >
    <legend>subtraction</legend>
    <table>
      <tr>
        <td>1st number</td>
        <td> <input type="number" name="number1" id="x"/></td>
      </tr>
      <tr>
        <td>2nd number</td>
        <td> <input type="number" name="number2" id="y"/></td>
      </tr>
      <td><input type="submit" value="calculate"></td>
      <tr>
        <td>ANS =</td>
        <td>${id1}</td>
      </tr>
    </table>
  </fieldset>
</form>

</body>
</html>
