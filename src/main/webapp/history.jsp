<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Al verstuurde berichten!</title>
</head>
<body>
	<p>Alle verstuurde berichten</p>
	<table border="1">
		<thead>
			<tr>
				<td>Aan:</td>
				<td>Van:</td>
				<td>Onderwerp:</td>
				<td>Text:</td>
				<td>HTML:</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emails}" var="email">
			<tr>
				<td>${email.to}</td>
				<td>${email.from}</td>
				<td>${email.subject}</td>
				<td>${email.messageBody}</td>
				<td>${email.asHtml}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>