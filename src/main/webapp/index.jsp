<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Email versturen</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header>
		<h1>MessageSender</h1>
	</header>

	<div class="container">
		<nav>
			<ul>
				<li><a href="#" class="active">E-mail versturen</a></li>
				<li><a href="history">Verzonden e-mails</a></li>
			</ul>
		</nav>

		<article>
			<c:if test="${message != null}">
				<div id="message"><c:out value="${message}"/></div>
			</c:if>
			<c:if test="${errors != null}">
				<div id="errors">
				<c:forEach items="${errors}" var="error">
					<ul>
						<li><c:out value="${error}"/></li>
					</ul>
				</c:forEach>
				</div>
			</c:if>
			<h1>E-mail versturen</h1>
			<p>Hier kun je mailen naar al je vrienden! Bij "aan" kan je één enkel e-mailadres opgeven of een comma seperated list.</p>

			<form action="send-email" method="post" id="send-email">
				<div class="row">
					<div class="col-label">
						<label for="fname">Aan</label>
					</div>
					<div class="col-input">
						<input type="text" name="to" placeholder="naam@voorbeeld.nl"
							<c:if test="${param.to != null}">value="<c:out value="${param.to}"/>"</c:if>
							>
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Onderwerp</label>
					</div>
					<div class="col-input">
						<input type="text" name="subject" placeholder="Voorbeeld"
							<c:if test="${param.subject != null}">value="<c:out value="${param.subject}"/>"</c:if>
							>
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Bericht</label>
					</div>
					<div class="col-input">
						<textarea name="messageBody" placeholder="Schrijf iets..." id="messageBody"
							><c:out value="${param.messageBody}"/></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Verstuur als HTML</label>
					</div>
					<div class="col-input">
						<input type="checkbox" name="asHtml"
							<c:if test="${param.asHtml != null}">checked</c:if>
							>
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Methode</label>
					</div>
					<div class="col-input">
						<input type="radio" name="method" value="email" checked="checked" /> Email<br />
						<input type="radio" name="method" value="sms" disabled /> SMS (werkt nog niet)
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Verstuur">
				</div>
			</form>
		</article>
	</div>

	<footer>Copyright &copy; Wesley de Kraker</footer>
</body>
</html>
