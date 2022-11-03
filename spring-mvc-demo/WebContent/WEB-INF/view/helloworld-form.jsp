<!DOCTYPE html>
<html class="hello-form-html">
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
		<title>Hello World - Input Form</title>
	</head>
	<body class="hello-form-body">
		<form action="processFormVersionTwo" method="GET">
			<div>
				<input class="hello-form-input-text" type="text" name="studentName" placeholder="What's your name?">
				<input class="hello-form-input-button" type="submit" value="Submit"/>
			</div>
		</form>
	</body>
</html>