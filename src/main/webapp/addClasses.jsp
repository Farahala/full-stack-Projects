<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class</title>
</head>
<body>
	<h1>Add Class</h1>
	<form action="ClassServlet" method="POST">
		<label for="className">Class Name:</label>
		<input type="text" name="className" id="className" required><br><br>
		

		
		<input type="submit" value="Add Class">
	</form>
</body>
</html>
