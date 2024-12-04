package com.example.springproject.services;

import com.example.springproject.dto.CDDTO;
import com.example.springproject.model.Artist;
import com.example.springproject.model.CD;
import com.example.springproject.repository.ArtistRepository;
import com.example.springproject.repository.CDRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CDService {

    private final CDRepository cdRepository;
    private final ArtistRepository artistRepository;

    public CDService(CDRepository cdRepository, ArtistRepository artistRepository) {
        this.cdRepository = cdRepository;
        this.artistRepository = artistRepository;
    }

    public List<CDDTO> getListOfCDs() {
        return cdRepository.findAll()
                .stream()
                .map(CDDTO::new)
                .toList();
    }

    public void add(UUID id, CDDTO cddto) {
        CD cd = cddto.toCD();
        Artist artist = artistRepository.findById(id).orElseThrow();
        cd.setArtist(artist);
        cdRepository.save(cd);
    }
    
    public void addByName(String name, CD cd) {
        Artist artist = artistRepository.findByArtistName(name).orElseThrow();
        cd.setArtist(artist);
        cdRepository.save(cd);
    }

    public Optional<CD> getCDById(UUID id) {
        return cdRepository.findById(id);
    }

    public ArrayList<CD> getCDsByArtistId(UUID id) {
        return new ArrayList<>(cdRepository.findByArtistId(id));
    }

    public ArrayList<CD> getCDsByArtistName(String name) {
        Artist artistId = artistRepository.findByArtistName(name).orElseThrow();
        return new ArrayList<>(cdRepository.findByArtistId(artistId.getId()));
    }
}
