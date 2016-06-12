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
       <title>CrazyDiv's Book Store</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color: #000000">

        <div class="container">
            <form action="bookform.htm" method="post">
                <div class="form-group" style="height: 60%">
                    <div class='panel panel-default' style="background-color: #fff4ed;">
                        <div class='panel-heading' style='background-color:white; height: 100px;background: #990000; color: #fff4ed'> 
                            <h1>Welcome to Book Management Store</h1>
                            <h3 style="float: right; color: #000000"><c:out value="Welcome ${sessionScope.user}"></c:out></h3>
                        </div>
                        <div class='panel-body' style="width: 90%;"> 
                            <h4>
                                Enter Book Details here
                            </h4>
                            <div class='panel-body' style="width: 90%; float: center;"> 
                                <table border="1" class="table">
                                    <thead>
                                        <tr style="background-color: #000000; color: #FFFFFF">
                                            <th>ISBN</th>
                                            <th>Book Title</th>
                                            <th>Authors</th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                <c:forEach  begin="1" end="${requestScope.bkcount}" varStatus="loop">
                                    <tr>
                                        <td> <input type='text' class='form-control' name='${loop.index}-isbn' id="${loop.index}-isbn" placeholder='Enter ISBN' required onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode==45'>  </td>
                                        <td> <input type='text' class='form-control' name='${loop.index}-title' id='${loop.index}-title' placeholder='Enter Book name' required>  </td>
                                        <td> <input type='text' class='form-control' name='${loop.index}-authors' id='${loop.index}-authors' placeholder='Enter Author name' required>  </td>
                                        <td> <input type='text' class='form-control' name='${loop.index}-price' id='${loop.index}-price' placeholder='0.00' value='0.00' required onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode==46'>  </td>
                                        </tr>
                                </c:forEach>
                            </table>
                                <input type="hidden" name="user" id="user" value="${sessionScope.user}" />
                            <input type="hidden" name="work" value="insert" />
                            <input type="hidden" name="bkcount" value="${requestScope.bkcount}" />
                            <br/>
                            <button class="btn-default" type="submit" style="float: right;">Add Books >> </button>
                            <br/><br/>
                            <a href="index.jsp">Click here to go back to the main page</a>
                        </div>

                    </div>

            </form>
        </div>


    </body>
</html>
