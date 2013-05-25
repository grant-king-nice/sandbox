// avoid accidental global variable declarations
//"use strict";

// require configurations
require.config({
    paths : {
        base : '/delegate/requirejs/js/poc' ,
        text : '/delegate/requirejs/js/poc/req_js/text',
        path : '/delegate/requirejs/js/poc/req_js/path',
  
    }
});



define(function(require) {


	//Component1 = require('/delegate/requirejs/js/poc/components/com/ccih/example/component1/component');
	//var Comp2 = require('/delegate/requirejs/js/poc/components/com/ccih/example/component2/component');

   onLoad();

    function onLoad(){

    	
    branch	
    	
    	
//		
//		 var parentContainer2 = $("#component2"); 
//		var comp2 = new Comp2();
//        comp2.initialize() ;
//        comp2.activate(parentContainer2);
    }

    function onLoadFailed(){
        console.log("onLoadFailed");
    }

});
	  
		  
