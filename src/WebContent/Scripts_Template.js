function showTable(table, responseJSON){
	for(var i = table.rows.length - 1; i > 0; i--)	//Clear table
	{
	    table.deleteRow(i);
	}
	for(var i = 0; i < responseJSON.length; i++){
		var row = table.insertRow(-1);
		var cell = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		cell.innerHTML = responseJSON[i].id;
		cell2.innerHTML = responseJSON[i].firstname;
		cell3.innerHTML = responseJSON[i].lastname;
		
	}
}

function showList(list, responseJSON){
	$(list).empty();
	var entry = document.createElement('li');
	entry.appendChild(document.createTextNode(responseJSON[0].response));
	list.appendChild(entry);
}

$(document).ready(function(){
	$('#showbutton').on("click", function(){	
		$.ajax({
			type: 'GET',
			url:  'rest/student/listStudent',
			success: function(students){
					var table = document.getElementById("students");
					showTable(table, students);
			},
			error: function(){
				alert("Failed");
			}
		});
	});
	
	$('#inputbutton').on("click", function(){
		var $moduleId = $("#moduleId").val();
	
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/student/listStudentByModuleId',
			data:	{moduleId: $moduleId},
			success: function(studentModule){
					var table = document.getElementById("studentModule");
					showTable(table, studentModule);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#postbutton').on("click", function(){
		var $studentId = $("#studentId").val();
		var $examId = $("#examId").val();
		var sendData ={
				studentId: $studentId,
				examId: $examId
		}
		
		$.ajax({
			type: 'POST',
			url:  'rest/student/examRegistration',
			data:	sendData,
			success: function(examRegister){
				var list = document.getElementById('examRegister');
				showList(list, examRegister);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
});

