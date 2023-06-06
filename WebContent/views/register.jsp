<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<script type="text/javascript" src="/js/script.js"></script>

<h2>会員情報登録</h2>

<form action="/MemberInformation/jp.co.aforce.servlet/register" method="post">
<ul>
<li>名前</li>
姓<input type="text" name="last_name" placeholder="例：山田" style="width:80px" required>
名<input type="text" name="first_name" placeholder="例：太郎" style="width:80px" required><br>
<li>性別</li>
男<input type="radio" name="gender" value="0" checked>
女<input type="radio" name="gender" value="1"><br>
<li>生年月日</li>
<input type="number" name="birth_year" min="1920" max="2020" placeholder="例：1995"style="width:70px"  required>年
<input type="number" name="birth_month" min="1" max="12" placeholder="例：7" style="width:48px" required>月
<input type="number" name="birth_day" min="1" max="31" placeholder="例：1" style="width:48px" required>日
<li>電話番号</li>
<input type="tel" name="phone_number" placeholder="例：00012345678" pattern="[0-9]{11,13}" required>
<li>メールアドレス</li>
<input type="email" name="email_address" placeholder="例：address@email.co.jp" required>
<li>職業</li>
<select name="job" required>
	<option value="">--</option>
	<option value="100">会社員</option>
	<option value="200">自営業</option>
	<option value="300">公務員</option>
	<option value="400">パート・アルバイト</option>
	<option value="500">専業主婦</option>
	<option value="600">学生</option>
	<option value="700">その他</option>
</select>
</ul>
<input type="submit" name="register" value="登録">
<input type="reset" name="reset" value="リセット">
</form>

<%--登録失敗--%>
<%String message = (String)request.getAttribute("failure");%>
<% if (message != null) {%>
    <font color="red"><%= message %></font><br>
<%} %>

<br>
<button type="button" onclick="history.back()">戻る</button>

<%@ include file="../footer.html" %>