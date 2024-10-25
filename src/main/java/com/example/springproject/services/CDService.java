package com.example.springproject.services;

import com.example.springproject.model.CD;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CDService {

    private final Map<UUID, CD> cds = new HashMap<>();

    public CDService() {
        add(new CD("The Very Best Of Electric Light Orchestra", "E.L.O"));
        add(new CD("Rumours", "Fleetwood Mac"));
        add(new CD("The Dark Side of the Moon", "Pink Floyd"));
        add(new CD("Brothers In Arms", "Dire Straits"));
        add(new CD("1", "The Beatles"));
    }

    public ArrayList<CD> getListOfCDs() {
        System.out.println(cds);
        return new ArrayList<>(cds.values());
    }

    public void add(CD cd) {
        cds.put(cd.getId(), cd);
    }

    public Optional<CD> getCDById(UUID id) {
        return Optional.ofNullable(cds.get(id));
    }
}
