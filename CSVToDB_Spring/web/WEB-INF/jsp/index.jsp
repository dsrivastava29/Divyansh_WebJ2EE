<%@page import="java.io.File"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <title>Sales Order Management</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> 
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script> 
        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
        <style>
            a {
                color: #AADDAA;
                font-size: 25px;
            }
        </style>
        <script>
            $(document).ready(function () {
                $("button[id='save']").click(function () {
                    var tbl = $("#tablename").val();
                    var home = $(this).closest("tr");
                    var json1 = "{";
                    home.find("input[type='text']").each(function () {
                        json1 = json1 + $(this).attr("name") + "=" + $(this).val() + ",";
                    });
                    json1 = json1.slice(0, -1) + "}";

                    var json = "{";
                    json = json + "\"" + "items" + "\":\"" + json1 + "\"";
                    json = json + "}";
                    var obj = $.parseJSON(json);
                    $.post("loadFile.htm?action=saverow&tablename=" + tbl, obj, function (data, status) {
                        home.attr('style', 'background-color: #00CC00');
                        home.find('button[id=\'save\']').attr('disabled', true);
                        home.find('button[id=\'save\']').html('Saved');
                    });
                });
            });
        
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="background-color: #000000">
    <div class="container">
        <form action="loadFile.htm" method="get">
            <div class="form-group" style="height: 60%">
                <div class='panel panel-default' style="background-color: #5070DD;">
                    <c:choose>
                        <c:when test="${!empty requestScope.rowinserted}" >
                            <div class='panel-heading' style='background-color:white; height: 100px;background: #FFFFFF; color: #5070DD'> 
                                <h1>Welcome to Sales Order Management</h1>
                            </div>
                            <div class='panel-body' style="color: #FFFFFF;"> 
                                <h3>We have inserted <font style="color: #000000"><c:out value="${requestScope.rowinserted}"/></font>
                                    rows to new table <font style="color: #000000"><c:out value="${sessionScope.tableName}"/></font> </h3>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.action=='load'}">
                            <div class='panel-heading' style='background-color:white; height: 100px;background: #FFFFFF; color: #5070DD'> 
                                <h1>Welcome to Sales Order Management</h1>
                            </div>
                            <div class='panel-body' style="color: #FFFFFF;"> 

                                <div class="table-responsive" style="position: relative;">
                                    <c:choose>
                                        <c:when test="${!empty requestScope.nodata}">
                                            <div class='panel-body' style="color: #FFFFFF;"> 
                                                <h3>Error reading the file. Please retry again in some time. </h3>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="savedata" scope="session" value="${mydata}" />
                                            <table class="table" style="width: 100%"><tr align="center">
                                                    <td><h3>File data :  </h3></td>
                                                    <td> </td>
                                                </tr>
                                            </table>
                                            <input type="hidden" id="tablename" value=${requestScope.filename} />
                                            <table class="table table-bordered" border="1">
                                                <thead>
                                                    <tr style="background-color: #222222">
                                                        <th>Save</th>
                                                        <th>Delete</th>
                                                            <c:forEach items="${mydata[0]}" var="column">
                                                            <th><c:out value="${column.key}" /></th>
                                                            </c:forEach>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${mydata}" var="columns">
                                                        <tr style="background-color: #DDDDDD">
                                                            <td> <button class="btn-default" id='save' type="button">Save</button></td>
                                                            <td> <button class="btn-default" type="button" onclick="$(this).closest('tr').remove()">Delete</button></td>
                                                            <c:forEach items="${columns}" var="column">
                                                                <td><font style="color: #000000">
                                                                        <input type="text" name="${column.key}" value="${column.value}"/>
                                                                    </font>
                                                                </td>
                                                            </c:forEach>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <center>

                                                <c:choose>
                                                    <c:when test="${pgindex < 6}">
                                                        <c:forEach var="i" begin="1" end="10">
                                                            <a href="loadFile.htm?filename=${requestScope.filename}&action=load&pgindex=${i}"><c:out value="  ${i}  "/></a>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:set var="min" scope="page" value="${requestScope.pgindex-5}"/>
                                                        <c:set var="max" scope="page" value="${requestScope.pgindex+5}"/>
                                                        <a href="loadFile.htm?filename=${requestScope.filename}&action=load&pgindex=${requestScope.pgindex-1}"><c:out value="  <<  "/></a>
                                                        <c:forEach var="i" begin="${min}" end="${max}">
                                                            <a href="loadFile.htm?filename=${requestScope.filename}&action=load&pgindex=${i}"><c:out value="  ${i}  "/></a>
                                                        </c:forEach>
                                                        <a href="loadFile.htm?filename=${requestScope.filename}&action=load&pgindex=${requestScope.pgindex+1}"><c:out value="  >>  "/></a>
                                                    </c:otherwise>

                                                </c:choose> 
                                            </center>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <input type="hidden" name="action" value="save" />


                            </c:when>
                            <c:otherwise>
                                <div class='panel-heading' style='background-color:white; height: 100px;background: #FFFFFF; color: #5070DD'> 
                                    <h1>Welcome to Sales Order Management</h1>
                                </div>
                                <div class='panel-body' style="height: 500px;width: 50%;color: #FFFFFF;"> 
                                    <h3>Please enter your filename to load </h3>
                                    <input type='text' class='form-control' name='filename' id='filename' placeholder='Enter file name' required> 
                                    <br/>
                                    <input type="hidden" name="action" value="load" />
                                    <input type="hidden" name="pgindex" value="1" />
                                    <button class="btn-default" type="submit" style="float: right">Load File</button>
                                    <br/><br/><br/>
                                    <h4>
                                        List of available files: 
                                    </h4>
                                    <ul>
                                        <%
                                            File file;
                                            String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
                                            String path = null;
                                            if (check.equalsIgnoreCase("\\")) {
                                                path = getServletContext().getRealPath("").replace("build\\", ""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
                                            }
                                            if (check.equalsIgnoreCase("/")) {
                                                path = getServletContext().getRealPath("").replace("build/", "");
                                                path += "/"; //Adding trailing slash for Mac systems.
                                            }
                                            file = new File(path);
                                            File[] listFiles = file.listFiles();
                                            for (int i = 0; i < listFiles.length; i++) {
                                                if (listFiles[i].isFile()) {
                                                    if (!listFiles[i].getName().equalsIgnoreCase("redirect.jsp")) {
                                                        out.println("<br/><li>" + listFiles[i].getName());
                                                    }
                                                }
                                            }
                                        %>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
        </form>
    </div>
            <footer>
                Best viewed in Mozilla Firefox
            </footer>
</body>
</html>
