<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="misuraServlet">
		<label for ="misura"> Inserisci la misura :</label>
		<input type = "number" id ="misura" name ="misura" value="<%=request.getParameter("misura")%>">
		<br><br>
		
		<h3>Seleziona l'unità di misura di partenza: </h3>
		<label for ="mm"> Millimetri</label>
		<input type="radio" id="millimetri" name="unita1" value="mm" >
		<br><br>	
		<label for ="cm"> Centimetri</label>
		<input type="radio" id="centimetri" name="unita1" value="cm" >
		<br><br>
		<label for ="dm"> Decimetri</label>
		<input type="radio" id="decimetri" name="unita1" value="dm" >
		<br><br>
		<label for ="m"> Metri</label>
		<input type="radio" id="metri" name="unita1" value="m" >
		<br><br>
		<label for ="dam"> Decametri</label>
		<input type="radio" id="decametri" name="unita1" value="dam" >
		<br><br>
		<label for ="hm"> Ettometri</label>
		<input type="radio" id="ettometri" name="unita1" value="hm" >
		<br><br>
		<label for ="km"> Chilometri</label>
		<input type="radio" id="Chilometri" name="unita1" value="km" >
		<br><br>
		
		
		
		<h3>Seleziona l'unità di misura da calcolare: </h3>
		<label for ="mm"> Millimetri</label>
		<input type="radio" id="millimetri" name="unita2" value="mm" >
		<br><br>	
		<label for ="cm"> Centimetri</label>
		<input type="radio" id="centimetri" name="unita2" value="cm" >
		<br><br>
		<label for ="dm"> Decimetri</label>
		<input type="radio" id="decimetri" name="unita2" value="dm" >
		<br><br>
		<label for ="m"> Metri</label>
		<input type="radio" id="metri" name="unita2" value="m" >
		<br><br>
		<label for ="dam"> Decametri</label>
		<input type="radio" id="decametri" name="unita2" value="dam" >
		<br><br>
		<label for ="hm"> Ettometri</label>
		<input type="radio" id="ettometri" name="unita2" value="hm" >
		<br><br>
		<label for ="km"> Chilometri</label>
		<input type="radio" id="Chilometri" name="unita2" value="km" >
		<br><br>
		
		<input type="submit" value="Calcola">	
		
		
		<label for="ris">Risultato</label>
		<input type="text" id="ris" name="ris" value="<%=request.getAttribute("risultato")%>"><br><br>
		
		
		
	
	
	</form>
</body>
</html>