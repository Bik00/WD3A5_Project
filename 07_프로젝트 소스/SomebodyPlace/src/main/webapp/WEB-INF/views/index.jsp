<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="./resources/css/main.css">
    <link rel="stylesheet" href="./resources/css/loginForm.css">
    <link rel="stylesheet" href="./resources/css/place.css?ver=2">
    <link rel="stylesheet" href="./resources/css/postForm.css?ver=1">
    <link rel="stylesheet" href="./resources/css/joinForm.css">
    <link rel="stylesheet" href="./resources/css/mypage.css">
    <link rel="stylesheet" href="./resources/css/modifyForm.css">
    <link rel="stylesheet" href="./resources/css/orderList.css">
    <link rel="stylesheet" href="./resources/css/cart.css">
    <link rel="stylesheet" href="./resources/css/wishList.css">
    <link rel="stylesheet" href="./resources/css/favorites.css">
    <link rel="stylesheet" href="./resources/css/interestSetting.css">
    <link rel="stylesheet" href="./resources/css/issue.css">
    <link rel="stylesheet" href="./resources/css/placeMain.css">
    <link rel="stylesheet" href="./resources/css/placemanager.css?ver=1">
    <link rel="stylesheet" href="./resources/css/placeAddForm.css">
    <link rel="stylesheet" href="./resources/css/requestList.css?ver=2">
    <link rel="stylesheet" href="./resources/css/addBusiness.css">
    <link rel="stylesheet" href="./resources/css/categorySetting.css?ver=4">
    <link rel="stylesheet" href="./resources/css/currentBudget.css">
    <link rel="stylesheet" href="./resources/css/chatting.css">
	<link rel="stylesheet" href="./resources/css/addIssue.css">
	<link rel="stylesheet" href="./resources/css/postDefault.css">
	<link rel="stylesheet" href="./resources/css/postRequest.css?ver=2">
           
           
	<script src="./resources/js/issue.js?ver=5"></script>   
	<script src="./resources/js/addIssue.js?ver=6"></script>   
    <script src="./resources/js/index.js?ver=5"></script>
    <script src="./resources/js/place.js?ver=1"></script>
    <script src="./resources/js/postForm.js?ver=29"></script>
    <script src="./resources/js/mypage.js"></script>
    <script src="./resources/js/placeMain.js"></script>
    <script src="./resources/js/placeManager.js"></script>
    <script src="./resources/js/currentBudget.js"></script>  
    <script src="./resources/js/sockjs.js"></script>
    <script src="./resources/js/chatting.js"></script>
    <script src="./resources/js/placeAddForm.js?ver=2"></script>
    <script src="./resources/js/categorySetting.js?ver=2"></script>
    <script src="./resources/js/placeHome.js?ver=3"></script>
	<script src="./resources/js/postDefault.js?ver=4"></script>
	<script src="./resources/js/postRequest.js?ver=4"></script>
       
    <title>Somebody Place</title>
</head>
<body>
    <div id="main">
        <div id="main_logo">
            <img src="./resources/img/somebodyplaceLOGO.png" class="index_logo">
            <span class="main_member">
            	<c:if test="${nickname != null }">         
        			${nickname}님 환영합니다. 
        	    	<span class="main_logoutBtn">로그아웃</span>
				</c:if>
				<c:if test="${nickname == null }">  
                	<span class="main_loginBtn">로그인</span> 
             	</c:if>  
                <span class="main_joinForm">회원가입</span>
                <span class="main_myPage">마이페이지</span>
                <a href="place?member_code=${member_code}&member_email=${member_email}">
                	<span class="main_myPlaceBtn">마이플레이스</span>
                </a> 
                <span class="main_PlaceBtn">플레이스</span>
            </span>
        </div>
        <div id="main_cate">
            <div class="dropdown">
                <span>배달</span>
                <div class="dropdown-content">
                    <a href="main?dcate_code=1">음식</a>
                    <a href="main?dcate_code=2">꽃</a>
                    <a href="main?dcate_code=3">세탁</a>
                </div>
            </div>
            <div class="dropdown">
                <span>쇼핑</span>
                <div class="dropdown-content">
                    <a href="main?dcate_code=4">패션</a>
                    <a href="main?dcate_code=5">생활</a>
                    <a href="main?dcate_code=6">디지털</a>
                </div>
            </div>
            <div class="dropdown">
                <span>여가</span>
                <div class="dropdown-content">
                    <a href="main?dcate_code=7">공연</a>
                    <a href="main?dcate_code=8">숙박</a>
                </div>
            </div>
            <div class="dropdown">
                <span>뷰티</span>
                <div class="dropdown-content">
                    <a href="main?dcate_code=9">미용실</a>
                    <a href="main?dcate_code=10">네일</a>
                    <a href="main?dcate_code=11">화장품</a>
                </div>
            </div>
            <div class="dropdown">
               <span class="main_issue">이슈</span>
            </div>
        </div>
        
        <c:if test="${cont != null }">         
        	<jsp:include page="${cont}"></jsp:include>
		</c:if>
		
    </div>
    
    <!-- 채팅 내용 -->
    <c:if test="${nickname!= null && applogin == null}">
		<div class="chatImg">
			<img src="./resources/img/chat.png">
			<span class="badge chat_balloons"></span>		
		</div>
		
		<div id="code" class="chat_info">${code}</div>
		<div id="nickname" class="chat_info">${nickname}</div>
		<div id="sender"></div>
	</c:if>
    <div class="chatDiv">
    	<span class="backChat glyphicon glyphicon-chevron-left"></span>
    	<span class="closeChat glyphicon glyphicon-remove"></span>
		<div class="chat_content">
		
 			<div class="chat_main">
		    	<div class="chat_owner">
		    		<h3>${nickname} 님의 대화방 목록 입니다.</h3>
		    	</div>
		    	<div class="chat_rooms">	    	
		    	</div>
	    	</div>
	    	
	    	<div class="chat_sub">
		    	<div class="chatWrap">	
					<div class="chats" id="chats">
					</div>
				</div>
				<span class="chat_more glyphicon glyphicon-plus-sign"></span>
					<div class="chat_flip">	
						<div class="chat_card">
							<div class="chat_menu front">
								<img src="./resources/img/chat_addAuto.png" class="chat_menu_img" id="addAuto" style="cursor: pointer;">
								<img src="./resources/img/chat_exitChat.png" class="chat_menu_img" id="exitChat" style="cursor: pointer;">
								<p style="text-align: center; width:400px">에약어 추가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대화방 나가기</p>
							</div>
							<div class="chat_menu back">
							</div>
						</div>
					</div>		
				<div class="comment">
					<input type="text" class="writeComment" id="writeComment" name="writeComment" placeholder="채팅 입력하세요" onkeypress="enter(event, this.value)"/>
					<button class="enter">입력</button>
				</div>
			</div> 
		</div>
	</div> 
</body>
</html>