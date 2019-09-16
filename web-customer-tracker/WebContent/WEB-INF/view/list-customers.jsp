<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
<div id="header">
<h2>CRM- Customer Relation Manager</h2> 
</div>
</div>



<div id="container">

<div id="content">
<input type="button" value="Add Customer" onclick="window.location.href='customerform'; return false;"
		class="add-button"/> 

<table>
<tr>
	<th>Firstname</th>
	<th>Lastname</th>
	<th>Email</th>
</tr>

 <c:forEach var="item" items="${customers}">
 <c:url var="updateLink" value="/customer/showFormForUpdate">
 	<c:param name="customerId" value="${item.id}"/>
 </c:url>
 
 <c:url var="deleteLink" value="/customer/deleteFormForUpdate">
 	<c:param name="customerId" value="${item.id}"/>
 </c:url>
 
	<tr>
	<td>${item.firstName}</td>
	<td>${item.lastName}</td>
	<td>${item.email}</td>
	<td><a href="${updateLink}">Update</a>|<a href="${deleteLink}" onclick="if(!(confirm('Are you Sure  to delete?'))) return false">Delete</a></td>
	</tr>
 </c:forEach>
</table>
</div>
</div>

</body>
</html>