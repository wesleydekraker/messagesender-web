package nl.hu.bep.friendspammer.web;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.bep.friendspammer.helper.Email;
import nl.hu.bep.friendspammer.helper.EmailSender;

public class EmailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {        
        EmailRequest emailRequest = new EmailRequest(request);
        List<String> errors = emailRequest.getErrors();
        
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        if (emailRequest.getMethod().equals("email")) {
            Email email = new Email();
            email.setTo(emailRequest.getTo());
            email.setSubject(emailRequest.getSubject());
            email.setMessageBody(emailRequest.getMessageBody());
            email.setAsHtml(emailRequest.getAsHtml());
            
            try {
                EmailSender.sendEmail(email);
                request.setAttribute("message", "De e-mail is verstuurd!");
            } catch (MessagingException e) {
                e.printStackTrace();
                request.setAttribute("message", "Er ging iets mis bij het versturen!");                
            }
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}