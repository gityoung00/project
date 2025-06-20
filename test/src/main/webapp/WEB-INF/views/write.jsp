<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body style="text-align: center">
<form action="/write" method="post" enctype="multipart/form-data">
<h3>게시글 작성</h3>
<table border="1" style="margin: auto; border-collapse: collapse;">
<tr>
	<td>제목</td>
	<td><input type="text" name = "title"></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="content" rows="10" cols="40" ></textarea></td>
</tr>
<tr>
	<td>파일</td>
	<td><input type="file" name="file"></td>
</tr>
</table>
<br>
<a href="/boardlist">목록</a> | <input type="submit" value="작성완료">
</form>
</body>
</html>