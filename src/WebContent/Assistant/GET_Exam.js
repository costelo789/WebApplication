function showTable_listAllExamWithModule(table, responseJSON){        //NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
    for(var i = table.rows.length - 1; i > 0; i--)    //Clear table
    {
        table.deleteRow(i);
    }
    for(var i = 0; i < responseJSON.length; i++){
        var row = table.insertRow(-1);
        var cell = row.insertCell(-1);
        var cell2 = row.insertCell(-1);
        var cell3 = row.insertCell(-1);
        var cell4 = row.insertCell(-1);
        var cell5 = row.insertCell(-1);
        var cell6 = row.insertCell(-1);
        cell.innerHTML = responseJSON[i].examsid;                //THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
        cell2.innerHTML = responseJSON[i].modulesid;
        cell3.innerHTML = responseJSON[i].examsdate;
        cell4.innerHTML = responseJSON[i].examsfrom;
        cell5.innerHTML = responseJSON[i].examsto;
        cell6.innerHTML = responseJSON[i].deadline;
    }
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	$.ajax({    //ONLOADING WEBSITE
        type: 'GET',
        url:  rootPath+'rest/assistant/listAllExamWithModule',
        success: function(listAllExamWithModule){        //THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
                var table = document.getElementById("listAllExamWithModule");
                showTable_listAllExamWithModule(table, listAllExamWithModule);
        },
        error: function(){
            alert("Failed");
        }
    });
});
