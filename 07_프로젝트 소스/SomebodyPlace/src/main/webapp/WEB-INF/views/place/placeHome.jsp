<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="place_menu">
    <div class="place_manage">
        <button class="placeManager_btn btn btn-default">관리</button>
        <button class="postForm_btn btn btn-default">글쓰기</button>
    </div>
    <div class="place_cate">
        <c:forEach items="#{BoardList}" var="b">
              <a href="#" data-boardcode="${b.board_code}">${b.board_name}</a> 
        </c:forEach>
    </div>
</div>

<div class="place_post">
	<c:forEach items="${ProductList}" var="p">
		<div class="product_box" data="${p.product_code}">
	        <div class="product_img">
	        	<img src="./resources/img/${p.product_img}">
	        </div>
	        <div class="product_info">
	            <div>${p.product_name}</div>
	            <div>${p.product_explanation}</div>
	            <div>${p.product_price}</div>
	        </div>
	    </div>
	</c:forEach>
</div>