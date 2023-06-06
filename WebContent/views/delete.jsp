<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h2>会員情報削除</h2>

<%String message = (String)request.getAttribute("forward");%>
<% if (message != null) {%>
    <%= message %>
<%} %>

<%@ include file="../footer.html" %>