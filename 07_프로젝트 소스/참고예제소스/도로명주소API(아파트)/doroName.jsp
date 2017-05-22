<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도로명 주소 팝업용 API</title>
<body>
	<!-- 주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 class를 부여한다 -->
	<div class="container">
		<form class="form-inline">
			<div class="form-group">
				<label>우편번호 </label> <input type="text" size="100px" name=""
					class="postcodify_postcode5" value="" /> <br /> <label>도로명주소
				</label> <input type="text" size="100px" name="" class="postcodify_address"
					value="" /> <br /> <label>상세주소</label> <input type="text"
					size="100px" name="" class="postcodify_details" value="" /> <br />
				<label>참고항목 </label><input type="text" size="100px" name=""
					class="postcodify_extra_info" value="" /> <br />

			</div>
		</form>
		<button id="postcodify_search_button" type="submit"
			class="btn btn-default">검색</button>

		<!-- jQuery와 Postcodify를 로딩한다 -->
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
<script>
	$(function() {
		$("#postcodify_search_button").postcodifyPopUp();
	});
</script>
</html>