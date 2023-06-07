<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<%--削除成功--%>
<%String success_msg = (String)request.getAttribute("success");%>
<% if (success_msg != null) {%>
	<h2>会員情報削除完了</h2>
    <%= success_msg %><br>
<%} %>

<%--削除失敗--%>
<%String failure_msg = (String)request.getAttribute("failure");%>
<% if (failure_msg != null) {%>
	<h2>会員情報削除失敗</h2>
    <%= failure_msg %><br>
<%} %>

<br>
<a href="/MemberInformation/views/index.jsp" >トップ</a>

<%@ include file="../footer.html" %>
