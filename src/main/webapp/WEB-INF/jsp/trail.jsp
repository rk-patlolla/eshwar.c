
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CampusGuide | Add Course</title>
</head>
<body>

	<form id="form">
		<form:select path="category" modelAttribute="Category">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${categories.categoryName}" />
		</form:select>

		<div id="dynamic_form">
			<input type="text" name="members[0][question]" value="question">
			<br> <input type="text" name="members[1][name]" value="question">
			<br> <input type="text" name="members[2][name]" value="question">

		</div>
	</form>
</body>
</html>

</body>
</html>
