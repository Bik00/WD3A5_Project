$(function(){
	$(".placeAddBtn").click(function(){
		// 선택된 메인카테고리, 세부카테고리 값
		var dcatecode = $(".dcate option:selected").val();
		var mcatecode =$(".dcate option:selected").attr("name");
		var str = "<input type='hidden' value='"+mcatecode+"' name='mcate_code'>" +
					  "<input type='hidden' value='"+dcatecode+"' name='dcate_code'>" ;
		console.log("mcate : " + mcatecode);
		console.log("dcate : " + dcatecode);
		$("form").append(str);
		
		$("form").attr("action", "create");
		$("form").attr("method", "post");
		$("form").submit();
	});
});
