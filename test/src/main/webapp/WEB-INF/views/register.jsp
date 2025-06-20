<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body style="text-align: center">
<form action="/register" method="post">
<h3>회원가입 페이지</h3>
<input type="text" placeholder="id" name="userID"></br>
<input type="password" placeholder="pw" name="userPW"></br>
<a href="/login">이전으로</a>
<button type="submit">회원가입</button>
</form>
</body>
</html>