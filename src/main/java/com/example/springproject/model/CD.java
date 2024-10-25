package com.example.springproject.model;

import java.util.UUID;

public class CD {
    private String name;
    private String artist;
    private UUID id = UUID.randomUUID();

    public CD() {
    }

    public CD(String name, String artist, UUID id) {
        this.name = name;
        this.artist = artist;
        this.id = id;
    }

    public CD(String name, String artist) {
        this(name, artist, UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}


