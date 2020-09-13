<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
 <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Page</title>
</head>
<body>
<h3>Save Contact</h3>

<font color='green' > ${success}</font>
<font color='red' > ${fail}</font>
<br>
<a href="/viewContacts">View all Contacts</a>
  
<form:form action="save" method="POST"  modelAttribute="contact">
<table>
 <form:hidden path="cntctid"/>
<tr>
<td><label>Contact Name :</label></td>
 <td><form:input type="text" path="cntctname"></form:input></td>
 </tr>
 <tr>
<td><label>Email :</label></td>
 <td><form:input type="text" path="cntctmail"></form:input></td>
 </tr>
 <tr>
<td><label>Contact Number :</label></td>
 <td><form:input type="text" path="cntctnum"></form:input></td>
 </tr>


</table>
<input type="submit" value="SubmitContact">

</form:form>

</body>
</html>