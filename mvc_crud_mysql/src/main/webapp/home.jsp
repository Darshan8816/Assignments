<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
button:hover {
	color: blue;
	background-color: yellow;
}

.opt {
	display: flex;
	align-items: center;
	justify-content: space-around;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: red;background-color: yellow;">${msg}</h3>
	<div>
		<h1 style="color: blue; background-color: black;">Person Details</h1>
	</div>
	<div class="opt">
		<a href="savePerson"><button style="border-radius: 5%;">Save_Person</button></a>
		<a href="fetchPerson"><button style="border-radius: 5%;">Find_Person_By_Id</button></a>
		<a href="console"><button style="border-radius: 5%;">Database</button></a>
		<a href="updatePerson"><button style="border-radius: 5%;">Update_Person</button></a>
		<a href="deletePerson"><button style="border-radius: 5%;">Delete_Person_By_Id</button></a>
	</div>
</body>
</html>