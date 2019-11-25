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

function showTable_listExamByModuleName(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
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
		cell.innerHTML = responseJSON[i].examsid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesname;
		cell3.innerHTML = responseJSON[i].examsdate;
		cell4.innerHTML = responseJSON[i].examsfrom;
		cell5.innerHTML = responseJSON[i].examsto;
		cell6.innerHTML = responseJSON[i].deadline;
		
	}
}

function showTable_listSessionByModuleId(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
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
		cell.innerHTML = responseJSON[i].sessionsid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesid;
		cell3.innerHTML = responseJSON[i].sessionsdate;
		cell4.innerHTML = responseJSON[i].sessionsfrom;
		cell5.innerHTML = responseJSON[i].sessionsto;
		
		
	}
}

function showTable_listAttendanceBySession(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		var cell4 = row.insertCell(-1);
		
		cell.innerHTML = responseJSON[i].studentid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		cell4.innerHTML = responseJSON[i].sessionsid;
		
		
		
	}
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	$.ajax({	//ONLOADING WEBSITE
		type: 'GET',
		url:  rootPath+'rest/assistant/listModule',
		success: function(listModule){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
				var table = document.getElementById("listModule");
				showTable_listModule(table, listModule);
		},
		error: function(){
			alert("Failed");
		}
	});
	
		
	$('#listSessionByModuleIdButton').on("click", function(){				//GET WITH INPUT
		var $moduleId = $("#moduleId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				moduleId: $moduleId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath + 'rest/util/listSessionByModuleId',
			data:	delivery,			
			success: function(listSessionByModuleId){
					var table = document.getElementById("listSessionByModuleId");
					showTable_listSessionByModuleId(table, listSessionByModuleId);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	
	$('#listAttendanceBySessionButton').on("click", function(){				//GET WITH INPUT
		var $sessionId = $("#sessionId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				sessionId: $sessionId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath + 'rest/util/listAttendanceBySession',
			data:	delivery,			
			success: function(listAttendanceBySession){
					var table = document.getElementById("listAttendanceBySession");
					showTable_listAttendanceBySession(table, listAttendanceBySession);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
});
