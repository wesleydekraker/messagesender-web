package nl.hu.bep.friendspammer.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.hu.bep.friendspammer.helper.MongoRepository;

public class HistoryServlet extends HttpServlet {
    static final Logger logger = LoggerFactory.getLogger(HistoryServlet.class);
    
    private static final String HISTORY_PAGE = "/history.jsp";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        MongoRepository mongoRepository = new MongoRepository();
        request.setAttribute("emails", mongoRepository.getEmails());
        
        try {
            request.getRequestDispatcher(HISTORY_PAGE).forward(request, response);
        } catch (ServletException | IOException e) {
            StringWriter stackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrace));
            logger.debug(stackTrace.toString());
        }
      }
}