package nl.hu.bep.messagesender.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.hu.bep.messagesender.helper.Email;
import nl.hu.bep.messagesender.helper.EmailSender;

public class EmailServlet extends HttpServlet {
    private static final long serialVersionUID = 9126574062113985305L;

    static final Logger logger = LoggerFactory.getLogger(EmailServlet.class);
    
    private static final String INDEX_PAGE = "/index.jsp";
    private static final String MESSAGE = "message";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
        } catch (ServletException | IOException e) {
            StringWriter stackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrace));
            logger.debug(stackTrace.toString());
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {        
        EmailRequest emailRequest = new EmailRequest(request);
        List<String> errors = emailRequest.getErrors();
        
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            
            try {
                request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
            } catch (ServletException | IOException e) {
                StringWriter stackTrace = new StringWriter();
                e.printStackTrace(new PrintWriter(stackTrace));
                logger.debug(stackTrace.toString());
            }
            return;
        }
        
        if (emailRequest.getMethod().equals("email")) {
            Email email = new Email();
            email.setTo(emailRequest.getTo());
            email.setSubject(emailRequest.getSubject());
            email.setMessageBody(emailRequest.getMessageBody());
            email.setAsHtml(emailRequest.getAsHtml());
            
            try {
                EmailSender emailSender = new EmailSender();
                emailSender.sendEmail(email);
                logger.info("Email send!");
                request.setAttribute(MESSAGE, "De e-mail is verstuurd!");
            } catch (MessagingException e) {
                request.setAttribute(MESSAGE, "Er ging iets mis bij het versturen!");                
            }
        } else {
            request.setAttribute(MESSAGE, "De methode SMS wordt nog niet ondersteund!");
        }
        
        try {
            request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
        } catch (ServletException | IOException e) {
            StringWriter stackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrace));
            logger.debug(stackTrace.toString());
        }
    }
}