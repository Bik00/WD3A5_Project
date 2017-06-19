$(function(){
	var imgBoxW = $(".post_no_img").width();
	var img = new Image();
	img.src = $(".post_no_img img").attr("src");
	img.width = imgBoxW;
	$(".post_no_img").html(img);
	$(".post_no_img").height(img.height);
	
	
	//신청하기 버튼 클릭시 
	$(".post_request").click(function(){
		
		var product_code=	parseInt($(".product_code").val());
		
		location.href = "postRequest?product_code="+product_code;
	});
	
});