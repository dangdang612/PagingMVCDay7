<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paging</title>
	<style>
		table{
			border-collapse: collapse
		}
		.content {
			margin:auto;
			width: 80%;
			float:left;
			margin-left: 30px;
			height:auto
			
			
			}
	</style>
	<style>	table, th, td {
  border:1px solid black;
}
</style>
</head>
<body>
	<h1> List of products</h1>
	<c:set var="page" value ="${requestScope.page }"/>
	<div class="pagination">
		<c:forEach begin ="${1 }" end ="${requestScope.num}" var="i">
			<a href="paging?page=${i}">${i } </a>
		</c:forEach>
	</div>

		

<body>

<h2>Paging</h2>

<table style="width:100%">
  <tr>
    <th>Id</th>
    <th>Name of the book</th>
  </tr>
<c:forEach items="${bookList}" var="book">
		<tr>
			<td>${book.id}</td>
			<td>${book.name}</td>
		</tr>
	</c:forEach>
 
</table>
		
</body>
</html>