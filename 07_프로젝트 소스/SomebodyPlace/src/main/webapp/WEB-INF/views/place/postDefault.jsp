<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="post_default">
    <div class="post_img">
        <div class="post_no_img">
            <img src="./resources/img/${product.product_img}">
        </div>
    </div>
  
    <div class="post_type">
        <div class="post_title">${product.product_name}</div>
      <b>${type}</b>
      <input type="hidden" value="${type}" class="type" name="type">가능상품<br><br>
      
      
       설명: <div class="post_description">${product.product_explanation}</div>
		<input type="text" value="${product_code}" class="product_code" id="product_code" style="visibility:hidden">
		<input type="text" value="${member_code}" class="member_code" id="member_code" style="visibility:hidden">
        <div class="post_price"><h3><b>기본가 : ${product.product_price}원</b></h3></div>
        <div class="post_options">
	        <c:forEach items="${option}" var="o">
		        	${o.option_name}
		        	 <select name="color" class="form-control detail_select">
			        	 <c:forEach items="${detailArray}" var="detail">
			        	 	<c:if test="${o.option_code == detail.option_code}">
				        			<option data-detailCode="${detail.detail_code}">${detail.detail_name} &nbsp;&nbsp;&nbsp;+ ${detail.add_price}원</option>
				        	</c:if>
			        	</c:forEach>
		        	 </select>
	        </c:forEach>
        </div>
        <div class="post_totalPrice"><h3><b>총 가격 : ${product.product_price}원</b></h3></div>
        <div class="post_btns">
            <button class="btn btn-default post_request">신청하기</button><br>
            <button class="btn btn-default post_cart">CART</button>
       
        </div>
    </div>
    <div class="post_content">
		<c:forEach items="${postContent}" var="post">
			<c:if test="${post.content.matches('.*jpg.*')}">
				<img src="./resources/img/${post.content}">
			</c:if>
			<c:if test="${!post.content.matches('.*jpg.*')}">
				<div>${post.content}</div>
			</c:if>
			
		</c:forEach>
	</div>
    
</div>

