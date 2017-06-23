$(function(){
	$(".placeAddBtn").click(function(){
		// 선택된 메인카테고리, 세부카테고리 값
		var dcatecode = $(".dcate option:selected").val();
		var mcatecode =$(".dcate option:selected").attr("name");
		var str = "<input type='hidden' value='"+mcatecode+"' name='mcate_code'>" +
					  "<input type='hidden' value='"+dcatecode+"' name='dcate_code'>" ;
		console.log("mcate : " + mcatecode);
		console.log("dcate : " + dcatecode);
		$("form").append(str);
		
		$("form").attr("action", "create");
		$("form").attr("method", "post");
		$("form").submit();
	});
	
    function readURL(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();  // 파일을 읽기위한 FileReader 객체 생성
            reader.onload = function(e) {   // 파일 읽기를 성공했을 때 호출되는 이벤트 핸들러
                var img = new Image();      // 이미지 태그 생성
                img.src = e.target.result;  // 이미지 태그 src 속성에 file내용을 지정
                
                img.width = $(".reserve_fileBox label").width();
                img.onload = function(){
                    console.log(img.height);
                    $('.reserve_fileBox').height(img.height);
                };
                
                $('.reserveForm_img').html('');
                $('.reserveForm_img').append(img);
            }
            reader.readAsDataURL(input.files[0]);   // file내용을 읽어 dataURL 형식의 문자열로 저장
        }
    }
    $('#reserveForm_ImgUpload').change(function(){   // file양식으로 이미지를 선택되었을 때 처리
        readURL(this);
    });
});
