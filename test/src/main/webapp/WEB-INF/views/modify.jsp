<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body style="text-align: center">
<form action="/modify" method="post" enctype="multipart/form-data">
<h3>${board.userID}의 글 수정</h3>
<input type="hidden" value="${board.boardID }">
<table border="1" style="margin: auto; border-collapse: collapse;">
<tr>
	<td>제목</td>
	<td><input type="text" value="${board.title}" name = "title" id="title"></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="content" rows="10" cols="40" id="content">${board.content}</textarea></td>
</tr>
<tr>
	<td>파일</td>
	<td>
		<c:if test="${not empty board.filedir}">
    	<a href="/board/download?filename=${board.filename}"> 다운로드 </a>
		</c:if>
	</td>
</tr>
</table>
<br>
<a href="/boardlist">목록</a> | <input type="submit" value="수정완료">
</form>
</body>
</html>