<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


       
        <form class="form-horizontal">
            <h1 id="modifyForm_title">ȸ�� ���� ����</h1> <br><br>
            <h6>�⺻����</h6>
            <table id="modifyForm_table" class="table table-bordered">
                <tr>
                    <td>���̵�</td>
                    <td>leeyooseon96</td>
                </tr>
                <tr>
                    <td>�̸�</td>
                    <td>������</td>
                </tr>
                <tr>
                    <td>�г���</td>
                    <td>������</td>
                </tr>
                <tr>
                    <td>�����й�ȣ</td>
                    <td><input type="password" class="form-control" id="nowPw"> </td>
                </tr>
                <tr>
                    <td>�����Һ�й�ȣ</td>
                    <td><input type="password" class="form-control" id="modifyPw"> </td>
                </tr>
                <tr>
                    <td>�����Һ�й�ȣȮ��</td>
                    <td><input type="password" class="form-control" id="reModifyPw"> </td>
                </tr>
                <tr>
                    <td>�ּ�</td>
                     <td><input type="text" class="form-control" 
                            id="address" value="�뱸�� �޼��� ������ 241 103�� 203ȣ"> </td>
                </tr>
                <tr>
                    <td>�޴���ȭ</td>
                    <td>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">�޴���ȭ: </label>
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

             <button type="submit" class="modifyForm_btn">ȸ����������</button>
             <button type="submit" class="modifyForm_btn">���</button>
             <button type="submit" class="modifyForm_btn">ȸ��Ż��</button>
         </form>
 