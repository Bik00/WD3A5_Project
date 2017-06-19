<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <form class="addForm" method="post">
            <h2>사업자등록번호 추가</h2><br>
        <div class="form-group">
               <label>사업자 등록번호 입력</label>
                <div class="form-group business_form">
                    <input type="text" class="form-control business_text" id="business_1" name="business_1">
                    <label class="busi">-</label>
                    <input type="text" class="form-control business_text" id="business_2" name="business_2">
                    <label class="busi">-</label>
                    <input type="text" class="form-control business_text" id="business_3" name="business_3">
                </div>
            <br>
        </div>
           
            <br>
            <br>

        <input type="button" class="btn btn-default addBtn" onclick="self.location='main.html'" id="addBtn" value="등록하기" />
        <input type="button" class="btn btn-default cancelBtn" id="cancelBtn" onclick="self.location='placemanager.html'" value="취소하기" />
    </form>
</body>
</html>