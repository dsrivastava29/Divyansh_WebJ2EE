<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>CrazyDiv's Book Store</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function userOption() {
                if (document.getElementById("user").value === "") {
                    var person = prompt("Please enter your name/ Press cancel to proceed without name", "");
                    if (person !== null) {
                        document.getElementById("user").value = person;
                    }
                }
            }
        </script>
    </head>
    <body style="background-color: #000000">

        <div class="container">
            <form action="bookform.htm" method="post" onsubmit="userOption()">
                <div class="form-group" style="height: 60%">
                    <div class='panel panel-default' style="background-color: #fff4ed;">
                        <div class='panel-heading' style='background-color:white; height: 100px;background: #990000; color: #fff4ed'> 
                            <h1>Welcome to Book Management Store</h1>
                            <h3 style="float: right; color: #000000"><c:out value="Welcome ${sessionScope.user}"></c:out></h3>
                            </div>
                            <div class='panel-body' style="height: 500px; width: 40%;"> 
                                <h4>
                                    How many books do you want to add?
                                </h4>
                                <input type='text' class='form-control' name='bkcount' id='bkcount'  placeholder='Enter number of books' required onkeypress='return event.charCode >= 48 && event.charCode <= 57'> 
                                <input type="hidden" name="user" id="user" value="<c:out value="${sessionScope.user}"/>" />
                            <input type="hidden" name="work" value="generate" />
                            <br/>
                            <button class="btn-default" type="submit">Submit</button>
                        </div>
                    </div>

            </form>
        </div>

    </body>
</html>
