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
			<button class="btn btn-default">����</button>
			<button class="btn btn-default">1����</button>
			<button class="btn btn-default">1����</button>
			<button class="btn btn-default">3����</button>
			<button class="btn btn-default">6����</button>

				<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="requestForm form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="requestForm form-control" id="endDate">
	  				</div>
	  			<button type="submit" class="btn btn-default">��ȸ</button>
	</form>
		</div><br><br>
		
			<h2><b>Request Current State</b></h2><br>
		 	<table class="table">
		 		<tr>
		 			<td><input type="checkbox"></td>
                    <td>��ûȸ��</td>
		 			<td>��û����<br>[��û�ڵ�]</td>
		 			<td>�̹���</td>
		 			<td>��ǰ����</td>
		 			<td>����</td>
		 			<td>��ǰ���űݾ�</td>
		 			<td>��ۻ���</td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>������</td>
		 			<td>20170504<br>[20170504001]</td>
		 			<td><img src="img1.png"></td>
		 			<td>���ڵ��� ī���̼� ��ǻ�� 1+1</td>
		 			<td>2</td>
		 			<td>8,900��</td>
		 			<td>�����</td>
                    <td>                
		 				<button class="btn btn-default" type="button">��ǰ��۽���</button><br>
		 				<button class="btn btn-default" type="button">��ǰ�����Ȳ</button><br>
		 				<button class="btn btn-default" type="button">��û�����ϱ�</button>
                    </td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>����</td>
		 			<td>20170302<br>[20170302050]</td>
		 			<td><img src="img2.png"></td>
		 			<td>�ؽ� �Ż� �����/��Ʈ</td>
		 			<td>1</td>
		 			<td>9,900��</td>
		 			<td>��ۿϷ�</td>
                     <td>                
		 				<button class="btn btn-default" type="button">��ǰ��۽���</button><br>
		 				<button class="btn btn-default" type="button">��ǰ�����Ȳ</button><br>
		 				<button class="btn btn-default" type="button">��û�����ϱ�</button>
                    </td>
		 		</tr>
		 		<tr>
		 			<td><input type="checkbox"></td>
                     <td>���̼���</td>
		 			<td>20161225<br>[20161225080]</td>
		 			<td><img src="img3.png"></td>
		 			<td>����Ŭ�ھ �Ż�</td>
		 			<td>1</td>
		 			<td>139,000��</td>
		 			<td>��ۿϷ�</td>
                    <td>                
		 				<button class="btn btn-default" type="button">��ǰ��۽���</button><br>
		 				<button class="btn btn-default" type="button">��ǰ�����Ȳ</button><br>
		 				<button class="btn btn-default" type="button">��û�����ϱ�</button>
                    </td>
		 		</tr>
		 	</table><br>
		</div>
</body>
</html>