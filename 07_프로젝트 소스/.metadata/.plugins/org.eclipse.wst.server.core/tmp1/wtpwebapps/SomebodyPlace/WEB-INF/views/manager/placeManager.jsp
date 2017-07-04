<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<div class="placemanager">
     <div class="placemanager_category">
	
	      <button class="btn btn-default placeManager_modifybtn">플레이스 수정</button>
	    
	       <button class="btn btn-default placeManager_requestlist">신청현황</button><br>
	       <button class="btn btn-default placeManager_addBusiness">사업자등록</button><br>
		   <button class="btn btn-default placeManager_category">카테고리관리</button><br>
	       <button class="btn btn-default placeManager_currentBudget">정산관리</button>
 	</div>
 	<c:if test="${placeMPage != null }">         
        <jsp:include page="${placeMPage}"></jsp:include>
	</c:if>
</div>