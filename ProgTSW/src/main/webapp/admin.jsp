<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
</head>
<body>
<%
String user=(String) session.getAttribute("user");
 if(user.equals("admin@gmail.com")){ %>
<h3>ciao ${user}</h3><%} %>
</body>
</html>