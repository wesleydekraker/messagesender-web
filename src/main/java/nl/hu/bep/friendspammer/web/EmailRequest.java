package nl.hu.bep.friendspammer.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nl.hu.bep.friendspammer.helper.Email;

public class EmailRequest {
    private String method;
    private List<String> to;
    private String subject;
    private String messageBody;
    private boolean asHtml;
    
    private List<String> errors = new ArrayList<>();
    
    public EmailRequest(HttpServletRequest request) {
        setMethod(request.getParameter("method"));
        setTo(request.getParameter("to"));
        setSubject(request.getParameter("subject"));
        setMessageBody(request.getParameter("messageBody"));
        setAsHtml(request.getParameter("asHtml"));
    }
    
    public String getMethod() {
        return method;
    }
    
    private void setMethod(String method) {        
        if (isEmpty(method)) {
            errors.add("De methode is niet ingevuld!");
            return;
        }
        
        if (!method.equals("email") && !method.equals("sms")) {
            errors.add("De methode is niet ingevuld!");
            return;
        }
        
        this.method = method;
    }
    
    public List<String> getTo() {
        return to;
    }
    
    private void setTo(String to) {
        if (isEmpty(to)) {
            errors.add("Het veld \"Aan\" is niet ingevuld!");
            return;
        }
        
        List<String> emailAddresses = Email.splitTo(to);
        for (String emailAddress: emailAddresses) {
            if (Email.isValidEmailAddress(emailAddress)) {
                addTo(emailAddress);
                continue;
            }
            
            errors.add("Het volgende e-mailadres is invalide: " + emailAddress);
        }
    }
    
    private void addTo(String to) {
        if (this.to == null) {
            this.to = new ArrayList<>();
        }
        this.to.add(to);
    }
    
    public String getSubject() {
        return subject;
    }
    
    private void setSubject(String subject) {
        if (isEmpty(subject)) {
            errors.add("Het veld \"Onderwerp\" is niet ingevuld!");
            return;
        }
        
        this.subject = subject;
    }
    
    public String getMessageBody() {
        return messageBody;
    }
    
    private void setMessageBody(String messageBody) {
        if (isEmpty(messageBody)) {
            errors.add("Het veld \"Bericht\" is niet ingevuld!");
            return;
        }
        
        this.messageBody = messageBody;
    }
    
    public boolean getAsHtml() {
        return asHtml;
    }
    
    private void setAsHtml(String asHtml) {
        this.asHtml = asHtml != null;
    }    

    public List<String> getErrors() {
        return errors;
    }
    
    private boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
      }
}
