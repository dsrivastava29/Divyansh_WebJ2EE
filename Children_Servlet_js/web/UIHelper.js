/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//add new fields on page
function addFields() {
    //Get number of children
    var number = document.getElementById("childcount").value;
    var container = document.getElementById("container");
    //If container has child nodes, remove existing
    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }
    //Create new form with all attributes
    var formelement = document.createElement("form");
    formelement.method = "post";

    formelement.id = "chform";

    formelement.setAttribute("onsubmit", "return validateForm()");
    for (i = 0; i < number; i++) {
        formelement.appendChild(document.createTextNode("Please enter the name of child number " + (i + 1) + "\n"));
        formelement.appendChild(document.createElement("br"));
        var input = document.createElement("input");
        input.type = "text";
        input.required = true;
        input.name = "child" + (i + 1);

        formelement.appendChild(input);
        formelement.appendChild(document.createElement("br"));
        formelement.appendChild(document.createElement("br"));

    }
    //Hidden field to store number
    var hid = document.createElement("input");
    hid.type = "hidden";
    hid.value = number;
    formelement.appendChild(hid);

    //Submit
    var sub = document.createElement("input");
    sub.type = "submit";
    sub.value = "Submit Query";

    formelement.appendChild(document.createElement("br"));
    formelement.appendChild(sub);
    container.appendChild(formelement);
}
//form validation
function validateForm() {
    //Check form nodes
    var nodes = document.querySelectorAll("#chform input[type=text]");
    //Check all values
    for (var i = 0; i < nodes.length; i++)
    {
        if (nodes[i].value === "") {
            return false;
        }
    }
    return true;
}

