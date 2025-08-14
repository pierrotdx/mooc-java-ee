package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "addWork", urlPatterns = { "/add-work" })
public class AddWorkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            String artistName = req.getParameter("artist");
            int release = Integer.parseInt(req.getParameter("release"));
            String genre = req.getParameter("genre");
            String summary = req.getParameter("summary");

            Work workToAdd = this.getWorkToAdd(title, artistName, release, genre, summary);
            Catalog.listOfWorks.add(workToAdd);

            RequestDispatcher disp = req.getRequestDispatcher("/work-added-success");
            disp.forward(req, resp);
        } catch (Exception exception) {
            RequestDispatcher disp = req.getRequestDispatcher("/work-added-failure");
            disp.forward(req, resp);
        }
    }

    private Work getWorkToAdd(String title, String artistName, int release, String genre, String summary) {
        Work workToAdd = new Work(title);
        Artist artist = new Artist(artistName);
        workToAdd.setMainArtist(artist);
        workToAdd.setRelease(release);
        workToAdd.setSummary(summary);
        workToAdd.setGenre(genre);
        return workToAdd;
    }

}
