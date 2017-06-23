$(function(){
	// 카테고리 데이터 보내기
	$('.cateSubmit').click(function(){
		var str =""; var board_code = 0;
		$('.categoryInput').each(function(){
			board_code = $(this).attr("data");
			str += "<input type='hidden' name='board_code' value='"+board_code+"'>";
		});
		$("form").append(str);
		$("form").attr("action","categoryChange");
		$("form").attr("method", "post");
		$("form").submit();
	});
	
	// 게시판 삭제
	$(".cateDelBtn").click(function(){
		var delCode = $('.inputOn').attr("data");
		var str = "<input type='hidden' name='del_code' value='"+delCode+"'>";
		$("form").append(str);
		$('.inputOn').parent().remove();
	});
	// 카테고리 드래그
	$( ".myCategory" ).sortable();
    $( ".myCategory" ).disableSelection();
	// 카테고리 추가 버튼 클릭시 카테고리 영역에 텍스트입력창 표시
	$('.cateAddBtn').click(function(){
		$('.categoryInput').each(function(){
			$(this).removeClass("inputOn");
			$(this).css("border", "none");
			$(this).attr("readonly", "readonly");
			$(this).css("background", "none");
		});
		var cateinput = "<li><input type='text' name='board_name' class='categoryInput inputOn' value='게시판' data=0></li>";
		$('.myCategory').append(cateinput);
	});
	// 텍스트 입력창에 텍스트 입력 시 타이틀 입력창에 동일 텍스트 입력
	$(document).on("keypress keyup", '.categoryInput', function(){
		$('.categoryTitle').val($(this).val());
	});
	// 타이틀 입력창에 텍스트 입력 시  텍스트 입력창에 동일 텍스트 입력
	$(document).on("keypress keyup", '.categoryTitle', function(){
		$('.inputOn').val($(this).val());
	});
	// 
	$('body').click(function(e){
		// 타이틀  입력창 클릭 시 텍스트입력창 배경 없애기
		if($(e.target).hasClass('categoryTitle')){
			$('.categoryInput').each(function(){
				$(this).css("background", "none");
			});
		}
		// [카테고리 추가]버튼이나 텍스트입력창 외의 영역 클릭시 
		// 모든 게시판 입력창 비활성화
		else if(!$(e.target).hasClass('cateAddBtn') && !$(e.target).hasClass('categoryInput')){
			$('.categoryInput').each(function(){
				$(this).css("border", "none");
				$(this).attr("readonly", "readonly");
				$(this).css("background", "none");
				$(this).removeClass("inputOn");
			});
		}
	});
	// 카테고리 입력창 클릭 시 타이틀에 입력창의 데이터 적용
	$(document).on('click', '.categoryInput', function(e){
		$('.categoryTitle').val($(this).val());	// 타이틀 데이터를 해당 입력창에 입력
		$('.categoryInput').each(function(){
			$(this).css("background", "none");
			$(this).removeClass("inputOn");
			$(this).css("border", "none");
			$(this).attr("readonly", "readonly");
		});
		// 클릭한 텍스트 입력창의 배경색을 주고 inputOn클래스 활성화
		$(this).css("background", "silver");
		$(this).addClass("inputOn");
	});
	// 입력창 더블클릭시 모든 입력창 비활성화 후 
	// 더블클릭한 입력창만 활성화
	$(document).on('dblclick', '.categoryInput', function(){
		$('.categoryInput').each(function(){
			$(this).css("border", "none");
			$(this).attr("readonly", "readonly");
			$(this).css("background", "none");
			$(this).removeClass("inputOn");
		});
		$(this).css('border', '1px solid gray');
		$(this).removeAttr("readonly");
		$(this).css("background", "none");
		$(this).addClass("inputOn");
	});
});