<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
	
	
		<meta charset="EUC-KR">
		<title>로그인</title> 
	</head>
	<body style="text-align: center" id="body">
		<form action="/login" method="post">
		<h3>로그인 페이지</h3>
		<input type="text" placeholder="id" name="userID"><br>
		<input type="password" placeholder="pw" name="userPW"><br>
		<a href="/register">회원가입</a>
		<button type="submit">로그인</button>
		</form>
		<div id="ajax-result">
		</div>
		
	</body>
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		const a = 10
		console.log(10);
		for(let i=2; i<10; i++) {
			for(let j=1; j<10; j++) {
				console.log(i*j);
			}
			
		}
		
		$.ajax({
		    url: 'https://sjhtest.soland.co.kr/ping/delay/5',
		    method: 'get',
		    success: function (data) {
		    	
		        console.log(data);
		/*         $('#body').text(data);  */
		    }
		});
	</script>
	
</html>