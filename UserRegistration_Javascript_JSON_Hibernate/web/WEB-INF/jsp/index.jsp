<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <style>
        table{
            border:3px solid black;
        }
        a{
            text-decoration: underline;
            cursor: pointer;
            color:blue;
        }
        span{
            color: red;
        }
    </style>
    <script src='./FormHelper.js'></script>
    <body>
        <center>
            <br/><br/><br/><br/>
            <button onclick="registrationFormDisplay()">Create User</button><br><br>
            <button onclick="searchFormDisplay()">Search User</button><br><br>
            <div id="registrationForm" class="container" style="display: none;background-color: yellow;width: 60%;">
                <h3>Registration Form</h3>
                <span id="success"></span>
                <form onsubmit="return saveUser();" id="myForm" method="POST" enctype="multipart/form-data">
                    <table class="table">
                        <tr>
                            <td>First :</td><td> <input id="first" type="text" required/></td>
                        </tr>
                        <tr>
                            <td>Last : <td><input id="last" type="text" required/></td></tr>
                        <tr>
                            <td>Gender:</td>
                            <td>
                                <input type="radio" id="gender" value="M" checked/>Male
                                <input type="radio" id="gender" value="F"/>Female</td>
                        </tr>
                        <tr>
                            <td>Email :</td> <td><input id="email" type="text" required/></td></tr>
                        <tr>
                            <td>About Me:</td> <td><textarea id="aboutMe" required></textarea></td></tr> 
                        <tr>
                            <td></td>
                            <td><input type="submit" name="Register User"></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id="searchForm" style="display: none;background-color: yellow;width: 60%;">
                <h3>Search Form</h3>
                <form id="search" onsubmit="return getResults();">

                    Search User <input type="text" id="name" name="user" required /> <br><br>

                    <label>Search By:</label>
                    <input type="radio" name="search" value="first" checked="checked"> First Name
                    <input type="radio" name="search"  value="last"> Last Name
                    <input type="radio" name="search"  value="gender"> Gender
                    <input type="radio" name="search"  value="email"> Email <br><br>
                    <input type="submit" name="search"/><br><br>
                </form>
                <div id="results">

                </div>
            </div>
        </center>
    </body>
</html>
