$(function(){
	
	/* mypage 에서 회원정보 수정 클릭 했을시 */
	$("#mypage_indiv_modifyForm").click(function(){
		location.href="modifyForm";
	});
	
	/* mypage 에서 신청내역 클릭 했을시 */
	$("#mypage_indiv_orderList").click(function(){
		var member_code=$(".member_code").val();
		location.href="orderList?member_code="+member_code;
	});

	/* mypage 에서 장바구니 클릭 했을시 */
	$("#mypage_indiv_cart").click(function(){
		location.href="cart";
	});

	/* mypage 에서 위시리스트  클릭 했을시 */
	$("#mypage_indiv_wishlist").click(function(){
		location.href="wishlist";
	});
	
	/* mypage 에서 즐겨찾기 클릭 했을시 */
	$("#mypage_indiv_favorites").click(function(){
		location.href="favorites";
	});
	
	/* mypage 에서 관심사 설정 클릭 했을시 */
	$("#mypage_indiv_interestSetting").click(function(){
		location.href="interestSetting";
	});


	

	
	
});