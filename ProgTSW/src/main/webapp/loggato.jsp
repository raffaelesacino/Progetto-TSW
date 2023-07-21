<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loggato</title>
</head>
<body>
<%if(session.getAttribute("username")== "admin@hmail.com"){ %>
<%@ include file="index.jsp" %>
<% }%>
</body>
</html>