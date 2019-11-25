//GET REQUEST ONLY

function showTable_listEnrollmentByModuleId(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].studentid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		
	}
}

function showTable_listExamByModuleId(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell.innerHTML = responseJSON[i].examsid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].examsdate;
		cell3.innerHTML = responseJSON[i].examsfrom;
		cell4.innerHTML = responseJSON[i].examsto;
		cell5.innerHTML = responseJSON[i].modulesname;
		
	}
}

function showTable_listRegistrationByExam(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell.innerHTML = responseJSON[i].studentid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		
		
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
		cell2.innerHTML = responseJSON[i].modulesname;
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
		var cell5 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].studentid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		
		
	}
}

function redirect(url, callback){
	window.location = url;
	callback();
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	/////////////////////////////////////////////ENROLLMENT////////////////////////////////////////////////
	var url = "http://localhost:8080/webrest/Lecturer/Lecturer_EnrollmentList2.html";
	$("#Button1").click(function(){
		document.getElementsByName('test')[0].src = url;
	});
	$('#listEnrollmentByModuleIdButton').on("click", function(){				//GET WITH INPUT
		var $enrollModuleId = $("#moduleId").val();
		var delivery = {
				moduleId: $enrollModuleId
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath+'rest/lecturer/listEnrollmentByModuleId',
			data:	delivery,			
			success: function(listEnrollmentByModuleId){
					var table = document.getElementById("listEnrollmentByModuleId");
					showTable_listEnrollmentByModuleId(table, listEnrollmentByModuleId);
					openR1();
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
		
		
		
	});
	
/////////////////////////////////////////////EXAM REGISTRATION////////////////////////////////////////////////
	$('#listExamByModuleIdButton').on("click", function(){				//GET WITH INPUT
		var $moduleId = $("#moduleId").val();
		var delivery = {
				moduleId: $moduleId
		}
		//document.location.href = "http://localhost:8080/webrest/Lecturer/Lecturer_EnrollmentList.html";
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath+'rest/util/listExamByModuleId',
			data:	delivery,			
			success: function(listExamByModuleId){
					var table = document.getElementById("listExamByModuleId");
					showTable_listExamByModuleId(table, listExamByModuleId);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#listRegistrationByExamButton').on("click", function(){				//GET WITH INPUT
		var $examId = $("#examId").val();
		var delivery = {
				examId: $examId
		}
		//document.location.href = "http://localhost:8080/webrest/Lecturer/Lecturer_EnrollmentList.html";
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath+'rest/lecturer/listRegistrationByExam',
			data:	delivery,			
			success: function(listRegistrationByExam){
					var table = document.getElementById("listRegistrationByExam");
					showTable_listRegistrationByExam(table, listRegistrationByExam);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
/////////////////////////////////////////////ATTENDANCE////////////////////////////////////////////////
	
	$('#listSessionByModuleIdButton').on("click", function(){				//GET WITH INPUT
		var $moduleId = $("#moduleId").val();
		var delivery = {
				moduleId: $moduleId
		}
		
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath+'rest/util/listSessionByModuleId',
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
		var $sessionId = $("#sessionId").val();
		var delivery = {
				sessionId: $sessionId
		}
		
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  rootPath+'rest/util/listAttendanceBySession',
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
