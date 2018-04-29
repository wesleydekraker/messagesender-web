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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String method = request.getParameter("method");
        
        if (method == null) {
            request.setAttribute("message", "De methode is niet ingevuld!");
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        
        if (!method.equals("email") && !method.equals("sms")) {
            request.setAttribute("message", "De ingevoerde methode bestaat niet!");
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        
        if (method.equals("sms")) {
            request.setAttribute("message", "De methode SMS wordt niet ondersteud!");
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        
        if (method.equals("email")) {
            Email email = new Email();
            email.setTo(Email.splitTo(request.getParameter("to")));
            email.setSubject(request.getParameter("subject"));
            email.setMessageBody(request.getParameter("messageBody"));
            email.setAsHtml(Boolean.valueOf(request.getParameter("asHtml")));
            
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