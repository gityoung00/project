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
<h3>게시판</h3>
<table border="1" style="margin: auto; border-collapse: collapse;">
<thead>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>파일</th>
</tr>
</thead>
<tbody>
<c:forEach var="board" items="${boardList}">
<tr>
	<td>${board.boardID}</td>
	<td><a href="/board?boardID=${board.boardID}">${board.title}</a></td>
	<td>${board.userID}</td>
	<td>${board.filename}</td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<a href="/write">글쓰기</a> | <a href="/logout">로그아웃</a>
</body>
</html>
