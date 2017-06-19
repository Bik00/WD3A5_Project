<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 플레이스 관리 내용 -->

        <div class="placemanager_content">
            <!-- 정산 내역 -->
            <div class="placemanager_budget">
                <div class="placemanager_budget_title">
                    통계 및 정산 현황
                </div>
                <div class="placemanager_budget_content">
                    <ul>
                        <li><h4>이번달 팔린 금액 - 20000원</h4></li>
                        <li><h4>이번달 정산 금액 - 18000원 </h4></li>
                    </ul>
                    <button class="btn btn-default budget_more">상세 보기</button>
                </div>
                <div class="placemanager_budget_more">
                </div>
            </div>

            <!-- 신청 내역 -->
            <div class="placemanager_request">
                <div class="placemanager_request_title">
                    신청 내역 - 4건
                </div>
                <div class="placemanager_request_content">
                    <table class="table table-hover">
                        <thead>
                            <tr class="active">
                                <th>고객 이름</th>
                                <th>상품 명</th>
                                <th>수량</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>초코</td>
                                <td>라운드티</td>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>나비</td>
                                <td>청바지</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>키위</td>
                                <td>장갑</td>
                                <td>3</td>
                            </tr>
                            <tr>
                                <td>보리</td>
                                <td>구두</td>
                                <td>1</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="placemanager_request_more">
                    <button class="btn btn-default request_more">상세 보기</button>
                </div>
            </div>

            <!-- 상품 내역 -->
            <div class="placemanager_product">
                <div class="placemanager_product_title">
                    상품 현황
                </div>
                <div class="placemanager_product_content">
                    <ul>
                        <li><h4>등록된 상품 수 - 17개</h4></li>
                        <li><h4>등록된 후기 수 - 6개 </h4></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>