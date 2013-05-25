


function niceCallBacks() {
	callbacks = $.Callbacks();
};



niceCallBacks.prototype.initialize = function Initialize(callback, fallback){
	callbacks = $.Callbacks();
	
};


niceCallBacks.prototype.add = function add (fn){
	callbacks.add(fn);
};

niceCallBacks.prototype.fire = function fire (){
	callbacks.fire();
};


var callbacks;