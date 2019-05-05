$('document').ready(function(){

$('#pat').keyup(function(){ 	
	
	$.getJSON('SearchResultJSON',{ajax:true,pat:$('#pat').val()},
			function(data){
		    var res='<html>';
		  res+='<center><table border=1 cellpadding=10 cellspacing=25 width=70%>';
		    $.each(data,function(i,item){
		    res+="<tr><td><a href=ListOfHeadings?chid="+item.CHAPTERID+"&chna="+item.CHAPTERNAME+"><h3>"+item.CHAPTERNAME+"</h3><h3><i>"+item.DESCRIPTION+"</i></h3></a></td></tr>"  	
			    	
		    });
		    res+='</table></center></html>'; 	
		    $('#result').html(res);
		    });
		
});
});