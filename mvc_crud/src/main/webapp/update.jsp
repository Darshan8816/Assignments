<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="person" action="update" method="post">
		<label for="id">Person_Id : </label>
		<input type="number" name="id" id="id">
		<br>
		<label for="name">Person_Name : </label>
		<input type="text" name="name" id="name">
		<br>
		<label for="number">Phone_number : </label>
		<input type="tel" name="number" id="number">
		<br>
		<button>Submit</button>
	</form:form>
</body>
</html>