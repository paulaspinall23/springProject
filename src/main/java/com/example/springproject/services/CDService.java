package com.example.springproject.services;

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
        Artist dire = new Artist("Dire Straits");
        Artist save = artistRepository.save(dire);
        add(new CD("The Very Best Of Electric Light Orchestra", save));
//        add(new CD("Rumours", new Artist("Fleetwood Mac")));
//        add(new CD("The Dark Side of the Moon", new Artist("Pink Floyd")));
//        add(new CD("Brothers In Arms", dire));
//        add(new CD("Money for Nothing", dire));
//        add(new CD("1", new Artist("The Beatles")));
    }

    public ArrayList<CD> getListOfCDs() {
        return new ArrayList<>(cdRepository.findAll());
    }

    public void add(CD cd) {
        cdRepository.save(cd);
    }

    public Optional<CD> getCDById(UUID id) {
        return Optional.of(cdRepository.getReferenceById(id));
    }
}
