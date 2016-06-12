<%-- 
    Document   : UserView
    Created on : Feb 6, 2016, Feb 6, 2016 2:51:12 PM
    Author     : Divyansh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Movie Search and View</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function checkYear() {
                var year = document.getElementById("year").value;
                if (year.length !== 4) {
                    alert("Year is not proper. Please check"+year.length+year);
                    return false;
                }
                var current_year = new Date().getFullYear();
                if ((year < 1920) || (year > current_year))
                {
                    alert("Year should be in range 1920 to current year");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body style="background-color: #000000">

        <div class="container">
            <form action="./MovieController"  onsubmit="return checkYear()" method="post">
                <div class="form-group" style="height: 60%">
                    <div class='panel panel-default' style="background-color: #cccccc;">
                        <div class='panel-heading' style='background-color:white; height: 100px;background: #FF0000; color: #FFFFFF'> 
                            <h1>Welcome to our movie store</h1>
                            <h3 style="float: right; color: #000000">Welcome <c:out value="${sessionScope.user}"></c:out></h3>
                        </div>
                        <div class='panel-body' style="height: 500px; width: 50%"> 
                            <h3>
                                Kindly enter the details below
                            </h3>
                            <label for='title'>Movie Title : </label> 
                            <input type='text' class='form-control' name='title' id='title' placeholder='Enter movie title' required> 
                            <label for='lactor'>Lead Actor : </label> 
                            <input type='text' class='form-control' name='lactor' id='lactor' placeholder='Enter lead actor' required> 
                            <label for='lactress'>Lead Actress :</label> 
                            <input type='text' class='form-control' name='lactress' id='lactress'  placeholder='Enter lead actress' required> 
                            <label for='genre'>Genre : </label> 
                            <input type='text' class='form-control' name='genre'  placeholder='Enter genre' required> 
                            <label for='year'>Year :</label> 
                            <input type='text' class='form-control' name='year' id='year'  placeholder='Enter movie year' required onkeypress='return event.charCode >= 48 && event.charCode <= 57'> 
                            <input type="hidden" name="user" id="user" value="" />
                            <input type="hidden" name="action" id="user" value="add" />
                            <br/>
                            <button class="btn-default" type="submit">Add Movie</button>
                            <br/>
                            <a href="index.jsp">Click here to go back to the main page</a>
                        </div>

                    </div>

            </form>
        </div>


    </body>
</html>
