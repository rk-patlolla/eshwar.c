<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Creation</title>
</head>
<body>

	<table border="1" align="center">
		<form:form method="post" action="/user/addUser">
			<tr>
				<td>userName</td>
				<td><form:input path="userName" type="text" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><form:input path="email" type="text" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><form:input path="password" type="text" /></td>
			</tr>
			<button type="submit">Update</button>
		</form:form>
	</table>

</body>
</html>