<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>formularz</title>
</head>
<body>
  		<form action="/login" method="post">
                Zaloguje się!
  			<% if(session.getAttribute("showRegistrationInfo")!= null){  %>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Konto zostało utworzone. Zaloguj się.
                
            <% session.setAttribute("showRegistrationInfo",null); %>
            <% }%>

                <% if(session.getAttribute("showAuthError") != null){  %>
                
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    Błędny login lub hasło
               
                <% session.setAttribute("showAuthError",null); %>
                <% }%>
               
                    <p class="h6" style="font-size: 10px">konto administratora -> admin/admin</p>
                    <input type="text" class="form-control" required name="login" placeholder="Login">
               
                
                    <input type="password" class="form-control" required name="password" placeholder="Hasło">
               
                <span style="font-size: 12px;" >Nie masz konta? <a href="/register">Zarejestruj się </a></span>
                <button type="submit" class="btn btn-secondary float-right">Zaloguj</button>
         </form>
</body>
</html>