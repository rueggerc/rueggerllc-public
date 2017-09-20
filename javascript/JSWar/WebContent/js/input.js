$(document).ready(function() {
	'use strict';
	console.log("inputPage BEGIN");
	setPageState();
});



function setPageState() {
	console.log("setPageState");
	registerCallbacks();
	rueggerllc.validatePercent();
	rueggerllc.validateCurrency();
	rueggerllc.foo("captain");
}


function registerCallbacks() {
	console.log("registerCallbacks");
	$('.nickname').keydown(function(e) {
		rueggerllc.nicknameKeydown(e);
	});
}