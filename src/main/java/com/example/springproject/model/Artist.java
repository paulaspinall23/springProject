package com.example.springproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Artist {

    @Id
    private UUID id = UUID.randomUUID();
    private String artist;

    @OneToMany (mappedBy = "artist")
    private List<CD> cds;

    public Artist() {}

    public Artist(UUID id, String artist) {
        this.id = id;
        this.artist = artist;
    }

    public Artist(String artist) {
        this(UUID.randomUUID(), artist);
    }

}


