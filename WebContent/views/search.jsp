<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h2>会員情報検索</h2>

<form action="/MemberInformation/jp.co.aforce.servlet/search" method="post">
<table border="1" style="border-collapse: collapse">
	<tr>
		<td width="100" height="40" align="center">会員番号</td>
		<td width="544">　<input type="text" name="member_id" required>　<input type="submit" name="serch" value="検索"></td>
	</tr>
</table>
</form>
<br>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--検索結果受け取る--%>
<%String id = (String) request.getAttribute("member_id");%>
<% if (id != null) {%>
	会員番号：<%= id %>の検索結果<br>
	<%String last_name = (String) request.getAttribute("last_name");%>
	<%String first_name = (String) request.getAttribute("first_name");%>
	<%String gender = (String) request.getAttribute("gender");%>
	<%String birth_year = (String) request.getAttribute("birth_year");%>
	<%String birth_month = (String) request.getAttribute("birth_month");%>
	<%String birth_day = (String) request.getAttribute("birth_day");%>
	<%String tel = (String) request.getAttribute("phone_number");%>
	<%String email = (String) request.getAttribute("email_address");%>
	<%String job = (String) request.getAttribute("job");%>
	
	<% request.setAttribute("id",id); %>
	<% request.setAttribute("last_name",last_name); %>
	<% request.setAttribute("first_name",first_name); %>
	<% request.setAttribute("gender",gender); %>
	<% request.setAttribute("birth_year",birth_year); %>
	<% request.setAttribute("birth_month",birth_month); %>
	<% request.setAttribute("birth_day",birth_day); %>
	<% request.setAttribute("tel",tel); %>
	<% request.setAttribute("email",email); %>
	<% request.setAttribute("job",job); %>
	
    <table border="1">
    	<tr>
    		<td width="130">会員番号</td>
    		<td width="400"><%= id %></td>
    		<td rowspan="7" align="center" width="100">
    		<form method="post" action="/MemberInformation/views/edit.jsp">
    			<input type="submit" name="edit" value="編集"><br>
    		</form>
    		<form method="post" action="/MemberInformation/jp.co.aforce.servlet/delete">
    			<br>
    			<input type="submit" name="delete" value="削除">
    		</td>
    	</tr>
    	<tr>
    		<td>名前</td>
    		<td><%= last_name %> <%= first_name %></td>
    	</tr>
    	<tr>
    		<td>性別</td>
    		<td>
				<c:choose>
					<c:when test="${gender == 0}">男</c:when>
					<c:when test="${gender == 1}">女</c:when>
				</c:choose>
			</td>
    	</tr>
    	<tr>
    		<td>生年月日</td>
    		<td><%= birth_year %>年<%= birth_month %>月<%= birth_day %>日</td>
    	</tr>
    	<tr>
    		<td>電話番号</td>
    		<td><%= tel %></td>
    	</tr>
    	<tr>
    		<td>メールアドレス</td>
    		<td><%= email %></td>
    	</tr>
    	<tr>
    		<td>職業</td>
    		<td>
    			<c:choose>
					<c:when test="${job == 100}">会社員</c:when>
					<c:when test="${job == 200}">自営業</c:when>
					<c:when test="${job == 300}">公務員</c:when>
					<c:when test="${job == 400}">パート・アルバイト</c:when>
					<c:when test="${job == 500}">専業主婦</c:when>
					<c:when test="${job == 600}">学生</c:when>
					<c:when test="${job == 700}">その他</c:when>
				</c:choose>
    		</td>
    	</tr>
    </table>
    </form>
<%} %>

<%--検索失敗--%>

<%String id2 = (String)request.getAttribute("failure_id");%>
<%String message = (String)request.getAttribute("failure_msg");%>
<% if (message != null) {%>
<font color="red">会員番号：<%= id2 %>の<%= message %></font><br>
<%} %>

<br>
<button type="button" onclick="history.back()">戻る</button><br>

<br>
<a href="/MemberInformation/views/index.jsp" >トップ</a>

<%@ include file="../footer.html" %>