// TODO: refresh event

define(function(require) {

    var ViewModel = require("./viewModel");
    var view = require('text!./view.html');
    
   
    
    var viewModel = null;
	
	
	
	var createView = function($parentContainer, template){
            //var $parent = $(parentContainerId);
            var $containerDiv = $("<div/>",{});
			$containerDiv.append(template);
            $containerDiv.appendTo($parentContainer);
            
            return $containerDiv;
        }
	
	

    var Component = function() {

         this.initialize = function() {
            viewModel = new ViewModel();
            viewModel.initialize();
        }

        this.activate = function($parentContainer){

			$componentElement = createView( $parentContainer , view);
			ko.applyBindings(viewModel , $componentElement[0]  );
           // utilities.bindingComponent.bind(parentContainer, view, viewModel);
		   
            //viewModel.activate(parentContainer);
            
			
        }

    }

    return Component;
});