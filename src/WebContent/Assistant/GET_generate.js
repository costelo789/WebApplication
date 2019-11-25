function showTable_listModule(table, responseJSON){        //NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
    for(var i = table.rows.length - 1; i > 0; i--)    //Clear table
    {
        table.deleteRow(i);
    }
    for(var i = 0; i < responseJSON.length; i++){
        var row = table.insertRow(-1);
        var cell = row.insertCell(-1);
        var cell2 = row.insertCell(-1);
        var cell3 = row.insertCell(-1);
        cell.innerHTML = responseJSON[i].modulesid;                //THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
        cell2.innerHTML = responseJSON[i].modulesname;
        cell3.innerHTML = responseJSON[i].semesterid;
    }
}

function showTable_generate_Exam_List(table, responseJSON){        //NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
   for(var i = table.rows.length - 1; i > 0; i--)    //Clear table
   {
       table.deleteRow(i);
   }
   for(var i = 0; i < responseJSON.length; i++){
       var row = table.insertRow(-1);
       var cell = row.insertCell(-1);
       var cell2 = row.insertCell(-1);
       var cell3 = row.insertCell(-1);

       cell.innerHTML = responseJSON[i].id;                //THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
       cell2.innerHTML = responseJSON[i].firstname;
       cell3.innerHTML = responseJSON[i].lastname;

   }
}

$(document).ready(function(){
    var rootPath = '/webrest/';
    
    $.ajax({    //ONLOADING WEBSITE
        type: 'GET',
        url:  rootPath+'rest/util/listModule',
        success: function(listModule){        //THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
                var table = document.getElementById("listModule");
                showTable_listModule(table, listModule);
        },
        error: function(){
            alert("Failed");
        }
    });
    
    $("#generate_Exam_ListButton").on("click", function(){
        var $modulesid = $("#modulesid").val();
        var sendData ={
                moduleId: $modulesid,
        }
        
        $.ajax({    //ONLOADING WEBSITE
            type: 'GET',
            url:  rootPath+'rest/assistant/generate_Exam_List',
            data:    sendData,
            success: function(generate_Exam_List){        //THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
                    var table = document.getElementById("generate_Exam_List");
                    showTable_generate_Exam_List(table, generate_Exam_List);
            },
            error: function(){
                alert("Failed");
            }
        });
    });
});