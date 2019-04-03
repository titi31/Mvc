<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="controleur" method="post">
		<label>Login:</label><input name="login" type="text" value=${login}>
		<label>Password:</label><input name="password" type="password" value=${password}>
		<input type="submit">
	</form>

</body>
</html>