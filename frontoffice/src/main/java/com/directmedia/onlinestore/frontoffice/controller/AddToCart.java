package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addToCart", urlPatterns = { "/addToCart" })
public class AddToCart extends HttpServlet {
    final String shoppingCartAttribute = "shoppingCart";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Work work = this.getWork(req);
        ShoppingCart shoppingCart = this.getShoppingCart(req);
        shoppingCart.getItems().add(work);
        this.sendResponse(resp, shoppingCart);
    }

    private Work getWork(HttpServletRequest req) throws ServletException {
        long workId = Long.parseLong(req.getParameter("workId"));
        try {
           return  Catalog.getWork(workId);
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
    }

    private ShoppingCart getShoppingCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(this.shoppingCartAttribute);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            session.setAttribute(this.shoppingCartAttribute, shoppingCart);
        }
        return shoppingCart;
    }

    private void sendResponse(HttpServletResponse resp, ShoppingCart shoppingCart) throws IOException {
        int nbItems = shoppingCart.getItems().size();
        String message = String.format("<div>Oeuvre ajoutée au caddie (%d)</div>", nbItems);

        String catalogLink = "<div><a href=\"catalogue\">Retour au catalogue</a></div>";

        String htmlPage = String.format("<html><body>%s%s</body></html>", message, catalogLink);

        PrintWriter out = resp.getWriter();
        out.print(htmlPage);
    }

}
