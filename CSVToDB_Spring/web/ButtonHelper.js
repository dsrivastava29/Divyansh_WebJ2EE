/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Best viewed in Mozilla firefox
             $(document).ready(function () {
                $("button[id='save']").click(function () {
                    var tbl = $("#tablename").val();
                    ///Get closest table row
                    var home = $(this).closest("tr");
                    //prepare json
                    var json1 = "{";
                    home.find("input[type='text']").each(function () {
                        json1 = json1 + $(this).attr("name") + "=" + $(this).val() + ",";
                    });
                    json1 = json1.slice(0, -1) + "}";

                    var json = "{";
                    json = json + "\"" + "items" + "\":\"" + json1 + "\"";
                    json = json + "}";
                    var obj = $.parseJSON(json);
                    //Save the row to database using AJAX call
                    $.post("loadFile.htm?action=saverow&tablename=" + tbl, obj, function (data, status) {
                        //on success, green row, disabled button
                        home.attr('style', 'background-color: #00CC00');
                        home.find('button[id=\'save\']').attr('disabled', true);
                        home.find('button[id=\'save\']').html('Saved');
                    });
                });
            });
        
    

