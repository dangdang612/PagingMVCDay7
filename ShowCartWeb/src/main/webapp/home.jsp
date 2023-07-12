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
<h2>Register </h2>
	<form action="RegisterServlet">
  		<label for="fname"> Username:</label>  <input type="text" name="username" value="${param.username}" ><br><br>
  		<label for="fname"> Password: </label> <input type="text" name="password" value="${param.password}" ><br><br>
  		<label for="fname"> Email: </label> <input type="text" name="email" value="${param.email}"">
  		<input type="submit" value="Login">
  	<a href="CartServlet?command=VIEW_CART"> cart(${empty sessionScope.cart? 0: sessionScope.cart.size()})</a>
  
  <div style="display:flex; padding:20">
  	<div style="width:30%;">
  		<c:forEach var="category" items="${categories}">
  			<a href="HomeSevlet">${category.name} </a>
  			<br>
  		</c:forEach>
  </div>
  </div>
  <div style="width: 70%;">
  	<c:if test="${not empty books}">
  		<c:forEach var="book" items="${books}"> 
  			<a href="HomeServlet?command=DETAIL&bookId=${book.id}"> Book:${book.name}------</a>
  			<br>
  		</c:forEach>
  	</c:if>
  <c:if test="${not empty book}">
  	<h4> Book Detail</h4>
  	<hr>
  	Book:${book.name }<br>
  	Stock:${book.stock } <br>
  	<br>
  	<input type="button" value="Add to Cart"
  		onclick="window.location.href='CartServlet?command=ADD_TO_CART&bookId=${book.id}' "/>
  </c:if>
 </div>	
</form>
</body>
</html>