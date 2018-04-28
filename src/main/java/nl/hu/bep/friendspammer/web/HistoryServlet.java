package nl.hu.bep.friendspammer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.bep.friendspammer.helper.MongoSaver;

public class HistoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("emails", MongoSaver.getEmails());

        request.getRequestDispatcher("history.jsp").forward(request, response);
      }
}