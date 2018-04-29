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
		<h1>FriendSpammer</h1>
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
				<div id="message">${message}</div>
			</c:if>
			<h1>E-mail versturen</h1>
			<p>Hier kun je mailen naar al je vrienden! Bij "aan" kan je één enkel e-mailadres opgeven of een comma seperated list.</p>

			<form action="send-email" method="post" id="send-email">
				<div class="row">
					<div class="col-label">
						<label for="fname">Aan</label>
					</div>
					<div class="col-input">
						<input type="text" name="to" placeholder="naam@voorbeeld.nl">
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Onderwerp</label>
					</div>
					<div class="col-input">
						<input type="text" name="subject" placeholder="Voorbeeld">
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Bericht</label>
					</div>
					<div class="col-input">
						<textarea name="messageBody" placeholder="Schrijf iets..." id="messageBody"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Verstuur als HTML</label>
					</div>
					<div class="col-input">
						<input type="checkbox" name="asHtml" value="true" />
					</div>
				</div>
				<div class="row">
					<div class="col-label">
						<label>Methode</label>
					</div>
					<div class="col-input">
						Email <input type="radio" name="method" value="email" checked="checked" /><br />
						SMS <input type="radio" name="method" value="sms" disabled /> * werkt nog niet
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
