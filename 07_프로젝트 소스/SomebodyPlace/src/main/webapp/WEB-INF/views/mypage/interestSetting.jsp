<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

  
   <h1 class="interest_title">���ɻ缳��</h1><br><br>
  

    <div id="SettingDiv">
            <h3>���� ���ɻ�</h3>
            <input type="text" placeholder="#���л���#20�롡#��Ʈ�ϡ�#��ȭ " class="tegname" name="">
            <h4>�±�<h4>
            <input type="text" placeholder="#�߰����±� �Է�" class="tegname"><br><br>
            <input type="button"  class="SettingFinish_btn" value="�����Ϸ�" onclick="success()"><br>
           
     </div>
  
</body>
<script>
    function success() {
        alert("���� �Ϸ�");
       window.location = "main.html";
    }
</script>
