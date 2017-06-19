<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="place">
    <div class="place_title">
    	<img src="./resources/img/${place_logo}" class="place_logo">
    	<a href="placeHome?member_code=${member_code}&member_email=${member_email}">
    		<h1 class="place_placename">${place_name}</h1>
    	</a>
    </div>
    <c:if test="${placePage != null }">         
        	<jsp:include page="${placePage}"></jsp:include>
	</c:if>
</div>