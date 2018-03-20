<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Formularz</title>
</head>
<body>
	<form action="harmonogram" method="post">
		<ol>
		<li>Wnioskowana kwota:<input type="text" id="wKwota" name="wKwota" pattern="[0-9]{2,}"/>.00 zł</li>

	   	<li><label for="iloRat">Liczba rat</label>
                    <select id="iloRat" name="iloRat">
                        <option>12</option>
                        <option>18</option>
                        <option>24</option>
                        <option>30</option>
                        <option>36</option>
                        <option>42</option>
                        <option>48</option>
                    </select></li>
		
	     <li><label for="oproc">Oprocentowanie</label>
                    <select  id="oproc" name="oproc">
                        <option value="3">3%</option>
                        <option value="4">4%</option>
                        <option value="5">5%</option>
                        <option value="6">6%</option>
                        <option value="7">7%</option>
                        <option value="8">8%</option>
                        <option value="9">9%</option>
                        <option value="10">10%</option>
                    </select></li>
	
		<li>Opłata stała:<input type="text" id="oplataSt" name="oplataSt" pattern="[0-9]{2,}"/>.00 zł</li>
		
		<li><label>Rodzaj rat</label><br>
		 	<input checked type="radio" id="rodzRat" name="rodzRat" value="stale">stałe<br>
		 	<label class="form-check-label" for="rodzRat1"></label>
  			<input checked type="radio" id="rodzRat" name="rodzRat" value="malejace">malejące<br>
  			<label class="form-check-label" for="rodzRat2"></label></li>
  		</ol>
  		
		<input type="submit" value="wyslij"/>
		
	</form>
</body>
</html>