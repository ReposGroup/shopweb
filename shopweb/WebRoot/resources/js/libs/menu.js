// JavaScript Document
$(function(){
	//完整菜单效果1
		$(".sub-menu").hide();
		$(".main").show();
		$(".icon").click(function(){
			var len = $('.icon').length;
			var index = $(".icon").index(this);
			for(var i=0;i<len;i++){
				if(i == index){
					$('.sub-menu').eq(i).slideToggle(500);
					}else{
					$('.sub-menu').eq(i).slideUp(500);
					}
				}
			});
	})