<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form</title>
</head>
<link rel="stylesheet" href="css/bootstrap.css">

<script type="text/javascript">
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      contactName: "required",
      contactNumber: "required",
      contactEmail: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        contactEmail: true
      },
     },
    // Specify validation error messages
    messages: {
    	contactName: "Please enter your firstname",
    	contactNumber: "Please enter phone number"
    	contactEmail: "Please enter a valid email address"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});

</script>
<body>
	<h2>Save Contact</h2>
	<p>
		<font color="green">${SuccessMsg}</font>
	</p>
	<p>
		<font color="red">${errMsg}</font>
	</p>
	
	<form:form action="saveContact" name="registration" modelAttribute="contact" method="POST">
		<table>
			<tr>
			    <form:hidden path="contactId"/>
				<td>Contact Name :</td>
				<td><form:input name = "contactName" path="contactName" label="Enter your first name:"/></td>
			</tr>
	    	<tr>
				<td>Contact Email :</td>
				<td><form:input name = "contactEmail" path="contactEmail" label="Enter your Email:"/></td>
			</tr>
			<tr>
				<td>Contact Number :</td>
				<td><form:input name = "contactNumber" path="contactNumber" label="Enter your number:"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type= "submit" value="save"/></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContact">View All Contacts</a>
	</body>
</html>