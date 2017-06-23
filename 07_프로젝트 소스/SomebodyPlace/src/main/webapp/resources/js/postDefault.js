var originalPrice = ""; // 원래 가격
var className = ""; // 선택된 옵션들
$(function(){
	//원래 가격을 저장시킨다.
	originalPrice = $(".post_price>h3>b").text().substring($(".post_price>h3>b").text().indexOf(":")+2, $(".post_price>h3>b").text().indexOf("원"));
	
	var imgBoxW = $(".post_no_img").width();
	var img = new Image();
	img.src = $(".post_no_img img").attr("src");
	img.width = imgBoxW;
	$(".post_no_img").html(img);
	$(".post_no_img").height(img.height);
	
	
	//신청하기 버튼 클릭시 
	$(".post_request").click(function(){
		
		var product_code = $("#product_code").val();
		var member_code = $("#member_code").val();
		var product_price = originalPrice;
		var product_Total = $(".post_totalPrice>h3>b").text().substring($(".post_totalPrice>h3>b").text().indexOf(":")+2, $(".post_totalPrice>h3>b").text().indexOf("원"));
		var type=$(".type").val();
		

		var form = $('<form></form>');
		form.attr('action', 'postRequest');
		form.attr('method', 'post');
		form.appendTo('body');
		
		var className = document.getElementsByClassName("detail_select");
		for(var i=0;i<className.length;i++) {
			/*var e = $('<input type="text" value="'+parseInt(className[i].value.substring(className[i].value.indexOf("+")+2, className[i].value.indexOf("원")))+'" id="detail_price" name="detail_price">');*/
			var k = className[i].options[className[i].selectedIndex].getAttribute("data-detailCode");
			var e = $('<input type="text" value="'+k+'" id="detail_code" name="detail_code">');
			form.append(e);
		}

		var a = $('<input type="hidden" value="'+product_code+'" name="product_code">');
		var b = $('<input type="hidden" value="'+member_code+'" name="member_code">');
		var c = $('<input type="hidden" value="'+product_price+'" name="product_price">');
		var d = $('<input type="hidden" value="'+product_Total+'" name="product_Total">');
		var z = $('<input type="hidden" value="'+type+'" name="type">');
		
		form.append(a).append(b).append(c).append(d).append(z);
		form.submit();
	});
	
	$(document).on('change', '.detail_select', function(){
		className = document.getElementsByClassName("detail_select");
		var presentPrice = originalPrice;
		for(var i=0;i<className.length;i++) {
			presentPrice = parseInt(presentPrice)+parseInt(className[i].value.substring(className[i].value.indexOf("+")+2, className[i].value.indexOf("원")));
		}		
		$(".post_totalPrice>h3>b").text("총 가격 : "+presentPrice+"원");
	});
});