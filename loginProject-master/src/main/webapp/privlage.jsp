<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="privlage" method="post">
<lebel>Username<input type="text" id="Username" name="Username"/></lebel><br/>
<lebel>User privlage</lebel><br/>
<lebel>Normal user<input type="radio" name="privlage" value="normal"/></lebel><br/>
<lebel>Premium<input type="radio" name="privlage" value="premium"/></lebel><br/>
<lebel>Admin<input type="radio" name="privlage" value="admin"/></lebel><br/>
<input type="submit" value="Add/Delete privlage"/>
</form>
<a href="/premium">Go back</a>
</body>
</html>