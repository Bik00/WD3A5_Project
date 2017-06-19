$(function(){
	
	
	/*이슈검색 버튼 */
	$(".issue_searchbtn").click(function(){
		alert("das");
	      $("form").attr("action", "searchIssue");
	      $("form").attr("method", "post");
	      $("form").submit();
		
		});
	

	/*이슈쓰기 버튼 */
	$(".issue_addIssuebtn").click(function(){
		location.href="addIssue";
		
		});
	
	/*이슈삭제 버튼 */
	$(".issue_deletebtn").click(function(){
		
		//alert($(this).parent().find("input").val());
		//alert($(this).parent().prev("input").val());
	
		var issue_code=$(this).parent().find("input").val();
		location.href="deleteIssue?issue_code="+issue_code;
			
	});
	
	
	
	/*앱이슈쓰기 버튼 */
	$(".m_issue_addIssuebtn").click(function(){
		alert("앱");
		location.href="addIssue";
		
		});
	$(document).ready(function(){

		$(".reply_list").hide();

		$(".issue_setting").click(function(){ 
			$('.settingDiv').css('left', event.pageX);
			$('.settingDiv').css('top', event.pageY);
			$(".settingDiv").show("slow");		
			
			
			$('.issue_code').val($(this).parent().parent().next().val());
	    });

		$(document).mouseup(function (e) {
			// 팝업 아이디
			var container = $(".settingDiv");
			if (!container.is(e.target) && container.has(e.target).length === 0){
				container.hide("slow");
			}	
		});

		$(".replies").on("click", function() {
			var id = $(this).parent().attr("data-replyBtn");
			var id2 = $(this).parent().next().attr("data-replyList");

			if(id == id2) {
				if($(this).text() == "댓글 보기") {
					$(this).parent().next().show("slow");
					$(this).text("댓글 닫기");
				}
				else if($(this).text() == "댓글 닫기") {
					$(this).parent().next().hide("slow");
					$(this).text("댓글 보기");
				}				
			}
		});
	});
	
});