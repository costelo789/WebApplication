function showList(list, responseJSON){
	$(list).empty();
	var entry = document.createElement('li');
	entry.appendChild(document.createTextNode(responseJSON[0].response));
	list.appendChild(entry);
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	
	$('#signAttendanceButton').on("click", function(){				//GET WITH INPUT
		var $studentId = $("#studentId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var $sessionId = $("#sessionId").val();
		var delivery = {
				studentId: $studentId,				//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
				sessionId: $sessionId,
		}
		$.ajax({
			type: 'POST',
			url:  rootPath + 'rest/student/signAttendance',
			data:	delivery,			
			success: function(signAttendance){
				var list = document.getElementById('signAttendance');
				showList(list, signAttendance);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	
	$('#examRegisButton').on("click", function(){				//GET WITH INPUT
		var $studentId = $("#studentId").val();		//TAKE THE ID OF THE INPUT IN HTML TO THIS VARIABLE
		var $examId    = $("#examId").val();
		var delivery   = {
			studentId  : $studentId,				//SEND THE VARIABLE TO THE SERVER IN THIS PACKAGE
			examId     : $examId,
		}
		$.ajax({
			type: 	'POST',
			url:  	rootPath + 'rest/student/examRegistration',
			data:	delivery,			
			success: function(examRegistration){
				var list = document.getElementById('examRegistration');
				showList(list, examRegistration);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	var $studentId = 10;
	
	$('#deleteRegistrationButton').on("click", function(){				//GET WITH INPUT
		var $examsId    = $("#examsId").val();
		var delivery   = {
			examsId     : $examsId,
			studentId	: $studentId
		}
		$.ajax({
			type: 	'POST',
			url:  	rootPath + 'rest/student/deleteRegistration',
			data:	delivery,			
			success: function(deleteRegistration){
				var list = document.getElementById('deleteRegistration');
				showList(list, deleteRegistration);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#deleteAttendanceButton').on("click", function(){				//GET WITH INPUT
		var $sessionId    = $("#sessionsId").val();
		var delivery   = {
			sessionId     : $sessionId,
			studentId	: $studentId
		}
		$.ajax({
			type: 	'POST',
			url:  	rootPath + 'rest/student/deleteAttendance',
			data:	delivery,			
			success: function(deleteAttendance){
				var list = document.getElementById('deleteAttendance');
				showList(list, deleteAttendance);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});

});