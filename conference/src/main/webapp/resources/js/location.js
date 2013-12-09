$(document).ready(function()
{
    $("#country").change(function(){
    	  jQuery.ajax({
              type: "post",
              url: "/location/getCities",
              data: {
                  location: jQuery("#country").val(),
              },
              success: function( data ) {
                  jQuery( "#town" ).html( data );
              }
          });
    	
    });
    

});