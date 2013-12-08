(function( jQuery, window, undefined ) {
    jQuery( ".datePicker" ).datepicker({dateFormat:"yy-mm-dd"});
     
    jQuery("#login").submit(function (e) {
        e.preventDefault();
        jQuery.ajax({
            type: "post",
            url: "/login",
            data: {
                username: jQuery("#user").val(),
                password: jQuery("#pass").val()
            },
            success: function( data ) {
            	jQuery("form#login").hide();
                jQuery( ".menu" ).html( data );
            } 
        });
    });
    
    function bindDatePickerEvents(domSelector) {
        domSelector.find(".datePicker").datepicker({dateFormat:"yy-mm-dd"});
    }

})( jQuery, window, undefined);