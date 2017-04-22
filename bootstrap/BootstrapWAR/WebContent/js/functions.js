

function runHello() {
	alert("Run HELLO");
}

function replaceText(newValue) {
	$('#shellResponse').after(newValue).remove();
}

function callAjax() {
	alert("YO AJAX");
}

function ajaxCall(serviceID, hrefValue, result) {
  var params = {};
  params.serviceId = serviceID;
  params.param1 = hrefValue;
    
  $.ajax({
    type: "GET",
	url: "./AjaxServlet",
	data: params,
	dataType: "json",
	success: function(returndata,status,request) 
		{ result.html(returndata.serviceResponse); },
	error: function(request,status,error) 
		{ result.html(status);}
  });
}


