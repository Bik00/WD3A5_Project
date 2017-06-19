<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="categorySetting">
    <h4><b>카테고리 관리ㆍ설정</b></h4>
    <div class="category">
        <input type="button" class="btn btn-default cateAddBtn" value="+ 카테고리 추가" />
        <input type="button" class="btn btn-default cateDelBtn" value="- 삭제" />
            
        <ul class="myCategory">
            <h5><b>&nbsp;&nbsp;카테고리 전체보기</b></h5><br>
            <c:forEach items="${BoardList}" var="board">
            	<li><input type="text" class="categoryInput" name="board_name" value="${board.board_name}" data="${board.board_code}"></li>
            </c:forEach>
    	</ul>

	    <div class="setting">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label>카테고리명</label> &nbsp;&nbsp;
	                <input type="text" class="categoryTitle form-control" id="aa">
	            </div>
	            <div class="form-group">
	                <label>공개설정</label> &nbsp;&nbsp;
	                     <input type="radio" name="open" checked="checked">공개
	                     <input type="radio" name="private">비공개
	            </div>
	
	        </form>
	    </div>
    	<input type="hidden" name="place_code" value="${place_code}">
     	<input type="button" class="btn btn-default cateSubmit" value="확인" />
	</div>
</form>