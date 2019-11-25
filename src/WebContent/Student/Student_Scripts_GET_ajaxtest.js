//GET REQUEST ONLY

function showTable_listStudent(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].id;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		
	}
}


function showTable_listStudentByModuleId(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell4.innerHTML = responseJSON[i].modulesname;
		
	}
}


function showTable_listStudentAttendance(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell2.innerHTML = responseJSON[i].sessionsid;
		cell3.innerHTML = responseJSON[i].attendancetimestamp;
		
	}
}


function showTable_listAllExamWithModule(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell.innerHTML = responseJSON[i].semesterid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesid;
		cell3.innerHTML = responseJSON[i].modulesname;
		cell4.innerHTML = responseJSON[i].examsid;
		cell5.innerHTML = responseJSON[i].examsdate;
		
	}
}


function showTable_listOverlapExams(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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

		cell.innerHTML = responseJSON[i].examsid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].examsdate;
		cell3.innerHTML = responseJSON[i].examsfrom;
		cell4.innerHTML = responseJSON[i].examsto;
		
		
	}
}
function showTable_listSessionByDate(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].sessionsid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesid;
		cell3.innerHTML = responseJSON[i].sessionsdate;
		
	}
}


function showTable_listExamBySemester(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell.innerHTML = responseJSON[i].semesterid;				//THESE ARE THE KEY OF THE JSON PACKAGE, CHANGE BASED ON EACH DIFFERENT METHODS
		cell2.innerHTML = responseJSON[i].modulesname;
		cell3.innerHTML = responseJSON[i].examsdate;
		cell4.innerHTML = responseJSON[i].examsfrom;
		cell5.innerHTML = responseJSON[i].examsto;
		cell6.innerHTML = responseJSON[i].deadline;
		
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


function showTable_listExamByStudent(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
		cell4.innerHTML = responseJSON[i].examsid;	
		
	}
}

$(document).ready(function(){
	$('#listStudentButton').on("click", function(){		//GET WITHOUT INPUT
		$.ajax({
			type: 'GET',
			url:  'rest/student/listStudent',
			success: function(listStudent){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
					var table = document.getElementById("listStudent");
					showTable_listStudent(table, listStudent);
			},
			error: function(){
				alert("Failed");
			}
		});
	});
	
	$('#listStudentByModuleIdButton').on("click", function(){				//GET WITH INPUT
		var $moduleId = $("#moduleId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				moduleId: $moduleId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listStudentByModuleId',
			data:	delivery,			
			success: function(listStudentByModuleId){
					var table = document.getElementById("listStudentByModuleId");
					showTable_listStudentByModuleId(table, listStudentByModuleId);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	
	//List the Attendance of a student
	$('#listStudentAttendanceButton').on("click", function(){				//GET WITH INPUT
		var $studentId = $("#studentId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				studentId: $studentId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listStudentAttendance',
			data:	delivery,			
			success: function(listStudentAttendance){
					var table = document.getElementById("listStudentAttendance");
					showTable_listStudentAttendance(table, listStudentAttendance);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//List all exams with modules
	$('#listAllExamWithModuleButton').on("click", function(){		//GET WITHOUT INPUT
		$.ajax({
			type: 'GET',
			url:  'rest/student/listAllExamWithModule',
			success: function(listAllExamWithModule){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
					var table = document.getElementById("listAllExamWithModule");
					showTable_listAllExamWithModule(table, listAllExamWithModule);
			},
			error: function(){
				alert("Failed");
			}
		});
	});
	
	//List all the overlap exams
	$('#listOverlapExamsButton').on("click", function(){		//GET WITHOUT INPUT
		$.ajax({
			type: 'GET',
			url:  'rest/student/listAllExamWithModule',
			success: function(listOverlapExams){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
					var table = document.getElementById("listOverlapExams");
					showTable_listOverlapExams(table, listOverlapExams);
			},
			error: function(){
				alert("Failed");
			}
		});
	});
	
	//List Sessions by date
	$('#listSessionByDateButton').on("click", function(){				//GET WITH INPUT
		var $date = $("#date").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				date: $date					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listSessionByDate',
			data:	delivery,			
			success: function(listSessionByDate){
					var table = document.getElementById("listSessionByDate");
					showTable_listSessionByDate(table, listSessionByDate);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//List all the Exams by a given semester
	$('#listExamBySemesterButton').on("click", function(){				//GET WITH INPUT
		var $semesterId = $("#semesterId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				semesterId: $semesterId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listExamBySemester',
			data:	delivery,			
			success: function(listExamBySemester){
					var table = document.getElementById("listExamBySemester");
					showTable_listExamBySemester(table, listExamBySemester);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//List all the Exams by a given module name
	$('#listExamByModuleNameButton').on("click", function(){				//GET WITH INPUT
		var $moduleName = $("#moduleName").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				moduleName: $moduleName					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listExamByModuleName',
			data:	delivery,			
			success: function(listExamByModuleName){
					var table = document.getElementById("listExamByModuleName");
					showTable_listExamByModuleName(table, listExamByModuleName);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//List all the exams of a given students which they have registered
	$('#listExamByStudentButton').on("click", function(){				//GET WITH INPUT
		var $studentId = $("#studentId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				studentId: $studentId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listExamByStudent',
			data:	delivery,			
			success: function(listExamByStudent){
					var table = document.getElementById("listExamByStudent");
					showTable_listExamByStudent(table, listExamByStudent);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
});
