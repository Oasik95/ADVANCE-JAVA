<?php


?>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>


    <title>Login Form</title>
    <style>
        #s1
        {
            width: 310px;
            height: 400px;
            box-shadow: 0 0 3px 0 rgba(0,0,0,0,.3);
            background:rgb(233, 226, 226);
            padding: 25px;
            margin:7% auto 0 ;
            text-align: left;
            background-position: left;
            border-radius: 5%;
        }
        #s1 h1
        {
            width: 310px;
            text-align: center;
            background-color:#639e63;
            color: #fff;

        }

    </style>

</head>
<body>
<div id ="s1">

    <form action="ans" method="POST" class="login-email">
        <h1>Tax Calculator</h1>
        <tr>
            <td>Name</td>
            <td ><input type="text" placeholder="enter your name" name="empname" value="" required="please"></td></br></br>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" placeholder="enter your Monthly salary" name="Monthlysalary" ></td>
        </tr>





        <div class="btn">
            <input type="submit" value="Calculate"></button>
        </div>

        <h1>Result</h1>
        <tr>
            <td>yerarly tax =</td>
            <td>${employee.getTaxs()}</td>
        </tr>
        </br>
        <tr>
            <td>yerarly net salary =</td>
            <td>${employee.getNetsal()}</td>
        </tr>
        </br>
        <tr>
            <td>Monthly tax =</td>
            <td>${employee.getMonthlytaxs()}</td>
        </tr>
        </br>
        <tr>
            <td>Monthly salary =</td>
            <td>${employee.getMonthlyNetsal()}</td>
        </tr>







    </form>
</div>
</body>
</html>