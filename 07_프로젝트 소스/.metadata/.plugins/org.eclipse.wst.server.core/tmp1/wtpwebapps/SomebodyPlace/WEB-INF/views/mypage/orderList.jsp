<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

		<div class="orderList_orderDate">
			<button class="orderList_btn">오늘</button>
			<button class="orderList_btn">1주일</button>
			<button class="orderList_btn">1개월</button>
			<button class="orderList_btn">3개월</button>
			<button class="orderList_btn">6개월</button>

			<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="endDate">
	  				</div>
		  			<button type="submit" class="orderList_btn">조회</button>
			</form>
		</div><br><br>
		
			<h2 class="orderList_title"><b>ORDER LIST</b></h2><br>
		 	<table class="orderList_table">
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>신청일자<br>[신청코드]</td>
		 			<td>이미지</td>
		 			<td>상품정보</td>
		 			<td>수량</td>
		 			<td>상품구매금액</td>
		 			<td>신청상태</td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>20170504<br>[20170504001]</td>
		 			<td><img src="./resources/img/img1.PNG"></td>
		 			<td>코코도르 카네이션 디퓨저 1+1</td>
		 			<td>2</td>
		 			<td>8,900원</td>
		 			<td>배송중</td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>20170302<br>[20170302050]</td>
		 			<td><img src="./resources/img/img2.png"></td>
		 			<td>앤썸 신상 가디건/니트</td>
		 			<td>1</td>
		 			<td>9,900원</td>
		 			<td>배송완료</td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>20161225<br>[20161225080]</td>
		 			<td><img src="./resources/img/img3.PNG"></td>
		 			<td>마이클코어스 신상</td>
		 			<td>1</td>
		 			<td>139,000원</td>
		 			<td>배송완료</td>
		 		</tr>
		 	</table><br>
		
