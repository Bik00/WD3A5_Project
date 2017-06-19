<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

  
   <h1 class="interest_title">관심사설정</h1><br><br>
  

    <div id="SettingDiv">
            <h3>현재 관심사</h3>
            <input type="text" placeholder="#대학생　#20대　#노트북　#영화 " class="tegname" name="">
            <h4>태그<h4>
            <input type="text" placeholder="#추가할태그 입력" class="tegname"><br><br>
            <input type="button"  class="SettingFinish_btn" value="설정완료" onclick="success()"><br>
           
     </div>
  
</body>
<script>
    function success() {
        alert("설정 완료");
       window.location = "main.html";
    }
</script>
