package com.learnMaven.model;

import java.util.Map;

// A model based on the GSON example to store our movie data

public class Movie {

    private String title;
    private String year;
    private String rated;
    private String released;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private Map<String, String> properties;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return this.rated;
    }

    public void setRating(String rating) {
        this.rated = rating;
    }

    public String getReleased() {
        return this.released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return this.actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return this.plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String toString() {
        // method from the gson example for printing data
        StringBuilder sb = new StringBuilder();
        sb.append("**********Movie Details************\n");
        sb.append("Title: " + getTitle() + "\n");
        sb.append("Year: " + getYear() + "\n");
        sb.append("Rated: " + getRating() + "\n");
        sb.append("Released: " + getReleased() + "\n");
        sb.append("Genre(s): " + getGenre() + "\n");
        sb.append("Director(s): " + getDirector() + "\n");
        sb.append("Writer(s): " + getWriter() + "\n");
        sb.append("Actor(s): " + getActors() + "\n");
        sb.append("Plot: " + getPlot() + "\n");

        return sb.toString();
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
