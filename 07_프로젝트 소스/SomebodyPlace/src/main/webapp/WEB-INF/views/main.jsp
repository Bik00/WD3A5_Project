<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main_content">
	<div id="main_slide">
     <img src="./resources/img/somebodyfamily.jpg">
     <button class="slideBtn slideBtn-left">&#10094;</button>
     <button class="slideBtn slideBtn-right">&#10095;</button>
 </div><br>
 
 <div class="main_searchDiv">
   <select>
        <option>상품명</option>
        <option>해시태그</option>
        <option>글쓴이</option>                     
   </select>
                      
	<input type="text" class="main_searchForm" >
	<button>검색</button>
</div>
 
 
 
 <div id="main_product">
 
    <c:if test="${Place!= null }">         
        		<c:forEach items="${Place}" var="list">
						<div id="place_box">
								   <div id="place_info">
			           					플레이스명:
									<b>${list.place_name}</b><br>
								    </div>
								    <div id="place_img">
							            <img src="./resources/img/${list.place_logo}" class="place_logo2"><br>
							        </div>
						</div>
				</c:forEach>
	</c:if>
 
  <c:if test="${BigProduct!= null }">         
        		<c:forEach items="${BigProduct}" var="p">
			<div id="lodging_box">
               <div id="lodging_img">
                  <img src="./resources/img/${p.product_img}">
               </div>
               <div id="lodging_info">
     			<div><h3><b>${p.product_name}</b></h3></div>
    			<div>${p.product_explanation}</div>
				<div>${p.product_price}원</div>

               </div>
            </div>
				</c:forEach>
	</c:if>

	<c:forEach items="${Product}" var="p">
		<div class="product_box" data="${p.product_code}">
			<div class="product_img">
				<img src="./resources/img/${p.product_img}">
			</div>
			<div class="product_info">
				<div><h3><b>${p.product_name}</b></h3></div>
				<div>${p.product_explanation}</div>
				<div>${p.product_price}원</div>
			</div>
		</div>
	</c:forEach>
	
	


		<!-- <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div>
     <div class="product_box">
         <div class="product_img"><h1>이미지</h1></div>
         <div class="product_info">
             <div>상품명</div>
             <div>상품 설명</div>
             <div>가격</div>
         </div>
     </div> -->
 </div>
 <div class="float_clear"></div>
</div>