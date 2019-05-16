<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student</title>
<link rel="stylesheet" type="text/css" href="css/WebAppExamples.css">
</head>
<body>

	<form action="studentInsertServlet" method="GET">
		<p><label>Student ID </label><input type="text" name="txtId" />
		<p><label>First Name </label><input type="text" name="txtFirstName" />
		<p><label>Last Name </label><input type="text" name="txtLastName" />
		<p><label>Street Address </label><input type="text" name="txtStreet" />
		<p><label>Post Code </label><input type="text" name="txtPostcode" />
		<p><label>Post Office: </label><input type="text" name="txtPostoffice" />
		<p><input type="submit" value="Insert" /></p>
	</form>
	
	<p>
		<c:out value="${ confirmMessage }" />
	</p>

</body>
</html>