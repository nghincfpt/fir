
	$("#save").on("click",function(){
		alert("fd");
	});


function checkname(){
	var txt=$("#name");
	var error=$("#name_error");
	  
	  txt.removeClass("is-valid").removeClass("is-invalid");
	
	var val=txt.val();
	
	if(val==""){
		error.html("Name không đươc để trống");
		txt.addClass("is-invalid");
		return false;
	}else{
		txt.addClass("is-valid");
	}
	return true;
};