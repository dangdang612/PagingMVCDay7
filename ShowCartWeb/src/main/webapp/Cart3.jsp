<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<li> id : ${book.id} </li>
<li>name : ${book.name}</li>
<li>title : ${book.title} </li>
<li>author : ${book.author} </li>
<li>stock : ${book.stock} </li>

<br>
<input type="button" value="Add to cart"
	onclick="window.location.href='cart?command=ADD_TO_CART&bookId=${book.id}'"/>
</body>
</html>