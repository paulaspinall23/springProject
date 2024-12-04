package com.example.springproject.dto;

import com.example.springproject.model.CD;
import java.util.UUID;

public record CDDTO(UUID id, String name, String artist) {

    public CDDTO(CD cd) {
        this(cd.getId(), cd.getName(), cd.getArtist().getArtistName());
    }

    public CD toCD() {
        CD cd = new CD();
        cd.setName(this.name);
        cd.setId(this.id);
        return cd;
    }
}
