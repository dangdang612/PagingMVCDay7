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

	<div class="header">
		<form action="home">
			<input type="text" name="bookName"
				value="${empty param.bookName ? '' : param.bookName }"> <input
				type="submit" value="Search">
		</form>

		<div class="register">
			<form action="register.jsp">
				<input type="submit" value="Register">
			</form>
		</div>

		<div class="login">
		
				
			<c:if test="${empty username}">
				<form action="login.jsp">
				<input type="submit" value="Login">
			</form>
			</c:if>
			<c:if test="${not empty username}">
				<form action="login.jsp">
					<input type="submit" value="Hello ${username}">
				</form>
			</c:if>
			<a href="cart?command=VIEW_CART">Cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</a>



		</div>
	</div>


	<hr>
	<div class="body">
		<div class="sub-body-category">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>

			</ul>
		</div>
		<div class="sub-body-product">
			<ul>
				<c:forEach var="book" items="${bookList}">
					<a href="book?bookId=${book.id}">
						<li>${book.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>


	</div>

	<hr>
	<div class="footer">
		<h2>This is coding mentor Website for be4</h2>
	</div>


</body>
</html>