<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	if(products == null) {
		response.sendRedirect("./product");	
		return;
	}
	ProductBean product = (ProductBean) request.getAttribute("product");
	Cart cart = (Cart) request.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,progettoTSW.ProductBean,progettoTSW.Cart"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="prodotti.css" rel="stylesheet" type="text/css">
	<title>SCACCHIERE</title>
	
</head>
<%@ include file="index.jsp" %>
<body>
<div class="prodotti">
	<div id="tableRow">
	

	<% if(cart != null) { %>
	
		<table class ="carrello" border="1">
		<tr>
			<th>Prodotto</th>
			<th>Azione</th>
			
			
			
		</tr>
		<%  	
		   List<ProductBean> prodcart = cart.getProducts();%>
		   
		   <%for(ProductBean beancart: prodcart) {
		%>
		
		<tr>
			<td><%=beancart.getName()%></td>
			<td><a href="product?action=deleteC&id=<%=beancart.getCode()%>">Rimuovi</a></td>
		</tr>
		<% } %>
			
	</table>
		
	<% } %>	
	<table class="scacchi" border="1">
		
		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		<tr>
			<td><%=bean.getCode()%></td>
			<td><%=bean.getimmagine()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getDescription()%></td>
			<td><a href="product?action=delete&id=<%=bean.getCode()%>">Delete</a><br>
				<a href="product?action=addC&id=<%=bean.getCode()%>">Aggiungi al carrello</a></td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%>
	</table>
	
	<h2>Details</h2>
	<%
		if (product != null) {
	%>
	<table border="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td><%=product.getCode()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getDescription()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getQuantity()%></td>
		</tr>
	</table>
	<%
		}
	%>
	<%
String currentuser=(String) session.getAttribute("user");
if(currentuser != null){
 if(currentuser.equals("admin@gmail.com") && currentuser != null){ %>
	<h2>Insert</h2>
	
	<form action="product" method="post">
		<input type="hidden" name="action" value="insert"> 
		
		<label for="name">Nome:</label><br> <br>
		<input name="name" type="text" maxlength="20" required placeholder="enter name"><br> <br>
		
		<label for="description">Descrizione:</label><br><br>
		<textarea name="description" maxlength="100" rows="3" required placeholder="enter description"></textarea><br><br>
		
		<label for="price">Prezzo:</label><br> <br>
		<input name="price" type="number" min="0" value="0" required><br><br>

		<label for="quantity">Quantità:</label><br> <br>
		<input name="quantity" type="number" min="1" value="1" required><br><br>
		
		<label for="immagine">Immagine:</label><br> <br>
		<input name="immagine" type="file" accept=".jpg, .jpeg, .png"><br><br>

		<input type="submit" value="Add"><input type="reset" value="Reset">

	</form>
	<% }}%>
	</div>
	</div>
	
</body>
</html>