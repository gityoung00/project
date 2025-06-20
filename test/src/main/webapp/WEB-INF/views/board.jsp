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
<h3>${board.userID}의 글</h3>
<table border="1" style="margin: auto; border-collapse: collapse;">
<tr>
	<td>제목</td>
	<td><input type="text" value="${board.title}" name = "title" id="title" readonly></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="content" rows="10" cols="40" id="content" readonly>${board.content}</textarea></td>
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
<a href="/boardlist">목록</a> | <a href="/write">글 작성</a>
<c:set var="sessionUserID" value="${sessionScope.userID}" />
<c:if test="${sessionUserID == board.userID}">
	 | <a href="/modify?boardID=${board.boardID}">글 수정</a>
	 | <a href="/delete?boardID=${board.boardID}">글 삭제</a>
</c:if>
</body>
</html>