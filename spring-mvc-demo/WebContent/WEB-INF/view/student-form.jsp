<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html class="student-form-body">
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<title>Student Registration Form</title>
</head>

<body class="student-form-body">

	<form:form action="processForm" modelAttribute="student">
		<div class="student-form-column">
			<form:input class="student-form-input-text" path="firstName"
				placeholder="First name" />
			<form:input class="student-form-input-text" path="lastName"
				placeholder="Last name" />
			<div>
				Country:
				<form:select path="country">
					<form:options items="${theCountryOptions}" />
				</form:select>
			</div>
			<div>
				<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
			</div>
			<input class="student-form-input-button" type="submit" value="Submit">
		</div>
	</form:form>

</body>
</html>