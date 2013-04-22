


function callThisMethodAfterValueIsUpdated(data) {
    	
	if (data.status === 'complete'){
		if(doesStartWith(data.responseText,'<script') || doesStartWith(data.responseText,'<!DOCTYPE html>')) {
			window.location = "/"
		}
	}
}


function doesStartWith(data, compare){
	return data.substring(0, compare.length) === compare;
}