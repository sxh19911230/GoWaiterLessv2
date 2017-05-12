function update_quantity(new_qty, i) {
	if (typeof(new_qty) == "number") quantity = new_qty;
	else quantity = new_qty.value;
	if (quantity < 1) quantity = 1;
	
    $.ajax({
    	url: append_sid("update_quantity.php"),
		cache: false,
		type: "POST",
		data: {item_no: i, quantity: quantity},
		success: function(result){
			show_cart();
    	}
	});
}

function delete_item(i) {
	alertify.set({labels:{ok:"Yes",cancel:"Not really"}});
	alertify.set({ buttonReverse: true });
	alertify.confirm("Are you sure you want to delete this item?",function(e){
	    if (e) {
		    $.ajax({
		    	url: append_sid("delete_item.php"),
				cache: false,
				type: "POST",
				data: {item_no_in_cart: i},
				success: function(result){
					show_cart();
					if (result != "") $("#item_"+result).removeClass("btn-success").addClass("btn-primary");
	                    //var index = ordersInCart.indexOf(result);
	                    //if (index > -1) {
	                    //    ordersInCart.splice(index, 1);
	                    //}
		    	}
			});
	    }
	    else return;
	});
}

function plus_one() {
	quantity = $('#qty').val();
    $('#qty').val(++quantity > 99 ? 99 : quantity);
    changePrice();
}

function minus_one(i) {
	quantity = $('#qty').val();
	$('#qty').val(--quantity < 1 ? 1 : quantity);
    changePrice();
}



function empty_cart() {
	alertify.set({labels:{ok:"Yes",cancel:"Not really"}});
	alertify.set({ buttonReverse: true });
	alertify.confirm("Are you sure you want to empty your order?",function(e){
	    if (e) {
		    $.ajax({
		    	url: append_sid("empty_cart.php"),
				cache: false,
				dataType: 'json',
				success: function(result){
		    		$("#cart").html("<p class='text-center'><img src='images/empty_check.jpg'/><br>You have not ordered anything. Clcik the green + sign to add items to your order.</p>");
		    		
		    	}
			});
	    }
	    else return;
	});
}

function show_cart() {
    $.ajax({
    	url: append_sid("show_cart.php"),
		cache: false,
		//dataType: 'json',
		success: function(results){
            if (results == "" )
                $("#cart").html("<p class='text-center'><img src='images/empty_check.jpg'/><br>You have not ordered anything. Clcik the green + sign to add items to your order.</p>");
    		else
                $("#cart").html(results);
		
    	}
	});
}

function round(v, decimals) {
  return Number(Math.round(v+'e'+decimals)+'e-'+decimals);
}