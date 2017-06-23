
 $(function(){
	 
	   $(document).on("click", ".inputHash", function(){
	       var index = $(this).index();
	       $('.post_hashBox').find("div").eq(index).remove();
	   });
	 
	 $('.addIssue_addBtn').click(function(){
	      
	      var s = $(".post_hashBox").contents().find('span');
	        $("input[name=hashtag]").val(s.text());
	        // post방식으로 게시글 작성
	      $("form").attr("action", "createIssue");
	      $("form").attr("method", "post");
	      $("form").submit();
	   });
	 
	 
	 
    function readURL(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();  // 파일을 읽기위한 FileReader 객체 생성
            reader.onload = function(e) {   // 파일 읽기를 성공했을 때 호출되는 이벤트 핸들러
                var img = new Image();      // 이미지 태그 생성
                img.src = e.target.result;  // 이미지 태그 src 속성에 file내용을 지정
                
                img.width = $(".addIssue_fileBox label").width();
                img.onload = function(){
                    console.log(img.height);
                    $('.addIssue_fileBox').height(img.height);
                };
                
                $('.addIssue_img').html('');
                $('.addIssue_img').append(img);
            }
            reader.readAsDataURL(input.files[0]);   // file내용을 읽어 dataURL 형식의 문자열로 저장
        }
    }
    $('#addIssue_ImgUpload').change(function(){   // file양식으로 이미지를 선택되었을 때 처리
        readURL(this);
    });

    
    $('#addIssue_addBtn').click(function(){
    		alert("거리테스트");
    		alert($('#result2').val());
    		alert($('#result3').val());
    		alert($('.bangung').val());
    });
    
    
    $('#addBtn').click(function(){
    		alert("jstest");
    		location.href="push";
    	
    });
 });
 
 
 
