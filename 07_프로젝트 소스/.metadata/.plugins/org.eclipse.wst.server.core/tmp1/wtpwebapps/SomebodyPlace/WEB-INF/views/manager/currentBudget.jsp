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
			<div class="budgetDate">
				<button class="btn btn-default budget_button">오늘</button>
				<button class="btn btn-default budget_button">1주일</button>
				<button class="btn btn-default budget_button">1개월</button>
				<button class="btn btn-default budget_button">3개월</button>
				<button class="btn btn-default budget_button">6개월</button>
				<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="endDate">
	  				</div>
	  				<button type="submit" class="btn btn-default budget_button">조회</button>
				</form>
			</div><br><br>
			
			<h2><b>정산 내역</b></h2><br>
			<div class="budget_content">
				<table class="table">
			 		<tr>
			 			<td><input type="checkbox"></td>
		                <td>정산 기간</td>
			 			<td>판매 수량</td>
			 			<td>판매 가격</td>
			 			<td>정산 가격</td>
			 			<td>수수료</td>
			 			<td>상태</td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017년 2월</td>
			 			<td>27</td>
			 			<td>540,000 원</td>
			 			<td>513,000 원</td>
			 			<td>27,000 원</td>
			 			<td><button type="submit" class="btn btn-danger budget_impossible" id="budget_impossible">정산 완료</button></td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017년 3월</td>
			 			<td>38</td>
			 			<td>820,000 원</td>
			 			<td>779,000 원</td>
			 			<td>41,000 원</td>
			 			<td><button type="submit" class="btn btn-success budget_possible" id="budget_possible">정산 하기</button></td>

			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017년 4월</td>
			 			<td>41</td>
			 			<td>770,000 원</td>
			 			<td>731,500 원</td>
			 			<td>38,500 원</td>
			 			<td><button type="submit" class="btn btn-danger budget_impossible" id="budget_impossible">정산 완료</button></td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017년 5월</td>
			 			<td>42</td>
			 			<td>850,000 원</td>
			 			<td>807,500 원</td>
			 			<td>42,500 원</td>
			 			<td><button type="submit" class="btn btn-success budget_possible" id="budget_possible">정산 하기</button></td>
			 		</tr>
			 	</table><br>
			 	<div class="budget_amount">
			 		<h2><b>총 가능 정산 금액 : 1,586,500 원</b></h2>
			 	</div>
			 	<br>
			 	<br>
		 	</div>

		 	<div class="budget_option">
				<button class="btn btn-default budget_button">모든 기간 정산하기</button>
				<button class="btn btn-default budget_button">선택한 기간만 정산하기</button>
				<button class="btn btn-default budget_button">돌아가기</button>
			</div>
		</div>
	</div>
</body>
</html>