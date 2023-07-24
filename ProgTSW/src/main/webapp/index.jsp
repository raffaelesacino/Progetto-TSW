<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,progettoTSW.ProductBean,progettoTSW.Cart"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" type="text/css" href="css/menu.css"  />
</head>
<body>
<header>
<div class="menu">
<img id="logo" src="immagini/LOGO.png">

 <ul class="links">
  <li><a href="http://localhost/ProgTSW/home.jsp">Home</a></li>
  <li><a href="http://localhost/ProgTSW/product">Catalogo</a></li>
  <li><a href="http://localhost/ProgTSW/chi_siamo.jsp">Chi siamo</a></li>

 </ul>
 
 <div class="tendina">
 
 </div>
 <%
 if(session.getAttribute("user") == null){ %>
 <button class="accedi">Accedi</button>
 <button class="registrati">Registrati</button><%} %>
 <%if(session.getAttribute("user") != null){ %>
<form action=http://localhost/ProgTSW/logout target="_blank">
  <button  class="logout" type="submit">
    Logout
  </button>  
</form>
<%} %>
</div>

</header>

<div class=accesso>
<button class="X_accesso">X</button>
	<form id="accForm" method=post action="http://localhost/ProgTSW/accesso" onsubmit="return validateacc()">
		<fieldset>
			<legend>Accedi!</legend>
			<div>
				<label for="email">Email:</label><input type="text" name="email"
					id="email"><span id="errorEmailAcc"></span>
			
				<label for="password">Password:</label><input type="password" name="password"
					id="passwordAcc"><span id="erropasswordAcc"></span>
			</div>
			<hr>
			<div>
				<input type="submit" value="Accedi"> <input type="reset"
					value="Reset">
			</div>
		</fieldset>
	</form>
</div>

   <div class=registrazione>
   <button class="X_registrazione">X</button>
	<form id="regForm" method=post action="http://localhost/ProgTSW/registrazione" onsubmit="return validatereg()">
		<fieldset>
			<legend>Registrati!</legend>
			<div>
				<label for="firstname">Nome:</label><input type="text"
					name="firstname" id="firstname"><span id="errorName"></span>
			
			
				<label for="lastname">Cognome:</label><input type="text"
					name="lastname" id="lastname"><span id="errorLastname"></span>
					</div>
			<div>
				<label for="email">Email:</label><input type="text" name="email"
					id="email"><span id="errorEmailReg"></span>

				<label for="password">Password:</label><input type="password" name="password"
					id="passwordReg"><span id="erropasswordReg"></span>
			</div>
			<hr>
			<div>
				<input type="submit" value="Registrati"> <input type="reset"
					value="Reset">
			</div>
		</fieldset>
	</form>
</div>




<script src="scripts/validate.js"></script>
<script src="scripts/reg.js"></script>
</body>
</html>