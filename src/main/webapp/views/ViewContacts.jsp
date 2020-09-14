<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view All contacts</title>
</head>
<body>
<script type="text/javascript">
function deleteConfirm(){

	return confirm("Are you sure you want to delete click OK")
}
</script>
<h3>View All Contacts</h3>
<br>
<a href="/show">+Add New Contact</a>
<c:choose>
<c:when test="${!empty contacts}">
<font color='green' > ${status}</font>
<table border="1">
<tr>
<th>ContactName</th>

<th>ContactNumber</th>

<th>Email</th>

<th>Action</th>
</tr>
<c:forEach items="${contacts}" var="contact">

<tr>
<td>${contact.cntctname}</td>
<td>${contact.cntctnum}</td>
<td>${contact.cntctmail}</td>

<td><a href="/editContact?contact_id= ${contact.cntctid}">EDIT</a>
|<a href="/deleteContact?contact_id= ${contact.cntctid}" onclick="return deleteConfirm()">DELETE</a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>

<h4> <font color='red' >data not found </font></h4>
</c:otherwise>
</c:choose>

</body>
</html>