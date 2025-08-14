package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.directmedia.onlinestore.core.entity.Catalog.listOfWorks;

@WebServlet(name = "catalogue", urlPatterns = { "/catalogue" })
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (listOfWorks.size() == 0) {
            setup();
        }
        PrintWriter out = resp.getWriter();
        display(out);
    }

    private static void setup() {
        Work work1 = new Work("Le Comte de Monte-Cristo");
        Artist dumas = new Artist("Alexandre Dumas");
        work1.setMainArtist(dumas);
        work1.setGenre("roman");
        work1.setRelease(1846);
        work1.setSummary("L'histoire de vengeance d'Edmond Dantès.");
        listOfWorks.add(work1);

        Work work2 = new Work("Les Misérables");
        Artist hugo = new Artist("Victor Hugo");
        work2.setMainArtist(hugo);
        work2.setGenre("roman");
        work2.setRelease(1862);
        work2.setSummary("L'histoire de repentance de Jean Valjean.");
        listOfWorks.add(work2);

        Work work3 = new Work("Le Parrain");
        Artist coppola = new Artist("Francis Ford Coppola");
        work3.setMainArtist(coppola);
        work3.setGenre("film");
        work3.setRelease(1972);
        listOfWorks.add(work3);
        work3.setSummary("L'histoire de damnation Michael Corleone.");
    }

    private static void display(PrintWriter out) {
        listOfWorks.forEach(work -> {
            String title = work.getTitle();
            int release = work.getRelease();
            long id = work.getId();
            out.printf("<a href=\"work-details?id=%d%n\">%s (%d)</a><br/>", id, title, release);
        });
    }
}
