window.onload = function() {
	if (self.name != 'reload') {
		self.name = 'reload';
		self.location.reload(true);
	} else
		self.name = '';
    $(window).scroll(function() {                
        if($(this).scrollTop()>0){
        
        	$(".hideme").fadeIn();
        }else{
        	$('.hideme').fadeOut();
        }
    });
    
}

function fnMove(cls){
	 var offset = $("."+cls).offset();
	 if(cls=="impormation"){
	 	offset.top = offset.top-200;
	 }else if(cls=="picture"){
	 	offset.top = offset.top-100;	 	
	 }
	 console.log(offset);
    $('html, body').animate({scrollTop : offset.top}, 1000);
}

