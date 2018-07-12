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

<form:form method="post" action="../createQuestions" modelAttribute="Category">
<h3>Category:${categoryFound.categoryName}</h3>
<form:input type="hidden" readonly="readonly" value="${categoryFound.categoryId}" path="categoryId"/>
<form:input type="text" readonly="readonly" value="${categoryFound.categoryId}" path="categoryName"/>
<br>
<form:input path="questions[0].question" type = "text"/>
<form:input path="questions[0].answers[0].answer" type = "text"/>
<form:input path="questions[0].answers[1].answer" type = "text"/>
<br>
<form:input path="questions[1].question" type = "text"/>
<form:input path="questions[1].answers[0].answer" type = "text"/>
<form:input path="questions[1].answers[1].answer" type = "text"/>
<br>
<form:input path="questions[2].question" type = "text"/>
<form:input path="questions[2].answers[0].answer" type = "text"/>
<form:input path="questions[2].answers[1].answer" type = "text"/>
<br>
<form:input path="questions[3].question" type = "text"/>
<form:input path="questions[3].answers[0].answer" type = "text"/>
<form:input path="questions[3].answers[1].answer" type = "text"/>
<br>
<form:input path="questions[4].question" type = "text"/>
<form:input path="questions[4].answers[0].answer" type = "text"/>
<form:input path="questions[4].answers[1].answer" type = "text"/>

 <button type="submit">Update</button>  
</form:form>
       
</body>
</html>