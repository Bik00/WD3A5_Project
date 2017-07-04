<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		<div class="orderList_orderDate">
			<button class="orderList_btn">����</button>
			<button class="orderList_btn">1����</button>
			<button class="orderList_btn">1����</button>
			<button class="orderList_btn">3����</button>
			<button class="orderList_btn">6����</button>

			<form class="form-inline">
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="startDate"> ~
	 				</div>
	 				<div class="form-group">
	    				<input type="date" class="form-control" id="endDate">
	  				</div>
		  			<button type="submit" class="orderList_btn">��ȸ</button>
			</form>
		</div><br><br>
		
			<h2 class="orderList_title"><b>ORDER LIST</b></h2><br>
		 	<table class="orderList_table">
		 
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>��û����<br>[��û�ڵ�]</td>
		 			<td>�̹���</td>
		 			<td>��ǰ����</td>
		 			<td>����</td>
		 			<td>��ǰ���űݾ�</td>
		 			<td>��û����</td>
		 		</tr>
		 			<c:forEach items="${orderlist}" var="list">
		 		<tr>
		 			<td><input type="checkbox"></td>
		 			<td>
		 			<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${list.request_date}" />
					</td>
		 			<td><img src="./resources/img/${list.product_img}"></td>
		 			<td>${list.product_name}</td>
		 			<td>${list.amount}</td>
		 			<td>${list.request_list_totalprice}</td>
		 			<td>${list.request_status}</td>
		 		</tr>
		 		
		 		</c:forEach>
		 	</table><br>
		
