/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Divyansh
 */
// User regustration form display
//Best viewed in Mozilla firefox
function registrationFormDisplay() {
    //Registeration for create User
    if (document.getElementById("registrationForm").style.display === "none") {
        document.getElementById("registrationForm").style.display = "block";
        document.getElementById("myForm").reset();
        document.getElementById("success").innerHTML = "";
        document.getElementById("searchForm").style.display = "none"
    } else {
        document.getElementById("registrationForm").style.display = "none"
    }
}

function searchFormDisplay() {
    //Search User form display
    if (document.getElementById("searchForm").style.display === "none") {
        document.getElementById("searchForm").style.display = "block";
        document.getElementById("search").reset();
        document.getElementById("results").innerHTML = "";
        document.getElementById("registrationForm").style.display = "none";
    } else {
        document.getElementById("searchForm").style.display = "none";
    }
}

//AJAX

var xmlHttp;
xmlHttp = GetXmlHttpObject();
function saveUser() {
    //AJAX check
    if (xmlHttp == null) {
        alert("Your browser does not support AJAX");
        return;
    }
    //Get all values
    var first = document.getElementById("first").value;
    var last = document.getElementById("last").value;
    var gender = document.getElementById("gender").value;
    var email = document.getElementById("email").value;
    var aboutMe = document.getElementById("aboutMe").value;

    //prepare query
    var query = "first=" + first + "&last=" + last + "&gender=" + gender + "&email=" + email + "&aboutMe=" + aboutMe;

    xmlHttp.onreadystatechange = function stateChanged() {
        //response check when ready
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var json = JSON.parse(xmlHttp.responseText);
            document.getElementById("success").innerHTML = json.successmsg;
        }
    };
    //call
    xmlHttp.open("POST", "register.htm", true);
    xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    return false;
}

//To get search results
function getResults() {
    //AJAX check
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
    var key = document.getElementById("name").value;
    var flag = document.querySelector('input[name = "search"]:checked').value;
    var query = "action=searchuser&key=" + key.trim() + "&flag=" + flag.trim();
    xmlHttp.onreadystatechange = function stateChanged()
    {
        //response check when ready
        if (xmlHttp.readyState == 4)
        {
            document.getElementById("results").innerHTML = "";
            var json = JSON.parse(xmlHttp.responseText);
            //build table by json response
            if (json.users.length > 0) {
                var x = document.createElement("TABLE");
                x.setAttribute("id", "myTable");
                x.setAttribute("class", "table");
                document.getElementById("results").appendChild(x);
                var y = document.createElement("TR");
                y.setAttribute("id", "myTr");
                document.getElementById("myTable").appendChild(y);

                var z = document.createElement("TH");
                var t = document.createTextNode("First");

                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("Last");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("Email");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("About Me");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("Delete");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                for (var count = 0; count < json.users.length; count++) {
                    var y = document.createElement("TR");
                    y.setAttribute("id", "myTr" + count);
                    document.getElementById("myTable").appendChild(y);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].first);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].last);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].email);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].aboutMe);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var a = document.createElement('a');
                    var id = json.users[count].id;
                    var rowID = "myTr" + count;
                    var linkText = document.createTextNode("Delete");
                    a.appendChild(linkText);
                    a.title = "Delete";
                    a.onclick = (function (id, rowID) {
                        return function () {
                            deleteRow(id, rowID);
                        }
                    })(id, rowID);
                    z.appendChild(a);
                    document.getElementById("myTr" + count).appendChild(z);
                }
            } else {
                document.getElementById("results").innerHTML = "Nothing Found";
            }
        }
    };
    //call
    xmlHttp.open("POST", "searchuser.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    return false;
}

function deleteRow(userID, rowID) {
    //AJAX check
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }

    //prepare query
    var query = "action=delete&user=" + userID;

    xmlHttp.onreadystatechange = function stateChanged()
    {
        //check ready state
        if (xmlHttp.readyState == 4)
        {
            var row = document.getElementById(rowID);
            row.parentNode.removeChild(row);
        }
    };
    //AJAX call
    xmlHttp.open("POST", "searchuser.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    return false;
}

//get ajax object
function GetXmlHttpObject()
{
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}



