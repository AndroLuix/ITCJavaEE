<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calcolatrice</title>
</head>
<body>

	<h2>Calcolatrice</h2>
	
	<form action="CalcolatriceSessionServlet">
		<label for="op1">Operando1:</label><input  required  type="number" id="op1" name="op1" value="<%=request.getParameter("op1")%>"><br><br>
		<label for="op2">Operando2</label><input required  type="number" id="op2" name="op2" value="<%=request.getParameter("op2")%>"><br><br>
		<label for="somma">Somma</label>
		<%  String operazione = request.getParameter("operazione");
				
			if(operazione==null){
				operazione="";
			}
				
			if(operazione.equals("+")){
		%>
			<input type="radio" id="somma" name="operazione" value="+" checked="checked"> <br><br>
			
		<%} else{ %>
			<input type="radio" id="somma" name="operazione" value="+" >
		<%} %>
			<label for="diff">Sottrazione</label>
			<input type="radio" id="diff" name="operazione" value="-"> <br><br>
			<label for="molt">Moltiplicazione</label>
			<input type="radio" id="molt" name="operazione" value="*"><br><br>
			<label for="div">Divisione</label>
			<input type="radio" id="div" name="operazione" value="/"><br><br>
		
		<label for="ris">Risultato</label>
		<input type="number" id="ris" name="ris" value="<%=request.getAttribute("risultato")%>"><br><br>
		
		<input type="submit" value="Calcola">
	</form>
</body>
</html>