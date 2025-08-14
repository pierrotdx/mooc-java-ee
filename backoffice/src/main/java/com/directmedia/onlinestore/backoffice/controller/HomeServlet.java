package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "home", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        String welcomeUser = String.format("Bonjour %s", sessionId);

        String catalogLink = "<a href=\"catalogue\">Accès au catalogue des oeuvres</a>";
        String addWorkLink = "<a href=\"add-work-form.html\">Ajouter une oeuvre au catalogue</a>";
        String nav = String.format("<nav><ul><li>%s</li><li>%s</li></ul></nav>", catalogLink, addWorkLink);

        PrintWriter out = resp.getWriter();
        out.printf("<html><body><h1>OnlineStore (backoffice)</h1><div>%s</div><div>%s</div></body></html>", welcomeUser, nav);
    }
}
