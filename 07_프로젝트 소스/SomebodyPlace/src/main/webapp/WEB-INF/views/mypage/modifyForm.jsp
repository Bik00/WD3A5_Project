<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


       
        <form class="form-horizontal">
            <h1 id="modifyForm_title">회원 정보 수정</h1> <br><br>
            <h6>기본정보</h6>
            <table id="modifyForm_table" class="table table-bordered">
                <tr>
                    <td>아이디</td>
                    <td>leeyooseon96</td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td>이유선</td>
                </tr>
                <tr>
                    <td>닉네임</td>
                    <td>유도니</td>
                </tr>
                <tr>
                    <td>현재비밀번호</td>
                    <td><input type="password" class="form-control" id="nowPw"> </td>
                </tr>
                <tr>
                    <td>변경할비밀번호</td>
                    <td><input type="password" class="form-control" id="modifyPw"> </td>
                </tr>
                <tr>
                    <td>변경할비밀번호확인</td>
                    <td><input type="password" class="form-control" id="reModifyPw"> </td>
                </tr>
                <tr>
                    <td>주소</td>
                     <td><input type="text" class="form-control" 
                            id="address" value="대구시 달서구 선원로 241 103동 203호"> </td>
                </tr>
                <tr>
                    <td>휴대전화</td>
                    <td>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">휴대전화: </label>
                            <div class="col-xs-2">
                                 <input type="text" class="form-control" id="phone_1" value="010">
                            </div>
                            <div class="col-xs-1">-</div>
                            <div class="col-xs-3">
                                <input type="text" class="form-control" id="phone_2" value="9292">
                            </div>
                            <div class="col-xs-1">-</div>
                            <div class="col-xs-3">
                                <input type="text" class="form-control" id="phone_3" value="6218">
                            </div>
                         </div>
                    </td>
                </tr>        
            </table> <br><br>

             <button type="submit" class="modifyForm_btn">회원정보수정</button>
             <button type="submit" class="modifyForm_btn">취소</button>
             <button type="submit" class="modifyForm_btn">회원탈퇴</button>
         </form>
 