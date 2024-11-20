package com.example.springproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class CD {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;

    @ManyToOne
    private Artist artist;

    public CD() {}

    public CD(UUID id, String name, Artist artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public CD(String name, Artist artist) {
        this(UUID.randomUUID(), name, artist);
    }
}


