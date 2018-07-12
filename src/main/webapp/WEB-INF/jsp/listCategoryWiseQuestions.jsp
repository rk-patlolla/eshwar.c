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


		<c:forEach var="listValue" items="${questionList}">


			</tr>
			<form:form modelAttribute="Question" action="../updateQuestionById">
				<input type="hidden" name="questionId"
					value="<c:out value="${listValue.questionId}"/>" />
				<td><input type="text" name="question"
					value="<c:out value="${listValue.question}"/>" /></td>
				<td><button type="submit">Update</button></td>
			</form:form>
			<td><a href="<c:url value='../deleteQuestionById/${listValue.questionId}'/>"><button>Delete</button></a></td>
			<%-- <td><a
				href="<c:url value='addOrEditQuestionsByCategoryId/${listValue.categoryId}'/>"><button>Add/Edit
						Questions</button></a></td> --%>



		</c:forEach>

	</table>
	<center>
		<a href="createCategoryForm">
			<button>Add Survey</button>
		</a>
	</center>


</body>
</html>