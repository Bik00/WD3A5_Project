<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form class="addForm">
	<c:if test="${PlaceX!= null }">  
      	<script>
      		alert("플레이스를 먼저 생성해주세요");
      	</script>
    </c:if> 
    <input type="hidden" name="board_name" value="게시판">
    <h2>플레이스 생성</h2><br>
    <div class="form-group">
    	 <input type="hidden" value="${member_email}" name="member_email"><br>
    	 <input type="hidden" value="${member_code}" name="member_code"><br>
           <label>플레이스명</label><input type="text" class="form-control" name="Place_name" /><br>
    </div>
    
     <div class="reserveForm_type">
	      <label>플레이스로고</label><br>
	      <div class="reserve_fileBox">
		      <label for="reserveForm_ImgUpload" class="reserveForm_img">
		           <p>클릭해서<br>로고를<br>등록하세요</p>
		      </label>
		      <input type="file" id="reserveForm_ImgUpload" name="Place_logo">
	 	  </div><br><br><br>
	</div><br><br><br><br><br><br><br><br>
	
   	 <label>플레이스접속 URL　　(변경불가)</label><br>
    	  
     http://localhost:8080/somebodyplace/${member_email}<br><br>
    	  
    <label>카테고리</label><br>


  		메인 카테고리
         <select class="mcate">
             <c:forEach items="${McateList}" var="m">
            	<c:if test="${m.mcate_code == 1}">
            		<option value="${m.mcate_code}" selected>${m.mcate_name}</option>
            	</c:if>
            	<c:if test="${m.mcate_code != 1 }">
            		<option value="${m.mcate_code}">${m.mcate_name}</option>
            	</c:if>
            </c:forEach>
        </select>
             세부 카테고리
        <select class="dcate">
            <c:forEach items="${DcateList}" var="d">
            	<c:if test="${d.mcate_code == 1}"> 
            		<c:if test="${d.dcate_code == 1 }">
            			<option value="${d.dcate_code}" name="${d.mcate_code}" selected>${d.dcate_name}</option>
            		</c:if>
            		<c:if test="${d.dcate_code != 1 }">
            			<option value="${d.dcate_code}" name="${d.mcate_code}">${d.dcate_name}</option>
            		</c:if>
            	</c:if>
            </c:forEach>
            <c:forEach items="${DcateList}" var="d">
            	<input type="hidden" class="dcateList" name="${d.dcate_name}" value="${d.mcate_code}" data="${d.dcate_code}">
            </c:forEach>
        </select>
	
           
    <label class="YaKwan">약관</label>
    <textarea class="form-control" rows="3" style="width:100%;">
			제 1 장 총 칙
			제 1 조 (목적)
			본 약관은 서비스 이용자가 주식회사 썸바디플레이스(이하 “회사”라 합니다)가 제공하는 온라인상의 인터넷 서비스(이하 “서비스”라고 하며, 접속 가능한 유∙무선 단말기의 종류와는 상관없이 이용 가능한 “회사”가 제공하는 모든 “서비스”를 의미합니다. 이하 같습니다)에 회원으로 가입하고 이를 이용함에 있어 회사와 회원(본 약관에 동의하고 회원등록을 완료한 서비스 이용자를 말합니다. 이하 “회원”이라고 합니다)의 권리•의무 및 책임사항을 규정함을 목적으로 합니다....등등
    </textarea><br>

    <div class="checkbox">
         <label><input type="checkbox" value="">동의</label>
    </div>
	<button class="btn btn-default placeAddBtn">생성하기</button>
    <input type="button" class="btn btn-default cancelBtn" id="cancelBtn" onclick="self.location='main'" value="취소하기" />
</form>

