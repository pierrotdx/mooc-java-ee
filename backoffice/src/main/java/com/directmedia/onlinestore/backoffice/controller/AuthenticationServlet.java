package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "authenticationServlet", urlPatterns = { "/login" })
public class AuthenticationServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        boolean isSuccess = this.areValidCredentials(id, password);

        this.sendResponse(resp, isSuccess);
    }

    private boolean areValidCredentials(String id, String password) {
        if (id.equalsIgnoreCase("michel")) {
            return password.equals("123456");
        };
        if (id.equalsIgnoreCase("caroline")) {
            return password.equals("abcdef");
        }
        return false;
    }

    private void sendResponse(HttpServletResponse resp, boolean isSuccess) throws IOException {
        resp.setContentType("text/html");

        String message = isSuccess ? "<div>Vous êtes authentifié(e) avec succès.</div>" : "<div>Identifiant et/ou mot de passe erroné(s)</div>";
        String redirectionLink = isSuccess ? "<a href=\"home\">Accéder à la page d'accueil</a>" : "<a href=\"login.html\">Réessayer</a>";

        String htmlPage = String.format("<html><body>%s%s</body></html>", message , redirectionLink);

        PrintWriter out = resp.getWriter();
        out.print(htmlPage);
    }
}
