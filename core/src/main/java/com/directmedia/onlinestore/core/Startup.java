package com.directmedia.onlinestore.core;

import com.directmedia.onlinestore.entity.Artist;
import com.directmedia.onlinestore.entity.Work;

import static com.directmedia.onlinestore.entity.Catalog.listOfWorks;

public class Startup {
    public static void main(String... args) {
        setup();
        display();
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

    private static void display() {
        listOfWorks.forEach(work -> {
            String title = work.getTitle();
            int release = work.getRelease();
            System.out.printf("%s (%d)\n", title, release);
        });
    }
}
