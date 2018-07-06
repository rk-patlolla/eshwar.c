<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
<body>
    <div align="center">
        <h2>Update employeeCategory</h2>
        <table>
            <form:form modelAttribute="category" action="updateCategoryById">
                <tr>
                    <td align="left" width="40%"><form:input type="hidden"
                            path="eid" size="30" value="${categoryFound.id}" /></td>
                    <td align="left"><form:errors path="eid" cssClass="error" /></td>
                </tr>
                <tr>
                    <td align="left" width="20%">Name:</td>
                    <td align="left" width="40%"><form:input path="ename"
                            size="30" value="${categoryFound.categoryName}" /></td>
                    <td align="left"><form:errors path="ename" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Active:</td>
                    <td><form:input path="email" size="30"
                            value="${categoryFound.isActive}" /></td>
                    <td><form:errors path="email" cssClass="error" /></td>
                </tr>
       
                    <td></td>
                    <td align="center"><input type="submit" value="Update" /></td>
                    <td></td>
                </tr>
            </form:form>
        </table>
    </div>

</body>
</html>