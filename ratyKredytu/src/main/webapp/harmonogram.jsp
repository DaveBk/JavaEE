<%@ page import="javaObjects.OutputData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Formularz</title>
</head>
<body>
	<p>Harmonogram splat kredytu</p>
	
	<%
		List<OutputData> ratyLista = new ArrayList<>();
			ratyLista = (List<OutputData>) request.getAttribute("harmonogram");
	%>
	
	           <table class="table mt-4">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Kwota kapitału</th>
                    <th scope="col">Kwota odsetek</th>
                    <th scope="col">Opłaty stałe</th>
                    <th scope="col">Całkowita kwota raty</th>
                </tr>
                </thead>


                <tbody>
                    <% for(OutputData i: ratyLista) {%>
                    <tr>
                    <th scope="row">
                        <%= i.getNumer()%>
                    </th>
                    <td>
                        <%= i.getKapital()%>
                    </td>
                    <td>
                        <%= i.getOdsetki()%>
                    </td>
                    <td>
                        <%= i.getOplata()%>
                    </td>
                    <td>
                        <%= i.getCalkowitaKwota()%>
                    </td>

                </tr>
                    <%}%>
                </tbody>
            </table>

            <form action="/pdf" method="post">
            <button type="submit">generuj PDF</button>
            </form>
            
</body>
</html>