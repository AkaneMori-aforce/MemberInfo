<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<script type="text/javascript" src="js/script.js"></script>

<h2>会員情報編集</h2>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String id = (String)request.getAttribute("id");%>
<%String last_name = (String) request.getAttribute("last_name");%>
<%String first_name = (String) request.getAttribute("first_name");%>
<%String gender = (String) request.getAttribute("gender");%>
<%String birth_year = (String) request.getAttribute("birth_year");%>
<%String birth_month = (String) request.getAttribute("birth_month");%>
<%String birth_day = (String) request.getAttribute("birth_day");%>
<%String tel = (String) request.getAttribute("tel");%>
<%String email = (String) request.getAttribute("email");%>
<%String job = (String) request.getAttribute("job");%>

<form action="/MemberInformation/" method="post">
<ul>
	<li>会員番号</li>
	<input type="text" name="member_id" value="<%= id %>" readonly>
	<li>名前</li>
	姓<input type="text" name="last_name" style="width:80px" value="<%= last_name %>" required>
	名<input type="text" name="first_name" style="width:80px" value="<%= first_name %>" required><br>
	<li>性別</li>
	<c:choose>
		<c:when test="${gender == 0}">
			男<input type="radio" name="gender" value="male" checked>
			女<input type="radio" name="gender" value="female"><br>
		</c:when>
		<c:when test="${gender == 1}">
			男<input type="radio" name="gender" value="male">
			女<input type="radio" name="gender" value="female" checked><br>
		</c:when>
	</c:choose>
	<li>生年月日</li>
	<input type="number" name="birth_year" min="1920" max="2020" style="width:70px" value="<%= birth_year %>" required>年
	<input type="number" name="birth_year" min="1" max="12" style="width:48px" value="<%= birth_month %>" required>月
	<input type="number" name="birth_year" min="1" max="31" style="width:48px" value="<%= birth_day %>" required>日
	<li>電話番号</li>
	<input type="tel" name="phone_numbr" placeholder="例：000-1234-5678" pattern="\d{3}-?\d{4}-?\d{4}" value="<%= tel %>" required>
	<li>メールアドレス</li>
	<input type="email" name="mail_address" placeholder="例：address@email.co.jp" value="<%= email %>" required>
	<li>職業</li>
	<select name="job" required>
		<option value="">--</option>
		<option value="会社員">会社員</option>
		<option value="自営業">自営業</option>
		<option value="公務員">公務員</option>
		<option value="パート・アルバイト">パート・アルバイト</option>
		<option value="専業主婦">専業主婦</option>
		<option value="学生">学生</option>
		<option value="その他">その他</option>
	</select>
</ul>
<input type="submit" name="register" value="更新"><br>
</form>

<button type="button" onclick="history.back()">戻る</button>

<%@ include file="../footer.html" %>