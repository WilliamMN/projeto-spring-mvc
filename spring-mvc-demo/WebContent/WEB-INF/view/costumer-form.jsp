<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<title>Costumer Form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="costumer">
		<form:input path="firstName" placeholder="firstname" />
		<form:errors path="firstName" />
		<form:input path="lastName" placeholder="lastname" />
		<form:errors path="lastName" />
		<form:input path="freePasses" placeholder="freePasses" />
		<form:errors path="freePasses" />
		<form:input path="postalCode" placeholder="postalCode" />
		<form:errors path="postalCode" />
		<form:input path="courseCode" placeholder="courseCode" />
		<form:errors path="courseCode" />
		<input type="submit" value="Submit" />
	</form:form>
</body>

</html>