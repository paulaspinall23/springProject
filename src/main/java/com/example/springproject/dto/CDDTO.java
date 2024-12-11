package com.example.springproject.dto;

import com.example.springproject.model.Artist;
import com.example.springproject.model.CD;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
public class CDDTO {
    private UUID id;
    private String name;
    private String artist;

    public CDDTO() {
    }

    public CDDTO(UUID id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public CDDTO(CD cd) {
        this(cd.getId(), cd.getName(), cd.getArtist().getArtistName());
    }

    public CD toCD() {
        CD cd = new CD();
        cd.setName(this.name);
        if (this.id != null) {
            cd.setId(this.id);
        }
        return cd;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String artist() {
        return artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CDDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist);
    }

    @Override
    public String toString() {
        return "CDDTO[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "artist=" + artist + ']';
    }


    //    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
}
