<%-- <%@include file="taglib_includes.jsp"%> --%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message></title>
<script type="text/javascript" src="js/survey.js"></script>



</head>
<body style="font-family: Arial; font-size: smaller;">
 
  <h3><center>Survey page Details</center></h3>
 
 
 <center>
  
  <table style="border-collapse: collapse;" border="1"
   bordercolor="#006699" width="500">
   <tr bgcolor="lightblue">
    <th>Survey Id</th>
    <th>Survey Name</th>
    <th>Survey Start Date</th>
    <th>Survey End date</th>
    <th>Status</th>
    <th>Action</th>
    
    <th></th>
   </tr>
   <c:if test="${empty SEARCH_SURVEY_RESULTS_KEY}">
    <tr>
     <td colspan="4">No Results found</td>
    </tr>
   </c:if>
   <c:if test="${! empty SEARCH_SURVEY_RESULTS_KEY}">
    <c:forEach var="survey" items="${SEARCH_SURVEY_RESULTS_KEY}">
     <tr>
      <td><c:out value="${survey.SURVEY_ID}"></c:out></td>
      <td><c:out value="${survey.SURVEY_NAME}"></c:out></td>
      <td><fmt:formatDate value="${survey.START_DATE}" pattern="dd-MM-yyyy" /></td>
      <td><fmt:formatDate value="${survey.END_DATE}" pattern="dd-MM-yyyy" /></td>
      
      <%-- <td><c:out value="${survey.START_DATE}"></c:out></td>
      <td><c:out value="${survey.END_DATE}"></c:out></td> --%>
      
      <td><c:out value="${survey.STATUS}"></c:out></td>
      
      <td>&nbsp;<a href="updateSurvey.do?SURVEY_ID=${survey.SURVEY_ID}">Edit</a>
       &nbsp;&nbsp;
          <a href="viewSurvey.do?SURVEY_ID=${survey.SURVEY_ID}">View</a>
       </td>
       
       <td>
      <a href="saveQuestion.do?SURVEY_ID=${survey.SURVEY_ID}">Question</a>
      </td> 
     </tr>
    </c:forEach>
   </c:if>
  </table>
 </center>
 <br><br><br>
<input type="button" value="add new survey" onclick="javascript:go('saveSurvey.do');" />
</body>
</html>