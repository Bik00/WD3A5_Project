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
				<button class="btn btn-default budget_button">����</button>
				<button class="btn btn-default budget_button">1����</button>
				<button class="btn btn-default budget_button">1����</button>
				<button class="btn btn-default budget_button">3����</button>
				<button class="btn btn-default budget_button">6����</button>
				<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="endDate">
	  				</div>
	  				<button type="submit" class="btn btn-default budget_button">��ȸ</button>
				</form>
			</div><br><br>
			
			<h2><b>���� ����</b></h2><br>
			<div class="budget_content">
				<table class="table">
			 		<tr>
			 			<td><input type="checkbox"></td>
		                <td>���� �Ⱓ</td>
			 			<td>�Ǹ� ����</td>
			 			<td>�Ǹ� ����</td>
			 			<td>���� ����</td>
			 			<td>������</td>
			 			<td>����</td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017�� 2��</td>
			 			<td>27</td>
			 			<td>540,000 ��</td>
			 			<td>513,000 ��</td>
			 			<td>27,000 ��</td>
			 			<td><button type="submit" class="btn btn-danger budget_impossible" id="budget_impossible">���� �Ϸ�</button></td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017�� 3��</td>
			 			<td>38</td>
			 			<td>820,000 ��</td>
			 			<td>779,000 ��</td>
			 			<td>41,000 ��</td>
			 			<td><button type="submit" class="btn btn-success budget_possible" id="budget_possible">���� �ϱ�</button></td>

			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017�� 4��</td>
			 			<td>41</td>
			 			<td>770,000 ��</td>
			 			<td>731,500 ��</td>
			 			<td>38,500 ��</td>
			 			<td><button type="submit" class="btn btn-danger budget_impossible" id="budget_impossible">���� �Ϸ�</button></td>
			 		</tr>
			 		<tr>
			 			<td><input type="checkbox"></td>
		                 <td>2017�� 5��</td>
			 			<td>42</td>
			 			<td>850,000 ��</td>
			 			<td>807,500 ��</td>
			 			<td>42,500 ��</td>
			 			<td><button type="submit" class="btn btn-success budget_possible" id="budget_possible">���� �ϱ�</button></td>
			 		</tr>
			 	</table><br>
			 	<div class="budget_amount">
			 		<h2><b>�� ���� ���� �ݾ� : 1,586,500 ��</b></h2>
			 	</div>
			 	<br>
			 	<br>
		 	</div>

		 	<div class="budget_option">
				<button class="btn btn-default budget_button">��� �Ⱓ �����ϱ�</button>
				<button class="btn btn-default budget_button">������ �Ⱓ�� �����ϱ�</button>
				<button class="btn btn-default budget_button">���ư���</button>
			</div>
		</div>
	</div>
</body>
</html>