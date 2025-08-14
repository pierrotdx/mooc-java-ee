package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "workAddedFailure", urlPatterns = { "/work-added-failure" })
public class WorkAddedFailureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "<div>Une erreur est survenue. L'oeuvre n'a pas été ajoutée.</div>";
        String redirectLink = "<a href=\"home\">Retour à la page d'accueil</a>";
        String htmlPage = String.format("<html><body>%s%s</body></html>", message, redirectLink);

        PrintWriter out = resp.getWriter();
        out.print(htmlPage);
    }
}
