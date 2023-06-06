<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h2>会員情報登録完了</h2>

<%String id = (String) request.getAttribute("member_id");%>

会員番号：<%= id %><br>

<br>
<a href="/MemberInformation/views/index.jsp" >トップ</a>

<%@ include file="../footer.html" %>
