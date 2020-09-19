<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contact List</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript">
	function checkIt() {
		alert('Are you really sure you want to delete the contact?');
	}
</script>
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
</head>
<body>
	<a href="addContact"> Add New Contact</a>
	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>PhoneNumber</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contact}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?id=${c.contactId }">Edit</a> || <a
						href="deleteContact?id=${c.contactId}" onclick="checkIt()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>