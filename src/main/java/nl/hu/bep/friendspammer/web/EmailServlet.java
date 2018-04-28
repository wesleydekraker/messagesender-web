package nl.hu.bep.friendspammer.web;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.bep.friendspammer.helper.Email;
import nl.hu.bep.friendspammer.helper.EmailSender;

public class EmailServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("methode") != null && request.getParameter("methode").equals("email")) {
            Email email = new Email();
            email.setSubject(request.getParameter("onderwerp"));
            email.setTo(Email.splitTo(request.getParameter("aan")));
            email.setMessageBody(request.getParameter("tekst"));
            email.setAsHtml(Boolean.valueOf(request.getParameter("html")));
            
            try {
                EmailSender.sendEmail(email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }        
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}