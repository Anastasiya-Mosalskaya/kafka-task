package com.kafkatask.entity;

public class BookEntity {

    private final int id;
    private final String name;
    private final String author;
    private final String genre;

    public BookEntity(int id, String name, String author, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
