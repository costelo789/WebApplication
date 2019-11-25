//POST only

function showList(list, responseJSON){
	$(list).empty();
	var entry = document.createElement('li');
	entry.appendChild(document.createTextNode(responseJSON[0].response));
	list.appendChild(entry);
}

$(document).ready(function(){
	var rootPath = '/webrest/';
	
	$('#createExamButton').on("click", function(){
		var $moduleId = $("#modId").val();
		
		var $day 	  = $("#day").val();
		var $month    = $("#month").val();
		var $year     = $("#year").val();
		
		var $hourFr   = $("#hourFr").val();
		var $minFr    = $("#minFr").val();
		var $secFr    = $("#secFr").val();
		
		var $hourTo   = $("#hourTo").val();
		var $minTo    = $("#minTo").val();
		var $secTo    = $("#secTo").val();
		
		var $Tday 	  = $("#Tdate").val();
		var $Tmonth   = $("#Tmonth").val();
		var $Tyear    = $("#Tyear").val();
		
		var $Thour	  = $("#Thour").val();
		var $Tmin     = $("#Tmin").val();
		var $Tsec     = $("#Tsec").val();
		
		var sendData ={
				modId	: $moduleId,
				day   	: $day,
				month 	: $month,
				year  	: $year,
				hourFr	: $hourFr,
				minFr 	: $minFr,
				secFr 	: $secFr,
				hourTo	: $hourTo,
				minTo 	: $minTo,
				secTo 	: $secTo,
				Tdate  	: $Tday,
				Tmonth 	: $Tmonth,
				Tyear  	: $Tyear,
				Thour	: $Thour,
				Tmin 	: $Tmin,
				Tsec 	: $Tsec,
		}
		$.ajax({
			type: 'POST',
			url:  rootPath +'rest/assistant/createExam',
			data:	sendData,
			success: function(createExam){
				var list = document.getElementById('createExam');
				showList(list, createExam);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#createSemesterButton').on("click", function(){
		var $dayFr = $("#dayFr").val();
		var $monthFr = $("#monthFr").val();
		var $yearFr = $("#yearFr").val();
		var $dayTo = $("#dayTo").val();
		var $monthTo = $("#monthTo").val();
		var $yearTo = $("#yearTo").val();
		var sendData ={
				dayFr: $dayFr,
				monthFr: $monthFr,
				yearFr: $yearFr,
				dayTo: $dayTo,
				monthTo: $monthTo,
				yearTo: $yearTo
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/createSemester',
			data:	sendData,
			success: function(createSemester){
				var list = document.getElementById('createSemester');
				showList(list, createSemester);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	
	
	$('#createSessionButton').on("click", function(){
		var $moduleId = $("#modId").val();
		
		var $day = 	 $("#day").val();
		var $month = $("#month").val();
		var $year =  $("#year").val();
		
		var $hourFr = $("#hourFr").val();
		var $minFr = $("#minFr").val();
		var $secFr = $("#secFr").val();
		
		var $hourTo = $("#hourTo").val();
		var $minTo = $("#minTo").val();
		var $secTo = $("#secTo").val();
		
		var sendData ={
				modId	: $moduleId,
				day   	: $day,
				month 	: $month,
				year  	: $year,
				hourFr	: $hourFr,
				minFr 	: $minFr,
				secFr 	: $secFr,
				hourTo	: $hourTo,
				minTo 	: $minTo,
				secTo 	: $secTo
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath +'rest/assistant/createSession',
			data:	sendData,
			success: function(createSession){
				var list = document.getElementById('createSession');
				showList(list, createSession);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//Create Student
    $('#createStudentButton').on("click", function(){
            
            var $login     = $("#login").val();
            var $pass     = $("#pass").val();
            var $firstname     = $("#firstname").val();
            var $lastname     = $("#lastname").val();
            
            var sendData ={
                login : $login,
                pass  : $pass,
                firstname : $firstname,
                lastname : $lastname,
            }
            
        $.ajax({
                type: 'POST',
                url:  rootPath+'rest/assistant/createStudent',
                data:    sendData,
                success: function(createStudent){
                    var list = document.getElementById('createStudent');
                    showList(list, createStudent);
                },
                error: function(jqXhr, textStatus, errorThrown){
                    console.log(errorThrown);
                    alert("Failed");
                }
        });
    });
    
    //Create Lecturer
    $('#createLecturerButton').on("click", function(){
            
            var $login     = $("#login").val();
            var $pass     = $("#pass").val();
            var $firstname     = $("#firstname").val();
            var $lastname     = $("#lastname").val();
            
            var sendData ={
                login : $login,
                pass  : $pass,
                firstname : $firstname,
                lastname : $lastname,
            }
            
        $.ajax({
                type: 'POST',
                url:  rootPath+'rest/assistant/createLecturer',
                data:    sendData,
                success: function(createLecturer){
                    var list = document.getElementById('createLecturer');
                    showList(list, createLecturer);
                },
                error: function(jqXhr, textStatus, errorThrown){
                    console.log(errorThrown);
                    alert("Failed");
                }
        });
    });
	
///////////////////////////////////Modify//////////////////////////
	
	$('#modifyAccountButton').on("click", function(){
		
		var $accountId	= $("#accountId").val();
		var $login 	= $("#login").val();
		var $pass 	= $("#password").val();
		var $fname 	= $("#fname").val();
		var $lname 	= $("#lname").val();
		
		var sendData ={
			accountId    : $accountId,
			login : $login,
			pass  : $pass,
			fname : $fname,
			lname : $lname,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/modifyAccount',
			data:	sendData,
			success: function(modifyAccount){
				var list = document.getElementById('modifyAccount');
				showList(list, modifyAccount);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#modifySemesterButton').on("click", function(){
		
		var $semesterId	= $("#semesterId").val();
		var $yearFr 	= $("#yearFr").val();
		var $monthFr 	= $("#monthFr").val();
		var $dateFr 	= $("#dateFr").val();
		
		var $yearTo 	= $("#yearTo").val();
		var $monthTo 	= $("#monthTo").val();
		var $dateTo 	= $("#dateTo").val();
		
		var sendData ={
			semesterId  : $semesterId,
			yearFr 		: $yearFr,
			monthFr  	: $monthFr,
			dateFr 		: $dateFr,
			yearTo 		: $yearTo,
			monthTo  	: $monthTo,
			dateTo 		: $dateTo,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/modifySemester',
			data:	sendData,
			success: function(modifySemester){
				var list = document.getElementById('modifySemester');
				showList(list, modifySemester);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});

	$('#modifyModuleButton').on("click", function(){
	
		var $modId			= $("#moduleId").val();
		var $moduleName		= $("#moduleName").val();
		var $semesterid		= $("#semesterid").val();
	
		var sendData ={
				moduleId	:$modId,
				moduleName	:$moduleName,		
				semesterid	:$semesterid,
		}
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/modifyModule',
			data:	sendData,
			success: function(modifyModule){
				var list = document.getElementById('modifyModule');
				showList(list, modifyModule);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});

	$('#modifySessionButton').on("click", function(){
		var $sessionId = $("#sessionId").val();
		var $moduleId = $("#modulesId").val();
		var $day = 	 $("#day").val();
		var $month = $("#month").val();
		var $year =  $("#year").val();
	
		var $hourFr = $("#hourFr").val();
		var $minFr 	= $("#minFr").val();
		var $secFr 	= $("#secFr").val();

		var $hourTo = $("#hourTo").val();
		var $minTo 	= $("#minTo").val();
		var $secTo 	= $("#secTo").val();
	
		var sendData ={
				sessionId	: $sessionId,
				moduleId	: $moduleId,
				day   	: $day,
				month 	: $month,
				year  	: $year,
				hourFr	: $hourFr,
				minFr 	: $minFr,
				secFr 	: $secFr,
				hourTo	: $hourTo,
				minTo 	: $minTo,
				secTo 	: $secTo
		}
	
		$.ajax({
			type: 'POST',
			url:  rootPath +'rest/assistant/modifySession',
			data:	sendData,
			success: function(modifySession){
				var list = document.getElementById('modifySession');
				showList(list, modifySession);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	$('#modifyExamButton').on("click", function(){
		var $examId = $("#examId").val();
		
		var $day 	  = $("#day").val();
		var $month    = $("#month").val();
		var $year     = $("#year").val();
		
		var $hourFr   = $("#hourFr").val();
		var $minFr    = $("#minFr").val();
		var $secFr    = $("#secFr").val();
		
		var $hourTo   = $("#hourTo").val();
		var $minTo    = $("#minTo").val();
		var $secTo    = $("#secTo").val();
		
		var $Tday 	  = $("#Tdate").val();
		var $Tmonth   = $("#Tmonth").val();
		var $Tyear    = $("#Tyear").val();
		
		var $Thour	  = $("#Thour").val();
		var $Tmin     = $("#Tmin").val();
		var $Tsec     = $("#Tsec").val();
		
		var sendData ={
				examId	: $examId,
				day   	: $day,
				month 	: $month,
				year  	: $year,
				hourFr	: $hourFr,
				minFr 	: $minFr,
				secFr 	: $secFr,
				hourTo	: $hourTo,
				minTo 	: $minTo,
				secTo 	: $secTo,
				Tday  	: $Tday,
				Tmonth 	: $Tmonth,
				Tyear  	: $Tyear,
				Thour	: $Thour,
				Tmin 	: $Tmin,
				Tsec 	: $Tsec,
		}
		$.ajax({
			type: 'POST',
			url:  rootPath +'rest/assistant/modifyExam',
			data:	sendData,
			success: function(modifyExam){
				var list = document.getElementById('modifyExam');
				showList(list, modifyExam);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
//////////////////////////////////////////////////////Delete///////////////////////////////////////////////////////	
	//Delete Account
	$('#deleteAccountButton').on("click", function(){
		var $id = $("#id").val();
		var sendData ={
				id: $id,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/deleteAccount',
			data:	sendData,
			success: function(deleteAccount){
				var list = document.getElementById('deleteAccount');
				showList(list, deleteAccount);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//Delete Semester
	$('#deleteSemesterButton').on("click", function(){
		var $semesterid = $("#semesterid").val();
		var sendData ={
				semesterid: $semesterid,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/deleteSemester',
			data:	sendData,
			success: function(deleteSemester){
				var list = document.getElementById('deleteSemester');
				showList(list, deleteSemester);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//Delete Module
	$('#deleteModuleButton').on("click", function(){
		var $modulesid = $("#modulesid").val();
		var sendData ={
				modulesid: $modulesid,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/deleteModule',
			data:	sendData,
			success: function(deleteModule){
				var list = document.getElementById('deleteModule');
				showList(list, deleteModule);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//Delete Session
	$('#deleteSessionButton').on("click", function(){
		var $sessionsid = $("#sessionsid").val();
		var sendData ={
				sessionsid: $sessionsid,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/deleteSession',
			data:	sendData,
			success: function(deleteSession){
				var list = document.getElementById('deleteSession');
				showList(list, deleteSession);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
	//Delete Exam
	$('#deleteExamButton').on("click", function(){
		var $examsid = $("#examsid").val();
		var sendData ={
				examsid: $examsid,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/assistant/deleteExam',
			data:	sendData,
			success: function(deleteExam){
				var list = document.getElementById('deleteExam');
				showList(list, deleteExam);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
	
});
