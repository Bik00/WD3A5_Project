$(document).ready(function() {
	$(".budget_impossible").click(function() {
		alert("이미 정산 완료된 기간입니다.");
	});
	$(".budget_possible").click(function() {
		confirm("정산하시겠습니까?");
	});
});