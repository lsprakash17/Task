<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Upload a File and Send Email</h2>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" required><br>
		<br> <input type="email" name="email" placeholder="Enter Email"
			required><br>
		<br> <input type="submit" value="Upload and Send Email">
	</form>

	<p>${message}</p>
</body>
</html>