<%-- The following two tags allow the use of the JSP and JSTL tags in this source text --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
	<link rel="stylesheet" type="text/css" href="css/WebAppExamples.css">
</head>
<body>
	<h1>Java FristWebApp Exercise</h1>
	<h3>Exercise 9</h3>
	
	<div>
	    <h3>Search Student</h3>
	    
		
		<form action="studentSearchServlet" method="GET">
			<input type="submit" value="Show student" />
			<label>Student ID: </label>
			<input type="text" name="txtId" />
		</form>
		
		
		<c:if test="${ student.id ==-1 }">
		Student not found at Id: <c:out value ="${txtId }"/>
		</c:if>
		
		<c:if test ="${ student.id > 0 }">
		<c:out value = "${ student.id }"/>
		<c:out value = "${ student.firstname }"/>
		<c:out value = "${ student.lastname }"/>
		</c:if>
		
		
		
	</div>

</body>
</html>