<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Person Details are below with id : ${p.getId() }</h1>
	<br>
	<br>
	<h2>${p.getName()}</h2>
	<br>
	<h2>${p.getNumber()}</h2>
	<br>
	<a href="home">click here to go home page</a>

</body>
</html>