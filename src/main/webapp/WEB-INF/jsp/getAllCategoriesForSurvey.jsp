<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center">View Course</h3>
<body>
	<table border="1" align="center">

		<th>Category Name</th>


		<c:forEach var="listValue" items="${Categories}">
		

			<form:form modelAttribute="Category" action="/user/selectCategoryForSurvey/${listValue.categoryId}" method="GET">
				<input type="hidden" name="categoryId"
					value="<c:out value="${listValue.categoryId}"/>" />
				<td><input type="text" name="categoryName"
					value="<c:out value="${listValue.categoryName}"/>" /></td>
				<td><button type="submit">Take Survey</button></td>
			</form:form>



		</c:forEach>

	</table>
	<center>
		<a href="../logout">
		<button>Logout</button></a>
	</center>


</body>
</html>