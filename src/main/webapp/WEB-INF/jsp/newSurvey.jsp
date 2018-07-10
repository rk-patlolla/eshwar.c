<%-- <%@include file="taglib_includes.jsp" %> --%>

<html>
<head>
 <script type="text/javascript" src="js/survey.js"></script>
 <script type="text/javascript" src="js/jquery-1.9.1.js"></script> 
 <script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript" src="js/datetimepicker.js"></script>

 <title><spring:message code="App.Title"></spring:message> </title>
 </head>

<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="#F1D4B8" width="1000" height="600" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
 <tr>
  <td align="center"><h3>Adding new Survey</h3></td>
 </tr>
 <tr valign="top" align="center">
    <td align="center">
   <form:form action="saveSurvey.do" method="post" commandName="newSurvey">
      
    <table width="700" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2"> 
     <tr>
      <td width="50" align="right">SURVEY_NAME</td>
      <td width="50">
      <form:input path="SURVEY_NAME"/></td>
      <td align="left">
      <form:errors path="SURVEY_NAME" cssStyle="color:red"></form:errors> 
      </td> 
     </tr>
       
      <tr>
      <td width="75" align="right">START_DATE</td>
      <td><form:input path="START_DATE" id="demo1" type="text" size="25"/><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="image/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
           
      <td align="left"><form:errors path="START_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr> 
     <tr>
      <td width="50" align="right">END_DATE</td>
        <td><form:input path="END_DATE" id="demo2" type="text" size="25"/><a href="javascript:NewCal('demo2','ddmmyyyy')"><img src="image/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
         
      <td align="left"><form:errors path="END_DATE" cssStyle="color:red"></form:errors>  </td>
     </tr> 
     
     <tr>
      <td width="50" align="right">STATUS</td>
      <td>      
       <form:select path="STATUS">
       
                 <form:option value="Completed" label="Completed"/>
                 <form:option value="Incomplete" label="Incomplete"/>
             </form:select>      
      </td>     
     </tr>

<table width="700" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">      
<tr>   
<td>    
 <div id='TextBoxesGroup'>
 <div id="TextBoxDiv1">
  Question #1 :
<form:textarea cols="29" rows="3" path="QUESTION" />
<br><br>
Answer #1 : &nbsp; 
<form:input path="Answer" id='textbox1' size="50"/>
<br><br>
Answer #2 : &nbsp; 
<form:input path="Answer" id='textbox2' size="50"/>
<br><br>
Answer #3 : &nbsp; 
<form:input path="Answer" id='textbox3' size="50"/>
<br><br>
Answer #4 : &nbsp; 
<form:input path="Answer" id='textbox4' size="50"/>

</div></div>

</tr>
<tr><td colspan="5" align=""><br>
<input type='button' value='Add Question' id='addButton'>&nbsp;&nbsp;
<input type='button' value='Remove Question' id='removeButton'></td></tr>
   
     <tr>
      <td colspan="3" align="center">
      <input type="submit" name="" value="Save">
      &nbsp;&nbsp;
      <input type="reset" name="" value="Reset">
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