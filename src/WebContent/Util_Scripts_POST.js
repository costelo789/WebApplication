function showList(list, responseJSON){
	$(list).empty();
	var entry = document.createElement('li');
	entry.appendChild(document.createTextNode(responseJSON[0].response));
	list.appendChild(entry);
}


$(document).ready(function(){
	var rootPath = '/webrest/';
$('#createModuleButton').on("click", function(){
		var $moduleName = $("#moduleName").val();
		var $semesterId = $("#semesterId").val();
		
		var sendData ={
				moduleName: $moduleName,
				semesterId: $semesterId,
		}
		
		$.ajax({
			type: 'POST',
			url:  rootPath+'rest/util/createModule',
			data:	sendData,
			success: function(createModule){
				var list = document.getElementById('createModule');
				showList(list, createModule);
			},
			error: function(jqXhr, textStatus, errorThrown){
				console.log(errorThrown);
				alert("Failed");
			}
		});
	});
});