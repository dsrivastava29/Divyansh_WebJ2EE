<%-- 
    Document   : ViewSearchMovies
    Created on : Feb 8, 2016, Feb 8, 2016 12:42:42 AM
    Author     : Divyansh
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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
        <jsp:useBean id="newmovie" class="com.neu.edu.beans.MovieBean" scope="session" />
        <div class="container">
            <form action="./MovieAction.do" name="InputCacheCheck" method="post" onsubmit="userOption()">
                <div class="form-group" style="height: 60%">
                    <div class='panel panel-default' style="background-color: #cccccc;">
                        <div class='panel-heading' style='background-color:white; height: 100px;background: #FF0000; color: #FFFFFF'> 
                            <h1>Welcome to our movie store</h1>
                            <h3 style="float: right; color: #000000">Welcome <c:out value="${sessionScope.user}"></c:out></h3>
                            </div>
                            <div class='panel-body' style="width: 80%; float: center;"> 
                                <table border="1" class="table">
                                    <thead>
                                        <tr style="background-color: #000000; color: #FFFFFF">
                                            <th>Title</th>
                                            <th>Actor</th>
                                            <th>Actress</th>
                                            <th>Genre</th>
                                            <th>Year</th>
                                        </tr>
                                    </thead>
                                <c:forEach var="movie" items="${sessionScope.movieList}">
                                    <tr>
                                        <td> <c:out value="${movie.title}"></c:out> </td>
                                        <td> <c:out value="${movie.actor}"></c:out> </td>
                                        <td> <c:out value="${movie.actress}"></c:out> </td>
                                        <td> <c:out value="${movie.genre}"></c:out> </td>
                                        <td> <c:out value="${movie.year}"></c:out> </td>
                                        </tr>
                                </c:forEach>
                            </table>
                            <br/>
                            <a href="index.jsp">Click here to go back to the main page</a>
                        </div>

                    </div>

            </form>
        </div>

    </body>
</html>

