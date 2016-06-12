<%-- 
    Document   : ViewNewMovie
    Created on : Feb 7, 2016, Feb 7, 2016 9:56:24 PM
    Author     : Divyansh
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CrazyDiv's Book Store</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color: #000000">
        <jsp:useBean id="newBook" class="com.neu.edu.beans.BookBean" scope="session" />
        <div class="container">
            <div class="form-group" style="height: 60%">
                <div class='panel panel-default' style="background-color: #fff4ed;">
                    <div class='panel-heading' style='background-color:white; height: 100px;background: #990000; color: #fff4ed'> 
                        <h1>Welcome to Book Management Store</h1>
                        <h3 style="float: right; color: #000000"><c:out value="Welcome ${sessionScope.user}"></c:out></h3>
                        </div>
                        <div class='panel-body' style="width: 90%;"> 
                            <h3>
                            ${sessionScope.rows} details added successfully
                        </h3>
                        <table border="1" class="table">
                            <thead>
                            <tr style="background-color: #000000; color: #FFFFFF">
                                <th>ISBN</th>
                                <th>Title</th>
                                <th>Authors</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <c:forEach var="book" items="${sessionScope.booksList}">
                                <tr>
                                    <td> <c:out value="${book.isbn}"></c:out> </td>
                                    <td> <c:out value="${book.title}"></c:out> </td>
                                    <td>  <c:out value="${book.authors}"></c:out> </td>
                                    <td> <c:out value="${book.price}"></c:out> </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <a href="index.jsp">Click here to go back to the main page</a>
                </div>
            </div>
        </div>
    </body>
</html>

