package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "workDetails", urlPatterns = { "/work-details" })
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        try {
            Work work = Catalog.getWork(id);
            out.printf(this.getWorkDisplay(work));
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
    }

    private String getWorkDisplay(Work work) {
        String artistName = work.getMainArtist().getName();
        String header = String.format("<h3>%s (<em>%s</em>, %d)</h3>", work.getTitle(), artistName, work.getRelease());
        String subHeader = String.format("<div><em>%s</em><div>", work.getGenre());
        String addToCartForm = this.getAddToCartForm(work);
        String body = String.format("<div>%s</div>%s", work.getSummary(), addToCartForm);
        return String.format("<html><body><article>%s%s%s</article></body></html>", header, subHeader, body);
    }

    private String getAddToCartForm(Work work) {
        String workInput = String.format("<input type=\"hidden\" value=\"%s\">", work.getId());
        String submitInput = "<input type=\"submit\" value=\"Ajouter au caddie\">";
        return String.format("<form action=\"addToCart\" method=\"post\">%s%s</form>", workInput, submitInput);
    }
}
