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
            <h2>플레이스 수정</h2><br>
        <div class="form-group">
               <label>플레이스명</label><input type="text" class="form-control" /><br>
        </div>
                <label>카테고리</label><br>
                <select class="form-control">
                    <option>숙박</option>
                    <option>2</option>
                    <option>3</option>
                </select><br>
                <select class="form-control">
                    <option>모텔</option>
                    <option>2</option>
                    <option>3</option>
                </select><br>

        <input type="button" class="btn btn-default addBtn" onclick="self.location='main.html'" id="addBtn" value="수정하기" />
        <input type="button" class="btn btn-default cancelBtn" id="cancelBtn" onclick="self.location='placemanager.html'" value="취소하기" />
    </form>

</body>
</html>