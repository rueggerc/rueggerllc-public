$(document).ready(function() {
	'use strict';
	console.log("Page Ready BEGIN");
	setPageState();
});

var myCar = {
	make: "inifinit",
	model: "g37x"
};

var adder = function(x) {
	return function(y) {
		return x + y;
	};
};


function setPageState() {
	console.log("Set Page State BEGIN");
	const x = 42;
	let y = 33;
	for (let i=0; i < 10; i++) {
	}
	// console.log(i);
	console.log("x=" + x);
	console.log("y=" + y);
	// x = 99;
	
	const foo = {};
	foo.name = 'John';
	
	var bar = even;
	console.log("Got Evens");
	console.log(bar);
	
	var barArrow = evenArrow;
	console.log(barArrow);
	
	console.log("Before evenArrow2");
	var barArrow2 = evenArrow2;
	console.log(barArrow2);
	
	add5 = adder(5);
	console.log("adder5=" + add5(3));
	
	for (name in myCar) {
		console.log("next car property:" + name);
	}
	
	var pets = ["captain", "oscar", "sunny", "darwin"];
	for (i = 0; i < pets.length; i++) {
		console.log("Next Pet=" + pets[i]);
	}
	
}


// Arrow Function
const numbers = [2,6,7,8,1];
const even = numbers.filter(function(x) {
	return x%2 === 0;
});
const evenArrow = numbers.filter(x => x%2 === 0);

const evenArrow2 = numbers.filter(x => {
	if (x%2 === 0) {
		console.log(x + ' is even!');
		return true;
	}
});


