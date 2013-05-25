
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

        this.plus = function(){
            this.model.count( this.model.count()+1    );
        }
		
		this.minus = function(){
            this.model.count( this.model.count()-1    );
        }
		
		//ko.computed ( 
		this.labelMsg = function() 
										{ 		
											return "Your counter is " + that.model.count()  ;
										}  
									

        
    }

    return ViewModel;
});