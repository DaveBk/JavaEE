<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="/login" method="post">
<lebel>Username<input type="text" id="Username" name="Username"/></lebel></br>
<lebel>Password<input type="password" id="Password" name="Password"/></lebel></br>
<input type="submit" value="Log in"/> <br/>
<a href="/">Register</a>
</form>
</body>
</html>