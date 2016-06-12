<%-- 
    Document   : index
    Created on : Feb 7, 2016, Feb 7, 2016 10:36:49 PM
    Author     : Divyansh
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Movie Search and View</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function userOption() {
                if (document.getElementById("user").value === "") {
                    var person = prompt("Please enter your name", "");
                    if (person !== null) {
                        document.getElementById("user").value = person;
                    }
                }
            }
        </script>
    </head>
    <body style="background-color: #000000">

        <div class="container">
            <form action="./MovieAction.do" method="post" onsubmit="userOption()">
                <div class="form-group" style="height: 60%">
                    <div class='panel panel-default' style="background-color: #cccccc;">
                        <div class='panel-heading' style='background-color:white; height: 100px;background: #FF0000; color: #FFFFFF'> 
                            <h1>Welcome to our movie store</h1>
                            <h3 style="float: right; color: #000000"><c:out value="Welcome ${sessionScope.user}"></c:out></h3>
                            </div>
                            <div class='panel-body' style="height: 500px;"> 
                                <h3>
                                    Please make your selection below
                                </h3>
                                <select name="selection" class="form-group">
                                    <option value="search" tabindex="-1">Browse Movies</option>
                                    <option value="add" tabindex="-1">Add new movie in database</option>
                                </select>
                                <input type="hidden" name="user" id="user" value="<c:out value="${sessionScope.user}"/>" />
                            <br/>
                            <button class="btn-default" type="submit">Send</button>
                        </div>

                    </div>

            </form>
        </div>

    </body>
</html>
