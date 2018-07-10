<%-- <%@include file="taglib_includes.jsp" %> --%>

<html>
<head>
 <script type="text/javascript" src="js/survey.js"></script>
 
 <title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
 <tr>
  <td align="center"><h3>survey detail</h3></td>
 </tr>
  <tr valign="top" align="center">
    <td align="center">
   <form:form action="viewSurvey.do" method="post" commandName="viewSurvey">
    <table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">     
     <tr>
      <td width="100" align="right">SURVEY_ID</td>
      <td width="150">
      <form:input path="SURVEY_ID" readonly="true"/></td>
      <td align="left">
      <form:errors path="SURVEY_ID" cssStyle="color:red"></form:errors>  </td>
     </tr>
     <tr>
      <td width="100" align="right">SURVEY_NAME</td>
      <td>
      <form:input path="SURVEY_NAME" readonly="true"/></td>
      <td align="left">
      <form:errors path="SURVEY_NAME" cssStyle="color:red"></form:errors> 
      </td>
     </tr>
     
     <tr>
      <td width="100" align="right">START_DATE</td>
      <td><form:input path="START_DATE" readonly="true"/></td>
      <td align="left"><form:errors path="START_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr>
     
     <tr>
      <td width="100" align="right">END_DATE</td>
      <td><form:input path="END_DATE" readonly="true"/></td>
      <td align="left"><form:errors path="END_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr>
      <%-- <tr>
      <td width="100" align="right">STATUS</td>
      <td>      
       <form:select path="STATUS" readonly="true">
       
                 <form:option value="C" label="Completed"/>
                 <form:option value="NC" label="Incomplete"/>
             </form:select>      
      </td>
      <td>
      </td>      
     </tr>  --%>    
     <tr valign="bottom">
      <td colspan="1" align="center">     
      <input type="button"  value="Back" onclick="javascript:go('viewAllSurvey.do');">
      </td>
     </tr>    
    </table>    
  </form:form>
    </td>    
  </tr>
</table>
</body>
</html>