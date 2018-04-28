<%@page import="nl.hu.bep.friendspammer.Email"%>
<%@page import="nl.hu.bep.friendspammer.EmailSender"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if (request.getParameter("methode") != null && request.getParameter("methode").equals("email")) {
	    Email email = new Email();
		email.setSubject(request.getParameter("onderwerp"));
		email.setTo(Email.splitTo(request.getParameter("aan")));
		email.setMessageBody(request.getParameter("tekst"));
		email.setAsHtml(Boolean.valueOf(request.getParameter("html")));
		
		EmailSender.sendEmail(email);	
	}
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
<h1>Friend Spammer!</h1>
<p>Hier kan je email naar al je vrienden! Bij aan kan je één enkele emailadres opgeven maar je kan er ook een comma seperated lijst opgeven.</p>

<form method="post">
	onderwerp: <input type="text" name="onderwerp"/><br/>
	aan: <input type="text" name="aan" value="ee48d7379f-9f0226@inbox.mailtrap.io" size="100"/><br/>
	bericht: <textarea name="tekst" rows="5" cols="60"></textarea><br/>
	verstuur als html?: <input type="checkbox" 	name="html" value="true"/>	<br/>
	email <input type="radio" name="methode" value="email" checked="checked"/> of sms <input type="radio" name="methode" value="sms" disabled/> (sorry sms werkt nog niet)
	<br/>
	<input value="spammen maar!" type="submit">
</form>

<p><a href="history.jsp">history</a	><p>


</body>
</html>