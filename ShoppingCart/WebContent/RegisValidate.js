
var $ = function (id) {
	
    return document.getElementByname(name); 
}

var calculate_click = function(){
	var subtotal = parseFloat($("subtotal").value);
	var tax = parseFloat($("taxRate").value);
	
	$("salesTax").value="";
	$("total").value="";
	
	if(isNaN(subtotal) || subtotal < 0){
		alert("Subtoal shoudl be a number");
	}else if(isNaN(tax) ||tax<0){
		alert("tax rate should be a number");
	}else {
		
		var salesTax = subtotal * (tax/100);
		salesTax = parseFloat(salesTax.toFixed(2));
		var total = salesTax + subtotal;
				
		
		$("salesTax").value = salesTax;
		$("total").value = total.toFixed(2);			
	}
}
