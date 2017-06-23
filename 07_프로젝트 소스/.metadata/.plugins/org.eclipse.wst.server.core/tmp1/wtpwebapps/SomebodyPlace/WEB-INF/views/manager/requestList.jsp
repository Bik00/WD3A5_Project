<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div class="table-responsive">

		<div class="orderDate">
			<button class="btn btn-default">오늘</button>
			<button class="btn btn-default">1주일</button>
			<button class="btn btn-default">1개월</button>
			<button class="btn btn-default">3개월</button>
			<button class="btn btn-default">6개월</button>

				<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="requestForm form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="requestForm form-control" id="endDate">
	  				</div>
	  			<button type="submit" class="btn btn-default">조회</button>
	</form>
		</div><br><br>
		
			<h2><b>Request Current State</b></h2><br>
		 	<table class="table">
		 		<tr>
		 			<td><input type="checkbox"></td>
                    <td>신청회원</td>
		 			<td>신청일자<br>[신청코드]</td>
		 			<td>이미지</td>
		 			<td>상품정보</td>
		 			<td>수량</td>
		 			<td>상품구매금액</td>
		 			<td>배송상태</td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>유도니</td>
		 			<td>20170504<br>[20170504001]</td>
		 			<td><img src="img1.png"></td>
		 			<td>코코도르 카네이션 디퓨저 1+1</td>
		 			<td>2</td>
		 			<td>8,900원</td>
		 			<td>배송중</td>
                    <td>                
		 				<button class="btn btn-default" type="button">상품배송시작</button><br>
		 				<button class="btn btn-default" type="button">상품배송현황</button><br>
		 				<button class="btn btn-default" type="button">신청삭제하기</button>
                    </td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>광민</td>
		 			<td>20170302<br>[20170302050]</td>
		 			<td><img src="img2.png"></td>
		 			<td>앤썸 신상 가디건/니트</td>
		 			<td>1</td>
		 			<td>9,900원</td>
		 			<td>배송완료</td>
                     <td>                
		 				<button class="btn btn-default" type="button">상품배송시작</button><br>
		 				<button class="btn btn-default" type="button">상품배송현황</button><br>
		 				<button class="btn btn-default" type="button">신청삭제하기</button>
                    </td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>송이세상</td>
		 			<td>20161225<br>[20161225080]</td>
		 			<td><img src="img3.png"></td>
		 			<td>마이클코어스 신상</td>
		 			<td>1</td>
		 			<td>139,000원</td>
		 			<td>배송완료</td>
                    <td>                
		 				<button class="btn btn-default" type="button">상품배송시작</button><br>
		 				<button class="btn btn-default" type="button">상품배송현황</button><br>
		 				<button class="btn btn-default" type="button">신청삭제하기</button>
                    </td>
		 		</tr>
		 	</table><br>
		</div>
</body>
</html>