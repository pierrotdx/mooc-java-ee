package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "workDetails", urlPatterns = { "/work-details" })
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        long id = Long.parseLong(idParam);
        try {
            Work work = Catalog.getWork(id);
            req.setAttribute("work", work);
            RequestDispatcher disp = req.getRequestDispatcher("/work-details.jsp");
            disp.forward(req, resp);
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
    }
}
