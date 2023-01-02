
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<html>
<head>
    <title>Calculation</title>
</head>
<body>
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
<form action="input" method="post">
    <div class="container mt-5">
        <h2 class="Text-center">Tax Calculator</h2>

        <div align="right">

                <a  href="ideahistory"  >

                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>My Historys</span>
                </a>



            <a class="dropdown-item" href="<c:url value="/logout" />" methods="post"  >
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
            </a>


        </div>


        <div class="form-group">
            <div align="left">
                <label for="options"> <h3>Choose Tax Payer Category :</h3></label><br>

                <select name="category" id="options">
                    <option value="General"><h3>General</h3></option>
                    <option value="Female"><h3>Female</h3></option>
                    <option value="Disable"><h3>Disables</h3></option>

                </select>
            </div>
            <br>
            <div align="left">
                <label for="zones"><h3>Select a Particular Zone :</h3></label><br>

                <select name="zoon" id="zones">
                    <option value="Dhaka"><h3>Dhaka</h3></option>
                    <option value="Sylhet"><h3>Sylhet</h3></option>
                    <option value="Barisal"><h3>Barisal</h3></option>
                </select>

            </div>




            <div  align="left">
                <label for="zones"><h3>Select Year :</h3></label><br>

                <input type="date"  id="dob" placeholder="DateofBirth" name="fyear">
            </div>
            <br>
            <div align="center">

                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Area</th>

                        <th scope="col">Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Gross Salary</td>

                        <td><input type="number" id="num1" name="grosssalary" ></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Basic Salary</td>

                        <td><input type="number" id="num2" name="basicsalary" ></td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>House Rent</td>

                        <td><input type="number" id="num3" name="houserent" ></td>
                    </tr>

                    <tr>
                        <th scope="row">4</th>
                        <td>Conveyance</td>

                        <td><input type="number" id="num4" name="conveyance" ></td>
                    </tr>


                    <tr>
                        <th scope="row">5</th>
                        <td>Medical Allowance</td>

                        <td><input type="number" id="num5" name="medical" ></td>
                    </tr>
                    <tr>
                        <th scope="row">6</th>
                        <td>Others</td>

                        <td><input type="number" id="num6" name="others" ></td>
                    </tr>

                    <tr>
                        <th scope="row">7</th>
                        <td>Festival Bonus</td>

                        <td><input type="number" id="num7" name="festival" ></td>
                    </tr>

                    </tbody>
                </table>
            </div>

        </div>

        <div align="center">
            <button type="submit" class="btn btn-success">Submit</button>
        </div>

    </div>


</form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>
</body>
</html>
