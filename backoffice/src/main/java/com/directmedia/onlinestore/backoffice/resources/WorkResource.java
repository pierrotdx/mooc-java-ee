package com.directmedia.onlinestore.backoffice.resources;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Work;
import static com.directmedia.onlinestore.core.entity.Catalog.listOfWorks;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/work")
public class WorkResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Work> get() {
        if (listOfWorks.isEmpty()) {
            setupCatalogue();
        }
        return listOfWorks;
    }

    private static void setupCatalogue() {
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

    @POST
    public Response add(@FormParam("title") String title, @FormParam("artist") String artistName, @FormParam("release") int release,  @FormParam("genre") String genre, @FormParam("summary") String summary) {
        Work workToAdd = new Work(title);
        Artist artist = new Artist(artistName);
        workToAdd.setMainArtist(artist);
        workToAdd.setRelease(release);
        workToAdd.setGenre(genre);
        workToAdd.setSummary(summary);
        return Response.status(Response.Status.CREATED).build();
    }
}
