<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>	
	</head>
	<body>
		The Student is confirmed: ${student.firstName} ${student.lastName} from ${student.country} likes ${student.favoriteLanguage} and prefers
		 use these operating systems:
		 <ul>
		 	<c:forEach var="item" items="${student.operatingSystems}">
		 		<li>${item}</li>
		 	</c:forEach>
		 </ul>
	</body>
</html>