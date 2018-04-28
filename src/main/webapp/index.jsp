<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
<h1>Friend Spammer!</h1>
<p>Hier kan je email naar al je vrienden! Bij aan kan je één enkele emailadres opgeven maar je kan er ook een comma seperated lijst opgeven.</p>

<form action="EmailServlet" method="post">
	aan: <input type="text" name="to" value="naam@voorbeeld.nl" size="100"/><br/>
	onderwerp: <input type="text" name="subject"/><br/>
	bericht: <textarea name="messageBody" rows="5" cols="60"></textarea><br/>
	verstuur als html?: <input type="checkbox" 	name="asHtml" value="true"/>	<br/>
	email <input type="radio" name="methode" value="email" checked="checked"/> of sms <input type="radio" name="methode" value="sms" disabled/> (sorry sms werkt nog niet)
	<br/>
	<input value="spammen maar!" type="submit">
</form>

<p><a href="HistoryServlet">history</a	><p>


</body>
</html>