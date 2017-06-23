<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<script type="text/javascript" src="<c:url value="./resources/js/sockjs.js"/>" ></script>
<script language="javascript">
	// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
	//document.domain = "abc.go.kr";

	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/somebodyplace/jusoPopup", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadAddrPart1) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.

		
		document.form.roadAddrPart1.value = roadAddrPart1;
	
		//주소를 검색 완료하자마자 지도에 표시 
		loshow();

	}

	//input창에 검색한 주소로 그 주소의 위도, 경도 값을 구해  지도에 표시하는 함수 
	function loshow() {
		var t = $('#roadAddrPart1').val();
	
		var key = 'AIzaSyC-f8h17-0IA4BncRf-Npxkwe_NS6PVh0A';

		$.ajax({
			url : "https://maps.googleapis.com/maps/api/geocode/json?",
			data : {
				address : t,
				key : key
			},
			dataType : 'json',
			Type : "GET",
			success : function(data) {

				var a = data.results[0].geometry.viewport.northeast.lat;
				var b = data.results[0].geometry.viewport.northeast.lng;

				$('#result2').val(a);
				$('#result3').val(b);

				myMap(a, b);

				function myMap(test, test2) {

					var amsterdam = new google.maps.LatLng(test, test2);

					var mapCanvas = document.getElementById("map");
					var mapOptions = {
						center : amsterdam,
						zoom : 13
					};
					var map = new google.maps.Map(mapCanvas, mapOptions);

					var myCity = new google.maps.Circle({
						center : amsterdam,
						radius : 300,
						strokeColor : "#0000FF",
						strokeOpacity : 0.8,
						strokeWeight : 2,
						fillColor : "#0000FF",
						fillOpacity : 0.4
					});

					myCity.setMap(map);
				}

			},
			error : function() {
				alert('오류가 발생');
				isLogin = false;
			}
		});

	}
</script>




<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Circles</title>

</head>
<body>
	<h1 class="addIssue_title">이슈 등록</h1>
	<br>
	<form id="form" name="form">

		<input type="hidden" value="${member_code}" name="member_code">
		<div class="form-group">
			<label>내용</label><br>
			<textarea class="form-control" rows="15" name="Issue_content">
		        
		        
		        </textarea>
			<br> <br> <label> 이미지 등록</label> <br>
			<div class="addIssue_fileBox">
				<label for="addIssue_ImgUpload" class="addIssue_img">
					<p>이곳을 클릭한 후 이미지를 등록하세요</p>
				</label> <input type=file id="addIssue_ImgUpload" class="addIssue_ImgUpload"
					name="issue_img">

			</div>
			<br>
			<br>
			<br> <label>보낼위치</label><br>

			<table>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" style="width: 500px;"
						id="roadAddrPart1" name="address" /></td>
					<td><input type="button" onClick="goPopup();" value="주소검색" /></td>

				</tr>
			</table>


		</div>


		<input type="hidden" id="result2" value="" name="Lat" style="width: 50%;"> 
		<input type="hidden" id="result3" value="" name="Lng" style="width: 50%;"><br> 
		
		<label>반경설정</label><br>
		
		<input type="text" class="bangung">미터
		<input type="range" id="seek" value="0" max="5000" name="Radius" onchange="ban(this.value)" /> 0km<br>
		
		<label>해시태그</label><br>

		
		<input type="hidden" name="hashtag">
		<div class="post_hashBox" ></div>
		<input type="text" class="post_hash form-control" placeholder="해시태그 입력 후 엔터를 치세요">

	</form>
	
	
	


	<div id="map"></div>
	<br>
	<button class="addIssue_addBtn btn-default addBtn">이슈등록</button>
		<input type="button" class="btn btn-default addBtn" onclick="initMap();" value="초기화" />
	<input type="button" class="btn btn-default cancelBtn" id="cancelBtn"
		value="취소하기" />





	<script>
		//초기화버튼 누를시 실행 
		function initMap() { //initMap여는괄로 
			// Create the map.
			$('#roadAddrPart1').val("");
			$('.bangung').val("");
			$('#seek').val(0);
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 13,
				center : {
					lat : 35.89412604821816,
					lng : 128.61610852181911
				},
				mapTypeId : 'terrain'
			});

			//지도를 클릭했을떄 이벤트 발생 
			google.maps.event
					.addListener(
							map,
							'click',
							function(event) {

								
								placeMarker(event.latLng);

								//클릭시 위도 경도를 이용해 한글 주소로 바꾸는 ajax 요청 	
								$(function() {

									var test = "" + event.latLng + "";

									$('#result').val(test);

									var afterStr = test.split(",");

									//위도경도를 위도 경도로 짤라줌 
									var afterStr2 = afterStr[0].split("(");
									var afterStr3 = afterStr[1].split(")");

									$('#result2').val(afterStr2[1]);

									$('#result3').val($.trim(afterStr3[0]));

									var test = afterStr2[1];
									var test2 = $.trim(afterStr3[0]);
									var seek = $('#seek').val();

									//위도 경도 따로 되있는 값을 합쳐줌 위도,경도 이런식으로 
									var latlng = test + "," + test2;

									var key = 'AIzaSyC-f8h17-0IA4BncRf-Npxkwe_NS6PVh0A';

									$.ajax({
												url : "https://maps.googleapis.com/maps/api/geocode/json?",
												data : {
													latlng : latlng,
													key : key
												},
												dataType : 'json',
												Type : "GET",
												success : function(data) {

													//주소 input창에 반환된 data값을 넣어줌 
													//data.results[0].formatted_address= 대구 복현동 복현로 ....임 
													$('#roadAddrPart1')
															.val(
																	data.results[0].formatted_address);

												}
											});

								
									//test,test2,seek 를 넣고 다시 실행 
									myMap(test, test2, seek);

								});

								//마커생성함수 
								function placeMarker(location) {
									var clickedLocation = new google.maps.LatLng(
											location);
									var marker = new google.maps.Marker({
										position : location,
										map : map
									});
									map.setCenter(location);
								}

								function myMap(test, test2, v) {

									v = parseInt(v);

									var amsterdam = new google.maps.LatLng(
											test, test2);

									var mapCanvas = document
											.getElementById("map");
									var mapOptions = {
										center : amsterdam,
										zoom : 13
									};
									var map = new google.maps.Map(mapCanvas,
											mapOptions);

									var myCity = new google.maps.Circle({
										center : amsterdam,
										radius : 300,
										strokeColor : "#0000FF",
										strokeOpacity : 0.8,
										strokeWeight : 2,
										fillColor : "#0000FF",
										fillOpacity : 0.4
									});

									myCity.radius = v;
									myCity.setMap(map);
								}
							});

		} //initmap()닫는괄호 

		//막대 반경이 변경될때마다 실행 
		function ban(v) {
			var test = $('#result2').val();
			var test2 = $('#result3').val();

			//input창에 바뀐 반경을 미터로표시 
			$('.bangung').val(v);

			//위도,경도, 바뀐반경으로 다시 myMap 함수 호출--------myMap함수는 위도,경도,반경 값으로 반경을 출력해주는 함수임!!!!! 
			myMap(test, test2, v);

			function myMap(test, test2, v) {

				v = parseInt(v);

				var amsterdam = new google.maps.LatLng(test, test2);

				var mapCanvas = document.getElementById("map");
				var mapOptions = {
					center : amsterdam,
					zoom : 13
				};
				var map = new google.maps.Map(mapCanvas, mapOptions);

				var myCity = new google.maps.Circle({
					center : amsterdam,
					radius : 300,
					strokeColor : "#0000FF",
					strokeOpacity : 0.8,
					strokeWeight : 2,
					fillColor : "#0000FF",
					fillOpacity : 0.4
				});

				myCity.radius = v;
				myCity.setMap(map);
			}
		}
	</script>


	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-f8h17-0IA4BncRf-Npxkwe_NS6PVh0A&callback=initMap">
		
	</script>
</body>
</html>