package com.example.springproject.services;

import com.example.springproject.model.Artist;
import com.example.springproject.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    public ArrayList<Artist> getListOfArtists() {
        return new ArrayList<>(artistRepository.findAll());
    }

    public Optional<Artist> getArtistById(UUID id) {
        return artistRepository.findById(id);
    }

    public Optional<Artist> getArtistByName(String name) {
        return artistRepository.findByArtistName(name);
    }
}
