//GET REQUEST ONLY

function showTable_listLecturer(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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
function showTable_listParticipantByExam(table, responseJSON){		//NAME THE FUNCTION WITH "showTable_" + THE JAVA METHOD NAME
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

$(document).ready(function(){
	$('#listLecturerButton').on("click", function(){		//GET WITHOUT INPUT
		$.ajax({
			type: 'GET',
			url:  'rest/lecturer/listLecturer',
			success: function(listLecturer){		//THE VARIABLE WILL BE THE SAME AS THE ID OF THE RESULT IN HTML
					var table = document.getElementById("listLecturer");
					showTable_listLecturer(table, listLecturer);
			},
			error: function(){
				alert("Failed");
			}
		});
	});
	
	$('#listParticipantByExamButton').on("click", function(){				//GET WITH INPUT
		var $examId = $("#examId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var delivery = {
				examId: $examId					//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
		}
		$.ajax({
			type: 'GET',
			contentType: 'application/json',
			url:  'rest/lecturer/listParticipantByExam',
			data:	delivery,			
			success: function(listParticipantByExam){
					var table = document.getElementById("listParticipantByExam");
					showTable_listParticipantByExam(table, listParticipantByExam);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
});
