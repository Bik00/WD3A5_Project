<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Google Map 의 클릭한 좌표값을 알아내자</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta charset="utf-8">
<script type="text/javascript"
   src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

<script async defer
   src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-f8h17-0IA4BncRf-Npxkwe_NS6PVh0A&callback=initMap">
   
</script>

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

      $('#roadAddrPart1').val(roadAddrPart1);
      //document.form.roadAddrPart1.value = roadAddrPart1;
      //주소를 검색 완료하자마자 지도에 표시 
      loshow();

   }

   //input창에 검색한 주소로 그 주소의 위도, 경도 값을 구해  지도에 표시하는 함수 
   function loshow() {
      var t = $('#roadAddrPart1').val();
      alert(t);
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

            var c = "(" + a + "," + b + ")";

            placeMarker(c);
            myMap(a, b);
            initMap(a, b);
            function initMap(a, b) {
               map = new google.maps.Map(document
                     .getElementById('map_canvas'), {
                  zoom : 16,
                  center : new google.maps.LatLng(a, b),
                  mapTypeId : 'roadmap'
               });

               var iconBase = './resources/img/';
               var icons = {
                  parking : {
                     icon : iconBase + 'man-standing-with-arms-up.png'
                  },
                  library : {
                     icon : iconBase + 'library_maps.png'
                  },
                  info : {
                     icon : iconBase + 'info-i_maps.png'
                  }
               };

               function addMarker(feature) {
                  var marker = new google.maps.Marker({
                     position : feature.position,
                     icon : icons[feature.type].icon,
                     map : map
                  });
               }

               var features = [ {
                  position : new google.maps.LatLng(a, b),
                  type : 'parking'
               } ];

               for (var i = 0, feature; feature = features[i]; i++) {
                  addMarker(feature);
               }
            }

            function myMap(test, test2) {

               var amsterdam = new google.maps.LatLng(test, test2);

               var mapCanvas = document.getElementById("map_canvas");
               var mapOptions = {
                  center : amsterdam,
                  zoom : 15
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

 <script>
//    window.onload = function() {
//       var birth = document.getElementsByClassName('inputBirth');
//       var age = document.getElementsByClassName('inputAge');
//       var btn = document.getElementsByClassName('changeBtn');
//       btn.onclick = function() {
//          var inputValue = birth.value;
//          age.innerText = inputValue;
//       };       
//    };


       $(document).ready(function(memberAge) {
         $('.changeBtn').click(function(){
            
             var date = new Date();
             var year = date.getFullYear();
             var month = (date.getMonth() + 1);
             var day = date.getDate();       
             if (month < 10) month = '0' + month;
             if (day < 10) day = '0' + day;
             var monthDay = month + day;
             
             var birthYear = $('.inputBirth').val().substr(0,4); 
             
             console.log(birthYear); // 1996
             
             var birthMonth = $('.inputBirth').val().substr(4,4);
             
             console.log(birthMonth); // 0831
                
             var age = monthDay < birthMonth ? year - birthYear - 1 : year - birthYear;
   
             console.log(age);
             
               $(".inputAge").val(age); // 확인 버튼을 누르면 age input에         
      });
    });
 </script>

<script type="text/javascript">
   //input창에 검색한 주소로 그 주소의 위도, 경도 값을 구해  지도에 표시하는 함수 

   var map;
   function initialize() {
      var myLatlng = new google.maps.LatLng(35.896194586026304,
            128.62185716629028);
      var myOptions = {
         zoom : 15,
         center : myLatlng,
         mapTypeId : google.maps.MapTypeId.ROADMAP
      }
      map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);
      //지도클릭했을 때 이벤트
      google.maps.event.addListener(map, 'click', function(event) {

         //마커 생성 함수    
         placeMarker(event.latLng);

         //input에 클릯한위치의 경도 위도를 한글 주소로 바꿔 입력  
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
                  $('#roadAddrPart1').val(
                        data.results[0].formatted_address);

               }
            });

         });

         // 인포윈도우의 위치를 클릭한 곳으로 변경한다.
         $(function() {

            var test = "" + event.latLng + "";

            $('#result').val(test);

            var afterStr = test.split(",");
            var afterStr2 = afterStr[0].split("(");
            var afterStr3 = afterStr[1].split(")");

            $('#result2').val(afterStr2[1]);
            $('#result3').val($.trim(afterStr3[0]));
         });

      });
      //클릭 했을때 이벤트 끝
      //인포윈도우의 생성
      var infowindow = new google.maps.InfoWindow({
         content : '<br><b>주활동지역 을 클릭한후</b>가입해주세요',
         size : new google.maps.Size(50, 50),
         position : myLatlng
      });
      infowindow.open(map);
   } // function initialize() 함수 끝

   // 마커 생성 합수
   function placeMarker(location) {
      var clickedLocation = new google.maps.LatLng(location);
      var marker = new google.maps.Marker({
         position : location,
         map : map
      });
      map.setCenter(location);
   }
</script>
<script>
   function resettest() {
      alert("sd");
      $('#roadAddrPart1').val("");
      var map = new google.maps.Map(document.getElementById('map_canvas'), {
         zoom : 13,
         center : {
            lat : 35.89412604821816,
            lng : 128.61610852181911
         },
         mapTypeId : 'terrain'
      });
   }
</script>
</head>


<body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0"
   onload="initialize();">

   <div class="joinForm">
      <h1 class="joinForm_title">회원 가입</h1>
      <br>
      <br>

      <form class="form-horizontal " method="post" style="width: 100%; margin: auto;">
         <div class="form-group">
            <label class="col-sm-2 control-label">이메일:</label>
            <div class="col-sm-9">
               <input type="email" class="form-control" id="email" name="email">
            </div>
         </div>
         <div class="form-group">
            <label class="col-sm-2 control-label">패스워드:</label>
            <div class="col-sm-9">
               <input type="password" class="form-control" id="pw" name="pw">
            </div>
         </div>
         <div class="form-group">
            <label class="col-sm-2 control-label">닉네임:</label>
            <div class="col-sm-9">
               <input type="text" class="form-control" id="nickname"
                  name="nickname">
            </div>
         </div>
              <div class="form-group">
                <label class="col-sm-2 control-label joinFormText">성별:</label>
                <div class="col-sm-9">
                        남 <input type="radio" class=" joinInput" id="gender" name="gender" value="m">
                       여 <input type="radio" class=" joinInput" id="gender" name="gender" value="f">
                </div>
            </div> 
         
         
     <div class="form-group">
                <label class="col-sm-2 control-label joinFormText">생년월일:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control joinInput inputBirth" id="birth" name="birth" 
                    maxlength="8" placeholder="생년월일 ******** 8자리를 입력하세요." >
                    <input type="button" class="form-control changeBtn" value="나이확인"></button>
                </div>
            </div>          
            <div class="form-group">
                <label class="col-sm-2 control-label joinFormText">나이:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control joinInput inputAge" id="age" name="age" maxlength="8" >
                </div>
            </div>  


         <label class="col-sm-2 control-label">주활동지역</label>
   </div>

   <input type="text" style="width: 500px;" id="roadAddrPart1"
      name="address" />
   <br>
   <input type="button" onClick="goPopup();" value="주소검색" />
   <input type="button" onclick="resettest();" value="초기화" />
   <div id="map_canvas" style="width: 100%; height: 40%;"></div>

   <div>
      <input type="hidden" class="form-control" id="result2" name="lng"
         value="" style="width: 50%;"> <input type="hidden"
         class="form-control" id="result3" name="lat" value=""
         style="width: 50%;">
   </div>

   <div class="">
      <button type="submit" id="joinBtn" class="btn btn-default">회원가입</button>
      <!--  onclick="a()"><a href="loginForm.html">회원 가입</a></button> -->
      <button class="btn btn-default">
         <a href="main.html">가입 취소</a>
      </button>
   </div>
   </form>


</body>
</html>