<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Verzonden berichten!</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header>
		<h1>FriendSpammer</h1>
	</header>

	<div class="container">
		<nav>
			<ul>
				<li><a href=".">E-mail versturen</a></li>
				<li><a href="#" class="active">Verzonden e-mails</a></li>
			</ul>
		</nav>

		<article>
			<h1>Verzonden e-mails</h1>
			<table id="history">
				<tr>
					<th>Aan</th>
					<th>Van</th>
					<th>Onderwerp</th>
					<th>Bericht</th>
					<th>HTML</th>
				</tr>
				<c:forEach items="${emails}" var="email">
					<tr>
						<td><c:forEach items="${email.to}" var="to">
								<c:out value="${to}" /><br>
							</c:forEach></td>
						<td><c:out value="${email.from}" /></td>
						<td><c:out value="${email.subject}" /></td>
						<td><c:out value="${email.messageBody}" /></td>
						<td><c:out value="${email.asHtml}" /></td>
					</tr>
				</c:forEach>
			</table>
		</article>
	</div>
	
	<footer>Copyright &copy; Wesley de Kraker</footer>
</body>
</html>
