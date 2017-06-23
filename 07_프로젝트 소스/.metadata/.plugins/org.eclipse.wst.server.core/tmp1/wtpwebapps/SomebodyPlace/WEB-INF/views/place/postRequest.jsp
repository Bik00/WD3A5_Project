<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <br><h2><b>신청 목록</b></h2><br>

<div class="post_default">

   
    <div class="post_type">
        <div class="post_title">${product.product_name}</div>
        <div class="post_description">${product.product_explanation}</div>
        <div class="post_price">가격 : ${product.product_price}원</div>
        <div class="post_options"> 
</div>
	<div class="postRequest_div">
        <table class="table payment_list">
                <tr>
                    <td class="payment_orderInfo">
                        <h2><b>주문자 정보</b></h2>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">이름:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="name">
                            </div>
                            <br>
                        </div>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">주소:</label>
                            <div class="col-sm-6 payment_address">
                                <input type="text" class="form-control" id="address">
                            </div>
                                <input type="button" value="주소 검색" class="btn btn-default col-sm-2" style="float:left">
                            <br>
                        </div>          
                        <br>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">휴대 전화: </label>
                            <div class="col-xs-2">
                                <input type="text" class="form-control" id="phone_1">
                            </div>
                            <div class="col-xs-1">-</div>
                            <div class="col-xs-2">
                                <input type="text" class="form-control" id="phone_2">
                            </div>
                            <div class="col-xs-1">-</div>
                            <div class="col-xs-2">
                                <input type="text" class="form-control" id="phone_3">
                            </div>
                        </div>
 
                    </td>
                    <td class="payment_priceInfo">
                        <div class="payment_total">
                        <table class="table price">
                            <tr>
                                <td><h4><b>총상품금액</b></h4></td>
                            </tr>
                            <tr>
                                <td><h3><b>18,800원</b></h3></td>
                            </tr>
                        </table>
                        </div>
                        <br>
                    </td>
                </tr>
            </table>
            <br>
            <br>
            <table class="payment_Option">
                <tr>
                    <td>
                        <h3><b>결제수단 : </b></h3>
                    </td>
                    <td><input type="radio" class="payment_Radiobox"> 신용 카드</td>
                    <td><input type="radio" class="payment_Radiobox"> 실시간 계좌이체</td>
                    <td><input type="radio" class="payment_Radiobox"> 휴대폰 결제</td>
                    <td><input type="radio" class="payment_Radiobox"> 현장 지불</td>
                    <td><input type="button" value="걸제하기" class="btn btn-default">&nbsp;&nbsp;&nbsp;<input type="button" value="취소하기" class="btn btn-default"></td>
                </tr>
            </table>
</div>
