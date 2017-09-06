$(document).ready(function() {
	'use strict';
	console.log("Page Ready BEGIN");
	setPageState();
});

var myCar = {
	make: "inifinit",
	model: "g37x",
	drive: function(speed) {
		console.log("Drive my " + this.make + " at MPH=" + speed);
	},
	cruise: function(speed) {
		console.log("CRUISE BEGIN");
		var that = this;
		var helper = function() {
			console.log("I help the " + that.make + " cruise");
		}
		helper();
	}
	
};

var adder = function(x) {
	return function(y) {
		return x + y;
	};
};

var foobar = function(x,y) {
	var z = x + y;
	console.log("foobar result=" + z);
	console.log("foobar this=" + this);
	console.log("arguments=" + arguments);
	console.log("arguments size=" + arguments.length);
	for (name in this) {
		// console.log("next this=" + name);
	}
}


function myAdd(a,b,c,d) {
	console.log("myAdd a=" + a);
	console.log("myAdd b=" + b);
	console.log("myAdd c=" + c);
	console.log("myAdd d=" + d);
}


function setPageState() {
	console.log("Set Page State BEGIN");
	foobar(3,9);
	
	
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
	
	// Method Invocation Pattern
	myCar.drive(60);
	
	// Function Invocation Pattern
	myCar.cruise(55);
	
	// Constructor Invocation Pattern
	
	
	// Apply Invocation Pattern
	var myList = [3,4];
	var myListSum = myAdd.apply(null,myList);
	console.log("myListSum=" + myListSum);
	
	console.log("Dump Car Properties BEGIN");
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


