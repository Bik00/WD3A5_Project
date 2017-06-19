$(function(){
	// 플레이스 수정 버튼 
	$(".placeManager_modifybtn").click(function(){
			location.href="placemodify";
	});
	
	$(".placeManager_requestlist").click(function(){
		location.href="requestList";
	});

	$(".placeManager_addBusiness").click(function(){
		location.href="addBusiness";
	});
	

	$(".placeManager_category").click(function(){
		location.href="categorySetting";
	});
	
	$(".placeManager_currentBudget").click(function(){
		location.href="currentBudget";
	});
});
