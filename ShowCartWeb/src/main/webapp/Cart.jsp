<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link
 	href ="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
 	rel="stylesheet"
 	integrity="sha284-wvfXpqpZZVQGK6TAh5PlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVc0QVnN"
 	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; padding:20">
			<div style = "width: 50%;">
				<h3 onclick ="window.location.href='HomeServlet'"> Coding mentor library </h3>
			</div>
			<div style = "width:50%; text-align:right;">
				<c:if test="${sessionScope.name!=null}">
				Hello ${sessionScope.name }
				<br>
				</c:if>
				<a href ="HomeServlet?command=VIEW_CART">Cart(${empty sessionScope.cart? 0:sessionScope.cart.size()})</a>
			</div>
		</div>
	<hr>
	
	<div style ={display: flex; padding:20">
		<div style ="width:30%;"></div>
		<div style="width:70%;">
			<c:if test="${not empty cart }">
				<h4> Books in Cart</h4>
				<hr>
				<c:forEach var ="item" items="${cart}" varStatus="status" >
					${status.count }: ${item.value.name} ---- <a href="#"> Remove </a>
					<br>			
				</c:forEach>
				<br>
				<input type ="button" value ="Submit Cart" />
			</c:if>
			
			<c:if test="${empty cart}">
				<h4> Empty cart</h4>
			</c:if>
	</div>
	</div>
</body>
</html>