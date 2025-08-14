<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@page import="com.directmedia.onlinestore.core.entity.Artist" %>
<%@page import="com.directmedia.onlinestore.core.entity.Work" %>
<%@page import="com.directmedia.onlinestore.core.entity.Catalog" %>

<%
    if (Catalog.listOfWorks.isEmpty()) {
        Work work1 = new Work("Le Comte de Monte-Cristo");
        Artist dumas = new Artist("Alexandre Dumas");
        work1.setMainArtist(dumas);
        work1.setGenre("roman");
        work1.setRelease(1846);
        work1.setSummary("L'histoire de vengeance d'Edmond Dantès.");
        Catalog.listOfWorks.add(work1);

        Work work2 = new Work("Les Misérables");
        Artist hugo = new Artist("Victor Hugo");
        work2.setMainArtist(hugo);
        work2.setGenre("roman");
        work2.setRelease(1862);
        work2.setSummary("L'histoire de repentance de Jean Valjean.");
        Catalog.listOfWorks.add(work2);

        Work work3 = new Work("Le Parrain");
        Artist coppola = new Artist("Francis Ford Coppola");
        work3.setMainArtist(coppola);
        work3.setGenre("film");
        work3.setRelease(1972);
        work3.setSummary("L'histoire de damnation Michael Corleone.");
        Catalog.listOfWorks.add(work3);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Catalogue</title>
    </head>
    <body>
        <ul>
            <%
                for (Work work : Catalog.listOfWorks) {
                    String title = work.getTitle();
                    int release = work.getRelease();
            %>
                <li><%= title %> (<%= release %>)</li>
            <% } %>
        </ul>
    </body>
</html>
