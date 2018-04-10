<%@ page import="object.User" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formularz</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
	Zalogowany jako ${user.login} ${user.rights}
		
		<% User user = (User) session.getAttribute("user");
            if(!user.getRights().equals("administrator")){ %>
        <a class="btn disabled" href="/rights">Premium</a> &nbsp &nbsp
        <% } else { %>
        <a href="/premium">Premium </a> &nbsp &nbsp
        <% }%>

        <a href="/logout">Wyloguj</a>
        
        <table class="table">
                <thead>
                <tr>
                    <th scope="col">Login</th>
                    <th scope="col">Email</th>
                    <th scope="col">Uprawnienia</th>
                    <th scope="col">Usuwanie</th>
                </tr>
                </thead>
                <tbody>
                
				<c:forEach items="${allUsers}" var="user">
                <tr>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.rights}</td>
                    <td><a href="/delete?user=${user.login}">usuń</a></td>
                </tr>

                </c:forEach>
                </tbody>
            </table>

            <p class="font-weight-bold">Zmiana uprawnień</p>
            <form action="/rights" method="post">
                <select name="userToChange">
                    <c:forEach items="${allUsers}" var="user">
                    <option value="${user.login}">${user.login}</option>
                    </c:forEach>
                </select>
                <select name="newRights">
                    <option value="user">User</option>
                    <option value="premium">Premium</option>
                </select>
                <button class="btn btn-primary btn-sm" type="submit">Zatwierdz</button>

            </form>
</body>
</html>