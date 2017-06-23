<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta charset="UTF-8">
<script type="text/javascript" src="<c:url value="./resources/js/sockjs.js"/>"></script>
<!-- <script src="./resources/js/issue.js"></script> -->
<title>Somebody Place</title>
</head>

<script>
	var count = 0;
	var member_code= "";
</script>

<body>


	<br>
	<br>
	<br>
	<br>
	
	<br>
	<div class="issue_searchDiv">
		<br>
		<form>
		
			
			 <input type="text" class="issue_searchForm" name="search_keyword" value="${search_keyword}">
			<button class="issue_searchbtn btn-default">검색</button>
			
		</form>
		
		<button class="btn btn-default issue_addIssuebtn">이슈쓰기</button>


	</div>

	<c:forEach items="${memberlist}" var="list">
			<%-- 	
					회원코드가　${list.member_code}<br>위도${list.member_lng}　　경도${list.member_lat}<br>
					이슈와의 거리 ${list.distance}M에게알림 <br> --%>
		<script>
	          
	$(document).ready(function(){
		
		
		updateData();
	});
	
		member_code +=","+${list.member_code};
			function updateData(){
				$.ajax({
					url:"http://106.249.38.80:8080/somebodyplace/pushServer",
					dataType:"jsonp",
					jsonp:"callback",
					Type : "GET",
					data : {
						member_code: member_code
					},
					 success : function(data) {
						 alert("맴버코드는"+data.member_code);
						 $('.push').val(data.member_code);
					 }
				});
				//setTimeout("updateData()",5000);
			}
		
		
			count++;
		</script>

	</c:forEach>
	
	   	<c:if test="${memberlist!= null }">         
        		<script>
						//document.write(count);
						alert(count+"명에게알림");
				</script>
			
		</c:if> 
	

<input type="hidden" class="push">

	<c:forEach items="${list}" var="issue">
		<div class="issue_box" data-issue="${issue.issue_code}">
			<div class="issue_top">

				<div class="issue_picture">
					<img src="./resources/img/프로필.PNG">
				</div>
				<div class="issue_profile">
					<span>${issue.member_nickname}</span>
					<button data-chatBtn="${issue.issue_code}" class="btn btn-default requestChat">1:1대화신청</button>
				
					<br>
					<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${issue.post_time}" />
					<br>
				</div>
		
		
				 <c:if test="${issue.member_code==member_code}">   
						<div class="issue_setting">
							<img src="./resources/img/settings.png" onclick="issue_setting()">
						</div>
			     </c:if>
			</div>

			<div class="issue_content">


				<h1>${issue.issue_content}</h1>
				<br> <img src="./resources/img/${issue.issue_img}"><br>
				*${issue.address}<br> *주변 ${issue.radius}m로 보낸 이슈 <br>
				*${issue.hashtag}<br>


			</div>
			<div class="reply_btn" data-replyBtn="1">
				<button class="btn btn-default replies" id="replies">댓글 보기</button>
				<div class="reply_count">댓글:3개</div>
			</div>
			<div class="reply_list" data-replyList="1">

				<!-- 첫번째 댓글 -->
				<div class="reply_comment">
					<div class="reply_picture">
						<img src="./resources/img/clerk2.png">
					</div>
					<div class="reply_profile">
						동글이<br> 2017-05-01 09:30
					</div>
					<button class="btn btn-default reply_setting">삭제하기</button>
					<div class="reply_text">
						<p>복현 오거리 위쪽에 올라가시면 산격 시장 근처에 병원 옆에 약국이 있어요.</p>
					</div>
				</div>
				<br>
				<!-- 두번째 댓글 -->

				<div class="reply_comment">
					<div class="reply_picture">
						<img src="./resources/img/clerk.png">
					</div>
					<div class="reply_profile">
						싱글남<br> 2017-05-01 09:30
					</div>
					<button class="btn btn-default reply_setting">삭제하기</button>
					<div class="reply_text">
						<p>아 그렇군요, 혹시 약국에 소화제도 같이 파나요?</p>
					</div>
				</div>
				<br>
				<!-- 세번째 댓글 -->

				<div class="reply_comment">
					<div class="reply_picture">
						<img src="./resources/img/clerk2.png">
					</div>
					<div class="reply_profile">
						동글이<br> 2017-05-01 09:30
					</div>
					<button class="btn btn-default reply_setting">삭제하기</button>
					<div class="reply_text">
						<p>음, 정확히는 잘 모르겠네요.</p>
					</div>
				</div>
				<br>

				<!-- 댓글 입력창 -->
				<div class="reply_textarea">
					<input type="textarea" class="reply_addText"
						placeholder="댓글을 입력하세요">
					<button class="btn btn-default reply_addTextBtn">댓글 달기</button>
				</div>

			</div>
		</div>
		<input type="hidden" value="${issue.issue_code}">
		

	</c:forEach>
		<div class="settingDiv">
			<input type="hidden" class="issue_code">
			<button>알림보내기</button><br>
			<button>수정</button><br>
			<button class="issue_deletebtn">삭제</button>
		</div>





</body>
</html>