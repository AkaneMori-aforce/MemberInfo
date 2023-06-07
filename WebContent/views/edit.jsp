<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<link rel="stylesheet" type="text/css" href="/MemberInformation/css/style.css">

<h2>会員情報編集</h2>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String id = (String) session.getAttribute("id");%>
<%String last_name = (String) session.getAttribute("last_name");%>
<%String first_name = (String) session.getAttribute("first_name");%>
<%String gender = (String) session.getAttribute("gender");%>
<%String birth_year = (String) session.getAttribute("birth_year");%>
<%String birth_month = (String) session.getAttribute("birth_month");%>
<%String birth_day = (String) session.getAttribute("birth_day");%>
<%String tel = (String) session.getAttribute("tel");%>
<%String email = (String) session.getAttribute("email");%>
<%String job = (String) session.getAttribute("job");%>

<form action="/MemberInformation/jp.co.aforce.servlet/edit" method="post">
<ul>
	<li>会員番号</li>
	<input type="text" name="member_id" value="<%= id %>" class="noedit" readonly>
	<li>名前</li>
	姓<input type="text" name="last_name" style="width:80px" value="<%= last_name %>" required>
	名<input type="text" name="first_name" style="width:80px" value="<%= first_name %>" required><br>
	<li>性別</li>
			男<input type="radio" name="gender" value="0" <%if(gender=="0"){%>checked<%} %> required>
			女<input type="radio" name="gender" value="1" <%if(gender=="1"){%>checked<%} %>><br>
	<li>生年月日</li>
	<input type="number" name="birth_year" min="1920" max="2020" style="width:70px" value="<%= birth_year %>" required>年
	<input type="number" name="birth_month" min="1" max="12" style="width:48px" value="<%= birth_month %>" required>月
	<input type="number" name="birth_day" min="1" max="31" style="width:48px" value="<%= birth_day %>" required>日
	<li>電話番号</li>
	<input type="tel" name="phone_number" placeholder="例：000-1234-5678" pattern="[0-9]{11,13}" value="<%= tel %>" required>
	<li>メールアドレス</li>
	<input type="email" name="email_address" placeholder="例：address@email.co.jp" value="<%= email %>" required>
	<li>職業</li>
	<select name="job" required>
		<option value="100" <%if(job=="100"){%>selected<%} %>>会社員</option>
		<option value="200" <%if(job=="200"){%>selected<%} %>>自営業</option>
		<option value="300" <%if(job=="300"){%>selected<%} %>>公務員</option>
		<option value="400" <%if(job=="400"){%>selected<%} %>>パート・アルバイト</option>
		<option value="500" <%if(job=="500"){%>selected<%} %>>専業主婦</option>
		<option value="600" <%if(job=="600"){%>selected<%} %>>学生</option>
		<option value="700" <%if(job=="700"){%>selected<%} %>>その他</option>
	</select>
</ul>
<input type="submit" name="register" value="更新"><br>
</form>

<%--登録失敗--%>
<%String message = (String)request.getAttribute("failure");%>
<% if (message != null) {%>
    <font color="red"><%= message %></font><br>
<%} %>

<br>
<button type="button" onclick="history.back()">戻る</button>

<%@ include file="../footer.html" %>