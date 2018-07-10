<%-- <%@include file="taglib_includes.jsp" %> --%>

<html>
<head>
 <script type="text/javascript" src="js/survey.js"></script>
 <script type="text/javascript" src="js/datetimepicker.js"></script>
 
 
 <title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
 <tr>
  <td align="center"><h3>Edit survey detail</h3></td>
 </tr>
  <tr valign="top" align="center">
    <td align="center">
   <form:form action="updateSurvey.do" method="post" commandName="editSurvey">
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
      <form:input path="SURVEY_NAME"/></td>
      <td align="left">
      <form:errors path="SURVEY_NAME" cssStyle="color:red"></form:errors> 
      </td>
     </tr>
     
     <tr>
      <td width="100" align="right">START_DATE</td>
      <td><form:input path="START_DATE" id="demo1" type="text" size="25"/><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="image/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
      
      <%-- <td><form:input path="START_DATE"/></td>
       --%>
      <td align="left"><form:errors path="START_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr>
     
     <tr>
      <td width="100" align="right">END_DATE</td>
      <td><form:input path="END_DATE" id="demo2" type="text" size="25"/><a href="javascript:NewCal('demo2','ddmmyyyy')"><img src="image/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
       
      
      <%-- <td><form:input path="END_DATE"/></td> --%>
      <td align="left"><form:errors path="END_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr>
     <tr>
      <td width="100" align="right">STATUS</td>
      <td>      
       <form:select path="STATUS">
       
                 <form:option value="Completed" label="Completed"/>
                 <form:option value="Incomplete" label="Incomplete"/>
             </form:select>      
      </td>     
     </tr>
     
     <%-- <tr>
      <td width="100" align="right">SURVEY_DESCRIPTION</td>
      <td>
      <form:input path="SURVEY_DESCRIPTION"/></td>
      <td align="left">
      <form:errors path="SURVEY_DESCRIPTION" cssStyle="color:red"></form:errors> 
      </td>
     </tr> --%>
     
    
     
     <tr valign="bottom">
      <td colspan="2" align="center">
      <%-- <input type="button"  value="Delete" onclick="javascript:deleteContact('deleteContact.do?SURVEY_ID=${editContact.SURVEY_ID}');">
      &nbsp;&nbsp; --%>
      <input type="submit" name="" value="Save">      
      &nbsp;&nbsp;
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