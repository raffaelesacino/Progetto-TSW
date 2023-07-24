<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acquisto!</title>
</head>
<body>
<% 
out.println("Grazie " + session.getAttribute("user") + " per aver scelto CHECKMATE!");%>
<a href="home.jsp">Home</a>
</body>
</html>