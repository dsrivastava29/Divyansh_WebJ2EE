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
        <title>Search and view movies</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color: #000000">

        <div class="container">

            <div class="form-group" style="height: 60%">
                <div class='panel panel-default' style="background-color: #cccccc;">
                    <div class='panel-heading' style='background-color:white; height: 100px;background: #FF0000; color: #FFFFFF'> 
                        <h1>Welcome to our movie store</h1>
                        <h3 style="float: right; color: #000000">Welcome <c:out value="${sessionScope.user}"></c:out></h3>
                    </div>
                    <div class='panel-body' style="height: 500px; width: 50%"> 
                        <form action="./MovieController" name="InputCacheCheck" method="post">
                            <h3>
                                Searching Movies
                            </h3>

                            <label for='title'>Keyword  : </label> 
                            <input type='text' class='form-control' name='keyword' id='keyword' placeholder='Enter title, actor or actress' required> 
                            <br/>
                            <div class="radio">
                                <label><input type="radio" name="searchby" value="title" checked="checked">Search by title</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="searchby" value="actor">Search by Actor</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="searchby" value="actress">Search by Actress</label>
                            </div>
                            <button class="btn-default" type="submit">Search Movies</button>

                            
                        </form>
                         <br/><br/><br/><br/>
                            <a href="index.jsp">Click here to go back to the main page</a>
                        <form action="./MovieController" name="InputCacheCheck" method="post">
                            <input type="hidden" name="searchby" value="all" />
                        <button class="btn-default" type="submit">Show All Movies</button>
                    </form>
                       

                    </div>

                    
                </div>

            </div>


    </body>
</html>
