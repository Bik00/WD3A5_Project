<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<div class="placemanager">
     <div class="placemanager_category">
	       <button class="placeManager_modifybtn">�÷��̽� ����</button>
	       <button class="placeManager_requestlist">��û��Ȳ</button><br>
	       <button class="placeManager_addBusiness">����ڵ��</button>
		   <button class="placeManager_category">ī�װ�����</button><br>
	       <button class="placeManager_currentBudget">�������</button>
 	</div>
 	<c:if test="${placeMPage != null }">         
        <jsp:include page="${placeMPage}"></jsp:include>
	</c:if>
</div>


   