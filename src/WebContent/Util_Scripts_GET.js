//GET REQUEST ONLY

function showTable_listModule(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].modulesid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesname;
	}
}

function showTable_listModule_Delete(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cellButton = row.insertCell(-1);
		var cellInput = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].modulesid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesname;
		cellButton.innerHTML = "<input id=\"deleteButton\" type=\"button\" value=\"Delete\">";
		cellInput.innerHTML = "<input id=\"moduleId\" type=\"text\" name=\"moduleId\">";
	}
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	//GET WITHOUT INPUT
	$.ajax({	//ONLOADING WEBSITE
		type: 'GET',
		url:  rootPath+'rest/util/listModule',
		success: function(listModule){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
				var table = document.getElementById("listModule");
				showTable_listModule(table, listModule);
		},
		error: function(){
			alert("Failed");
		}
	});
});