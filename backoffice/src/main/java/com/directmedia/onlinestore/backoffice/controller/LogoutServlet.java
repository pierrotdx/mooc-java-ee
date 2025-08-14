package com.directmedia.onlinestore.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logout", urlPatterns = { "/logout"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        String htmlPage = "<html><body>Vous avez été déconnecté(e). Cliquez <a href=\"login.html\">ici</a> pour vous reconnecter</body></html>.";

        PrintWriter out = resp.getWriter();
        out.print(htmlPage);
    }
}
