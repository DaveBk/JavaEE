<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Add" method="post">
<lebel>Username<input type="text" id="Username" name="Username"/></lebel><br/>
<lebel>Password<input type="password" id="Password" name="Password"/></lebel><br/>
<lebel>CPassword<input type="password" id="CPassword" name="CPassword"/></lebel><br/>
<lebel>Email<input type="text" id="email" name="email"/></lebel><br/>
<lebel>User privlage</lebel><br/>
<lebel>Normal user<input type="radio" name="privlage" value="normal"/></lebel><br/>
<lebel>Premium<input type="radio" name="privlage" value="premium"/></lebel><br/>
<lebel>Admin<input type="radio" name="privlage" value="admin"/></lebel><br/>
<input type="submit" value="send"/>
</form>
<a href="/login.jsp">Login</a>
</body>
</html>