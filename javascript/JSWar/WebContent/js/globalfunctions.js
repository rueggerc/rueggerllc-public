
var rueggerllc = (function() {
	
	var foo = function(arg) {
		console.log("foo function:" + arg);
	};
	
	var bar = function(arg) {
		console.log("bar function: " + arg);
	}
	
	
	var utils = {
			validatePercent: function() {
				console.log("validatePercent");
			},
			validateCurrency: function() {
				console.log("validateCurrency");
			},
			nicknameKeydown: function(e) {
				// Allowable characters
				// A-Za-z0-9.,;'"!@#$\^*()
				// console.log("nicknameKeydown BEGIN");
				// console.log("keyCode=" + e.keyCode);
				
				// KeyCodes:
				// delete=46
				// backspace=8
				// tab=9
				// escape=27
				// decimal=110
				// Let these through
				if ($.inArray(e.keyCode,[46,8,9,27,110]) !== -1 ||
					(e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) ||
					(e.keyCode >= 35 && e.keyCode <= 40)) {
					return;
				}
			
				// Get the charCode
				var charCode = e.which? e.which : e.keyCode;
			
				
				// Special Shift+characters in Regular Expression
				// "= shift + 222
				// != shift + 49
				// @= shift + 50
				// #= shift + 51
				// $= shift + 52
				// %= shift + 53
				// ^= shift + 54
				// *= shift + 56
				// (= shift + 57
				// )= shift + 48
				if (e.shiftKey === true) {
					if ($.inArray(e.keyCode,[222,48,49,50,51,52,53,54,56,57]) !== -1) {
						return true;
					} else if (e.keyCode >= 65 && e.keyCode <= 90) {
						return true;
					} else {
						e.preventDefault();
						return false;
					}
				}
				
				
				// Numbers OK
				if (e.keyCode >= 48 && e.keyCode <= 57) {
					return true;
				}

				// Letters OK
				if (charCode >= 65 && charCode <= 90) {
					return true;
				}
				
				// Characters in Regular Expression
				// space = 32
				// .=190
				// ,=188
				// ;=186 
				// '=222
				if ($.inArray(e.keyCode,[190,188,186,222]) !== -1) {
					return true;
				}
				
				// Block
				e.preventDefault();
				return false;
				
			}
	};
	
	// Expose functions
	return {
		foo: foo,
		bar: bar,
		nicknameKeydown: utils.nicknameKeydown,
		validatePercent: utils.validatePercent,
		validateCurrency: utils.validateCurrency
	}
	
}());
