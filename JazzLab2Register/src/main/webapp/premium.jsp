<%@ page import="object.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formularz</title>
</head>
<body>

	<span>Zalogowany jako ${user.login} (${user.rights})</span>
		    <% User user = (User) session.getAttribute("user");
            if(!user.getRights().equals("administrator")){ %>
            <a class="btn disabled" href="/rights">Uprawnienia</a>&nbsp &nbsp
            <% } else {  %>
            <a href="/rights">Uprawnienia</a> &nbsp &nbsp
            <% } %>
            <a href="/">Index</a>&nbsp &nbsp
            <a href="/logout">Wyloguj</a>
            
            <p>Strona dostępna dla użytkownika Premium.</p>
</body>
</html>