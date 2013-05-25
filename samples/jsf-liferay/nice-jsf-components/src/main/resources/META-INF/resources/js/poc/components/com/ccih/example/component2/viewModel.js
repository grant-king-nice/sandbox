
define(function(require) {

    // Load the dependencies
    var Model = require('./model');
    

    var ViewModel = function() {

        this.model;
  
        this.initialize = function() {
           
			this.model = new Model();
        };

        this.activate = function(parentContainer){

        }
		
		
		
		
		var that = this;

        this.dog = function(){
            this.model.animal( "Dog"   );
        }
		
		this.cat = function(){
            this.model.animal( "Cat"   );
        }
		
		//ko.computed ( 
		this.labelMsg = function() 
										{ 		
											return "Your animal is " + that.model.animal()  ;
										}  
									

        
    }

    return ViewModel;
});