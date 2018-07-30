<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center">Take Survey</h3>
<body>
	<table border="1" align="center">
<p>hi <security:authentication property="principal.username" /></p>
		
		<form:form method="post" action="../saveSurvey" modelAttribute="questionsListWrapper">
			<c:forEach items="${questionsListWrapper.questions}" var="ques" varStatus="quesStatus">
			<tr>
				<form:input type="hidden" path="questions[${quesStatus.index}].questionId"/>
				<td><form:input type="text" path="questions[${quesStatus.index}].question" readonly="readonly"/></td>
				<td>
					<%-- <form:radiobutton path="questions[${quesStatus.index}].answer" value='questions[${quesStatus.index}].answers[0].answer'/> Yes
					<form:radiobutton path="questions[${quesStatus.index}].answer" value='questions[${quesStatus.index}].answers[1].answer'/> No --%>
					
					<%-- <form:input path="questions[${quesStatus.index}].answers[0].answer" type = "text"/>
					<form:input path="questions[${quesStatus.index}].answers[1].answer" type = "text"/> --%>
					<form:radiobutton path="questions[${quesStatus.index}].answer" value="Yes"/> Yes
					<form:radiobutton path="questions[${quesStatus.index}].answer" value="No"/> No
				</td>
				
				<%-- <c:forEach var="ans" items="questions[${quesStatus.index}].answers" varStatus="ansStatus">
				<tr>
				
					<td><form:input type="text" path="questions[${quesStatus.index}].answers[${ansStatus.index}].Answer"/></td>
					
				</tr>
				</c:forEach> --%>
				</tr>
			</c:forEach>
		<center>	<button type="submit">Update</button></center>
		</form:form>

	</table>

	<center>
		<a href="../logout">
			<button>Logout</button>
		</a>
	</center>
	


</body>
</html>