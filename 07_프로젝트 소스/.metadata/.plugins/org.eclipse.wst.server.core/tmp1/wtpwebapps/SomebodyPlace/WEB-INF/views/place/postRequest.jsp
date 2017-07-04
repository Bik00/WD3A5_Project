<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br>
<h1><b>　　　　신청 목록</b></h1>

<br>
<div class="postRequest_type">
 	 <div class="postRequest_info">
		<table class="table payment_list">
			<tr>
			
				<td class="payment_list_01">
					<h4><b>상품이름</b></h4>
					<div>${product.product_name}</div>
					
					
						
				</td>
				<td class="payment_list_01">
					<h4><b>상품내용</b></h4>
					<div>${product.product_explanation}</div>
					<div class="postRequest_Option">
						
						
					

					</div>
				</td>
					<td class="payment_list_02">
				<h4><b>옵션</b></h4>
					<c:forEach items="${option}" var="o" varStatus="option_status">
							${o.option_name} : 
							<c:forEach items="${detail_info}" var="detail" varStatus="detail_status" begin="${option_status.count-1}">
								<c:if test="${detail_status.first}">${detail.detail_name} ――― +${detail.additional_price}원</c:if>
							</c:forEach>
							<br>
						</c:forEach>
				</td>
				<td class="payment_list_02">
					<h4><b>수량</b></h4>
					1
				</td>
			
			</tr>
		</table><br><br><br><br><br><br>

	</div> 
	
	<div class="postRequest_div"> 

	<form>
	<input type="hidden" name="member_code" value="${member_code}">
	<input type="hidden" class="productCodeNum" name="productCodeNum" value="${product.product_code}">
	<input type="hidden" class="productTotalPrice" name="productTotalPrice" value="${product_Total}">
	<c:forEach items="${detail_info}" var="detail">
		<input type="hidden" class="detailCodeNum" name="detailCodeNum" value="${detail.detail_code}">
	</c:forEach>
	<table class="table price">
							<tr>
								<td><h4><b>총상품금액</b></h4></td>
							</tr>
							<tr>
								<td><h3><b>${product_Total}원</b></h3>
								<br>옵션 선택전 가격 : ${product.product_price}원
								</td>
							</tr>
						</table>


		<table class="table payment_list">
		
			<tr>
			
				<td class="payment_orderInfo">
	
				
				
					<div class="form-group">
					<tr><h4><b>주문자 정보</b></h4></tr>
					<label class="col-sm-2 control-label">이름:</label>
						<div class="col-xs-4"><input type="text" class="form-control" name="member_name"></div>
						<br>
					</div>
					<br>
					<div class="form-group">
						<label class="col-sm-2 control-label">주소:</label>
						<div class="col-sm-8 payment_address"><input type="text" class="form-control" name="member_addr"></div>
						<input type="button" value="주소 검색" class="btn btn-default col-sm-2" style="float:right; right:15px;">
						<br>
					</div>          
					<br>
					<div class="form-group">
						<label class="col-sm-2 control-label">휴대 전화: </label>
						<div class="col-xs-3"><input type="text" class="form-control" name="member_phone"></div>
			
					</div>
				</td>
				
			</tr>
		</table>
	</form>
	
		<table class="payment_Option">
	
			<tr>
				<td><h4><b>유형선택　　　</b></h4></td>
					<c:forEach var="type2" items="${type}"  >
		<td><input type="radio" name="request_type" value="${type2}">${type2}</td>
		</c:forEach>
			</tr>
			<tr>
				<td>
					<h4><b>결제수단　　　</b></h4>
				</td>
				<td><input type="radio" class="payment_Radiobox">신용 카드&nbsp;&nbsp;</td>
				<td><input type="radio" class="payment_Radiobox">실시간 계좌이체&nbsp;&nbsp;</td>
				<td><input type="radio" class="payment_Radiobox">휴대폰 결제&nbsp;&nbsp;</td>
				<td><input type="radio" class="payment_Radiobox">현장 지불&nbsp;&nbsp;</td><br><br>
			
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>　　</td>
				<td>　　</td>
				<td><input type="button" value="결제하기" class="buyBtn btn btn-default">
				<input type="button" value="취소하기" class="btn btn-default"><br></td>
			</tr>
			<tr>
				<td>　</td>
			</tr>
			
		</table>
		
	</div>

</div>
	
