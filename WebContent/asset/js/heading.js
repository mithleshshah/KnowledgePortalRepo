/**
 * 
 */
$('document').ready(function(){
	
	$.getJSON('FetchCategoryJSON',{ajax:true},
			function(data){
		  
		 $('#cid').empty();
		    $('#cid').append($('<option>').text('-Select-'));
		   
		    $.each(data,function(i,item){
		    
		  $('#cid').append($('<option>').text(item.CATEGORYNAME).attr('value',item.CATEGORYID));	
		    	
		    	
		    });
		
	
	});
	
$('#cid').change(function(){
	
	$.getJSON('FetchChapterByCategoryIdJSON',{cid:$('#cid').val(),ajax:true},
			function(data){
	       
		$('#chid').empty();
	    $('#chid').append($('<option>').text('-Select-'));
	   
	    $.each(data,function(i,item){
	    
	  $('#chid').append($('<option>').text(item.CHAPTERNAME).attr('value',item.CHAPTERID));	
	    	
	    	
	    });
	
	
	});	
	
	
});


});







