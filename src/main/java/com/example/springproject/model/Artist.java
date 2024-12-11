package com.example.springproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Artist {

    @Id
    private UUID id = UUID.randomUUID();
    private String artistName;
    private String musicBrainzId;

    @OneToMany (mappedBy = "artist", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CD> cds = new ArrayList<>();

    public Artist() {}


    public Artist(UUID id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public Artist(String artistName) {
        this(UUID.randomUUID(), artistName);
    }
}


