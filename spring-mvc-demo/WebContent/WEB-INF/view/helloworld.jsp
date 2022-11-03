<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
		<title>Hello World - Input Form</title>
	</head>
	<body>
		<div class="hello-row">
			<div class="hello-column">
				<p>Hello World of Spring!</p>
				<p>Student name: <span style="color: red">${param.studentName}</span></p>
				<p>The message: <span style="color: red">${message}</span>.</p>
			</div>
		</div>
	</body>
</html>