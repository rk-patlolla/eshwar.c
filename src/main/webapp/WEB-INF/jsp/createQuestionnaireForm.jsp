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

<table border="1" align="center">
<form:form method="post" action="createCategory">
<tr>
<th>
Category Id
</th>
<th>
Question
</th>
</tr>

<td><form:input path="categoryName" size="30"/></td>
<tr><th colspan="4"><button>ADD</button></th></tr>
   
</form:form>
</table>  
    
    
    <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>   
</body>
</html>