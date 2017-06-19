$(function(){
	// 메인카테고리 변경 시 세부카테고리 값 변경
	$('.mcate').change(function(){
		// 선택된 메인카테고리의 코드를 가져옴
		var mcateSelected = $('.mcate option:selected').val();
		var mcode = [];
		var name = [];
		var dcode = [];
		// 세부카테고리의 메인카테고리 코드와 세부카테고리 이름을 받아옴
		$(".dcateList").each(function(index, elem){	
			mcode[index] = elem.value;
			name[index] = elem.name;
			dcode[index] = elem.getAttribute("data");
		});
		$(".dcate").html("");	// 세부카테고리 출력을 지움
		// 선택된 메인카테고리의 세부카테고리를 출력
		for(var i=0; i<mcode.length; i++){
			if(mcode[i] == mcateSelected) {
				var str = "<option value="+ dcode[i] +" name="+ mcode[i] +">" +name[i]+ "</option>";
				$(".dcate").append(str);
			}
		}
		$(".dcate option:first").attr("selected", "selected");
	});
	$('.bcate').change(function(){
		console.log($('.bcate option:selected').val());
	});
	// 게시글 등록하기
	$('.RegisterBoxBtn').click(function(){
		// 선택한 유형 데이터
		var typeStr = "";
		$("input[type=checkbox]:checked").each(function(){
			var type = $(this).val();
			typeStr += type + ",";
		});
		typeStr = typeStr.substring(0,typeStr.length-1);
		var str = "<input type='hidden' value='" +typeStr+ "' name='type'>";
		$('form').append(str);
		// 선택된 게시판 코드
		var boardcode = $('.bcate option:selected').val();
		var str = "<input type='hidden' value='" + boardcode + "' name='board_code'>";
		$("form").append(str);
		// 선택된 메인카테고리, 세부카테고리 값
		var dcatecode = $(".dcate option:selected").val();
		var mcatecode =$(".dcate option:selected").attr("name");
		var str = "<input type='hidden' value='"+mcatecode+"' name='mcate_code'>" +
					  "<input type='hidden' value='"+dcatecode+"' name='dcate_code'>" ;
		$("form").append(str);
		// 세부 옵션 크기
		for(var i = 0; i<detailLength.length; i++){
			var detailinput = "<input type='hidden' value='"+detailLength[i]+"' name='detailLength'>";
			$("form").append(detailinput);
		}
		// 해시태그 내용
		var s = $(".post_hashBox").contents().find('span');
        $("input[name=hashtag]").val(s.text());
        // post방식으로 게시글 작성
		$("form").attr("action", "addPost");
		$("form").attr("method", "post");
		$("form").submit();
	});
	// 등록한 해시태그 클릭시 삭제
	$(document).on("click", ".inputHash", function(){
	    var index = $(this).index();
	    $('.post_hashBox').find("div").eq(index).remove();
	});
	// 해시태그 입력
	$('.post_hash').keypress(function(e){
	    if(e.keyCode == 32 || e.keyCode == 13) {
	        var hashtxt = '<div class="inputHash">&nbsp;<span>#' + $('.post_hash').val() + '</span>'+
	                        '<p class="arrow_box">클릭하면 삭제됩니다.</p></div>';
	        $('.post_hashBox').append(hashtxt);
	        $('.post_hash').val("");
	    }
	});
	// 게시글 등록 창 닫기 버튼
	$('.postRegisterForm_delBtn').click(function(){
	    $('.postRegisterBox').css('display','none'); 
	});
	// 게시글 등록하기 버튼 
	$('.post_register_btn').click(function(event){
		event.preventDefault();
	    $('.postRegisterBox').css('display','block');
	});
    /* 에디터 : 이미지 박스 추가 */
    $(document).on("click", ".imgbox_plus", function(){
        var imgbox =  '<li class="drag_imgbox">' +
                        '<span class="imgbox_plus"><p>+</p></span>' +
                        '<label for="imgbox_upload" class="imgbox_label">' +
                            '<p>이곳을 클릭한 후 이미지를 등록하세요</p>' +
                        '</label>' +
                        '<span class="imgbox_minus"><p>-</p></span>'+
                        '<input type=file id="imgbox_upload" class="imgbox_img" name="content">'+
                    '</li>';
        $(this).parent().after(imgbox);
    });
    // 에디터 : 이미지 박스 제거
    $(document).on("click", ".imgbox_minus", function(){
        $(this).parent().remove();
    });
    /* 에디터 : 이미지 박스 추가 버튼 표시/제거 */
    $(document).on("mouseover",".drag_imgbox", function(){
         $(this).find($(".imgbox_plus")).css("visibility", "visible");
    });
    $(document).on("mouseout",".drag_imgbox", function(){
         $(this).find($(".imgbox_plus")).css("visibility", "hidden");
    });
    /* 에디터 : 이미지 박스 삭제 버튼 표시/제거 */
    $(document).on("mouseover",".drag_imgbox", function(){
         if($(this)[0] == $('.drag_imgbox').first()[0]){}
         else{$(this).find($(".imgbox_minus")).css("visibility", "visible");}
    });
    $(document).on("mouseout",".drag_imgbox", function(){
         $(this).find($(".imgbox_minus")).css("visibility", "hidden");
    });
    
    /* 에디터 이미지 업로드 */
     function editorReadURL(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();  // 파일을 읽기위한 FileReader 객체 생성
            reader.onload = function(e) {   // 파일 읽기를 성공했을 때 호출되는 이벤트 핸들러
                var img = new Image();      // 이미지 태그 생성
                img.src = e.target.result;  // 이미지 태그 src 속성에 file내용을 지정
        
                editorLoadImg(img);
            }
            reader.readAsDataURL(input.files[0]);   // file내용을 읽어 dataURL 형식의 문자열로 저장
        }
    }
    var imgindex;
    // 클릭한 이미지 라벨 인덱스 찾기
    $(document).on('click', '.imgbox_label', function(){
        imgindex = $(this).parent().index();
    });
    // 이미지 붙이기
    function editorLoadImg(img){
        var imgbox = $('li:eq(' + imgindex + ')').children('.imgbox_label');
        
        imgbox.width(img.width);
        img.onload = function(){
            imgbox.height(img.height);
        };
        
        imgbox.html('');
        imgbox.append(img);
    }
    $(document).on('change','.imgbox_img', function(){   // file양식으로 이미지를 선택되었을 때 처리
        editorReadURL(this);
    });
    // 에디터 : textarea 박스 추가 버튼 표시/제거
    $(document).on("mouseover",".drag_txtbox", function(){
         $(this).find($(".txtbox_plus")).css("visibility", "visible");
    });
    $(document).on("mouseout",".drag_txtbox", function(){
         $(this).find($(".txtbox_plus")).css("visibility", "hidden");
    });
    // 에디터 : textarea 박스 삭제 버튼 표시/제거
    $(document).on("mouseover",".drag_txtbox", function(){
         if($(this)[0] == $('.drag_txtbox').first()[0]){}
         else{$(this).find($(".txtbox_minus")).css("visibility", "visible");}
    });
    $(document).on("mouseout",".drag_txtbox", function(){
         $(this).find($(".txtbox_minus")).css("visibility", "hidden");
    });
    // 에디터 : textarea 박스 추가
    $(document).on("click", ".txtbox_plus", function(){
        var txtbox =    '<li class="drag_txtbox">' +
                            '<span class="txtbox_plus"><p>+</p></span>' +
                            '<textarea class="autosize" name="content" placeholder="내용을 입력하세요."></textarea>' +
                            '<span class="txtbox_minus"><p>-</p></span>' +
                        '</li>';
        $(this).parent().after(txtbox);
    });
    // 에디터 : textarea 박스 제거
    $(document).on("click", ".txtbox_minus", function(){
        $(this).parent().remove();
    });
    // 에디터 : textarea 자동 크기조절
    $(document).on('keydown keyup', "textarea.autosize",function () {
        $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
    });

    // 에디터 : 텍스트 입력박스 드래그
    $( "ul.drag_box" ).sortable();
    $( "ul.drag_box, .drag_txtbox" ).disableSelection();

    function readURL(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();  // 파일을 읽기위한 FileReader 객체 생성
            reader.onload = function(e) {   // 파일 읽기를 성공했을 때 호출되는 이벤트 핸들러
                var img = new Image();      // 이미지 태그 생성
                img.src = e.target.result;  // 이미지 태그 src 속성에 file내용을 지정
                
                img.width = $(".post_fileBox label").width();
                img.onload = function(){
                    console.log(img.height);
                    $('.post_fileBox label').height(img.height);
                };
                
                $('.postForm_img').html('');
                $('.postForm_img').append(img);
            }
            reader.readAsDataURL(input.files[0]);   // file내용을 읽어 dataURL 형식의 문자열로 저장
        }
    }
    $('#postForm_ImgUpload').change(function(){   // file양식으로 이미지를 선택되었을 때 처리
        readURL(this);
    });
    var optionLength = 0;
    var detailLength = [];
    // 추가옵션박스 생성
    $(".postForm_optionBtn").click(function(){
        var optionBox = '<div class="postForm_optionBox form-inline">' +
                        '<span><input type="text" placeholder="추가옵션명" class="form-control" name="option_name">' +
                        '<span style="float:right" class="post_optionBox_del"><p>x</p></span></span><br>' +
                        '<input type="text" placeholder="추가옵션" class="form-control" name="detail_name">' +
                        '<span style="float:right"><input type="number" class="form-control" name="additional_price" min="0" value=0 step="10">원<span class="optionBox_plus"><p>+</p></span></span>' +
                        '</div>';
        $(".postForm_options").append(optionBox);
        	optionLength = $('input[name=option_name]').length;
        	console.log("o : " + optionLength);
	        detailLength[optionLength-1] = 1;
	        console.log("detailLength : " + detailLength[optionLength-1]);
    });
    // 추가옵션박스 삭제버튼 표시
    $(document).on("mouseover",".postForm_optionBox", function(){
         $(this).find($(".post_optionBox_del")).show();
         $(this).find($(".post_optionBox_del")).css("display", "inline-block");
    });
    // 추가옵션박스 삭제버튼 표시 없애기
    $(document).on("mouseout",".postForm_optionBox", function(){
         $(this).find($(".post_optionBox_del")).hide();
    });
    // 추가옵션박스 삭제
    $(document).on("click", ".post_optionBox_del", function(){
    	parentIndex = $(this).parent().parent().index();
    	$(this).parent().parent().remove();
        
    	optionLength = $('input[name=option_name]').length;
        console.log("o : " + optionLength);
        
        detailLength[parentIndex] = 0;
        console.log("parentIndex : " + parentIndex);
        console.log(detailLength[parentIndex]);
    });
    // 추가옵션 하나 추가
    $(document).on("click", ".optionBox_plus", function(){
        var option = '<input type="text" placeholder="추가옵션" class="form-control" name="detail_name">' +
                    '<span style="float:right"><input type="number" class="form-control" name="additional_price" min="0" value=0 step="10">원<span class="optionBox_minus"><p>-</p></span></span>' ;
        $(this).parent().parent().append(option);
       
        parentOption = $(this).parent().parent().index();
        detailnum = $(this).parent().parent().find('input[name=detail_name]').length;
        detailLength[parentOption] = detailnum;
        console.log(detailLength[parentOption]);
    });
    // 추가옵션 하나 삭제
    $(document).on("click", ".optionBox_minus", function(){
        $(this).parent().prev().remove();
        $(this).parent().remove();
        
        parentOption = $(this).parent().parent().index();
        detailnum = $(this).parent().parent().find('input[name=detail_name]').length;
        detailLength[parentOption] = detailnum;
        console.log(detailLength[parentOption]);
    });

});