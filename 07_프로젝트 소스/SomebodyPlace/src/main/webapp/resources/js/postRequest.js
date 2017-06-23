$(function(){
	$(".buyBtn").click(function(){
		$("form").attr("action", "moneysuccess");
		$("form").attr("method", "post");
		$("form").submit();
	});
});