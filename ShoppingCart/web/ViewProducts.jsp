<%-- 
    Document   : ViewProducts
    Created on : Feb 2, 2016, Feb 2, 2016 2:14:27 AM
    Author     : Divyansh
--%>

<%@page import="com.neu.edu.bean.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Products</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div  class='container' align='center'>
                    <div class='panel panel-default' style='position: relative;'>
<div class='panel-body' style='background-color: lightblue;' ><h3>Welcome to CrazyDiv Web Shopping Mall</h3>
</div>
</div>
        
            <h3>
                Following products added to cart
            </h3>
        </div>

        <div  class='container' align='center'>

            <table  class='table table-bordered'>
                <thead>
                <th> Product Name</th>
                <th> Price</th>
                <th></th>
                </thead>
                <c:forEach items="${sessionScope.myProducts}" var="item">
                    <tr>
                        <td> ${item.name} </td>
                        <td> ${item.price}</td>

                    </tr>
                </c:forEach> 

            </table>
        </div>
        <div align='center'>
            <a href="ModifyCart?action=cart">View Cart</a> ||
            <a href='LoadProducts?prodType=Books'>Go to Books page</a> ||
            <a href='LoadProducts?prodType=Music'>Go to Music page</a> ||
            <a href='LoadProducts?prodType=Computers'>Go to Computer page</a>
        </div>

    </body>
</html>