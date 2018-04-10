<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formularz</title>
</head>
<body>
            <form action="/register" method="post">
                Uzupełnij dane
                
                    <input type="text" class="form-control" required name="login" placeholder="Login">
                    <label></label>
                    <input type="password" class="form-control" required name="password" placeholder="Hasło">
                    <label></label>
                    <input type="password" class="form-control" required name="confirmPassword" placeholder="Potwierdz Hasło">
                    <label></label>
                    <input type="email" class="form-control" required name="email" placeholder="Email">
                
                <% if(session.getAttribute("showUserConflictInfo")!= null){  %>
                
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Nazwa użytkownika już jest używana
                
                <% session.setAttribute("showUserConflictInfo",null); %>
                <% }%>
                <% if(session.getAttribute("showWarning")!= null){  %>
               
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Wprowadzone hasła nie zgadzają się
                
                <% session.setAttribute("showWarning",null); %>
                <% }%>
                Masz już konto? <a href="/login">Zaloguj się </a>
                <button type="submit" class="btn btn-secondary float-right">Rejestracja</button>
            </form>
</body>
</html>