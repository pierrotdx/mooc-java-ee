package com.directmedia.onlinestore.core.entity;

public class Work {
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;

    private static int lastId = 0;
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Artist getMainArtist() {
        return mainArtist;
    }

    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }

    public Work() {
        this.createId();
    }

    public Work(String title) {
        this.createId();
        this.setTitle(title);
    }

    public long getId() {
        return id;
    }

    public  void setId(long id) {
        this.id = id;
    }

    private void createId() {
        lastId++;
        this.setId(lastId);
    }
}
