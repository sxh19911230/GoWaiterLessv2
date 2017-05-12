function append_sid(link) {
    <?php if(session_id() !== NULL && !isset($_COOKIE['PHPSESSID'])) { ?>
        var session_id = '<?php echo session_id() ?>';
            if(link.indexOf('?') == -1) {
                return link + '?PHPSESSID=' + session_id;
            } else {
                return link + '&PHPSESSID=' + session_id;
           }
    <?php } else { ?>
        return link;
    <?php } ?>
}

// prompt for table # and message to kitchen
// because alertify is asyn function so we can only make them sequential by putting in callbacks
var order_info = {};
function place_order() {
	alertify.set({labels:{ok:"Send",cancel:""}});
<?php
if ($_SESSION['table_number'] == -999) {
?>
	alertify.prompt("What is your table number?", function (e, str) {
        order_info['table_number'] = str;
        send_order();
	}, '');
<?php
}
else { ?>
	order_info['table_number'] = <?php echo $_SESSION['table_number'];?>;
	send_order();
<?php
}
?>
}

function send_order() {
	alertify.prompt("Anything you want to tell the kitchen?", function (e, str) {
        order_info['message'] = str;
		$.ajax({
	    	url: append_sid("place_order.php"),
			cache: false,
			type: "POST",
			data: {order_info: order_info},
			dataType: 'json',
			success: function(result){
				if ($('#i_am_in_edit').length) {  // meaning in edit_order.php page
					$("#cart").html("<p class='text-center'><img src='images/empty_check.jpg'/><br>Your order has been sent.<br><a href='index.php' class='btn btn-primary'>Go Back to Menu</a><br>if you want to order more.</p>");$("#cart_in_edit").html("<p><img src='images/empty_check.jpg'/><br>Your order has been sent. <a href='index.php' class='btn btn-info'>Go Back to Menu</a> if you want to order more.</p>");
				}				
				else {
	    			$("#cart").html("<p class='text-center'><img src='images/empty_check.jpg'/><br>Your order has been sent. If you want to order more items please place another order again.</p>");
				}
	    		ordersInCart = [];
	    		for (var i=0; i<result.length; i++) {
	    			$("#item_"+result[i]).removeClass("btn-success").addClass("btn-primary");
	    		}
	    		alertify.set({labels:{ok:"Thank You!"}});
	    		alertify.alert("Your order has been sent.");
    			$("#edit_cart").html("");
    			$("#item_total").html("");
    			$("#place_order").html(""); 
	    	}
		});        
	}, '');
}