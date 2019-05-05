/**
 * 
 */

$('document').ready(function(){
	
	$('#btn').click(function(){
	$.getJSON('CheckAdminPasswordJSON',{ajax:true,aid:$('#aid').val(),pwd:$('#pwd').val()},
			function(data){
		    //alert(data.message);
		     if(data.message=="1")
		    	 {
		    	 window.location.href="http://localhost:88/KP/AdminHome";
		    	 }
		     else
		    	 {
		    	 
		    	 $('#result').html("<font color=red><b>"+data.message+"</b></font>");
		    	   
		    	 }
		    	
		    });
		
	
	});
});