package com.example.springproject.controller;

import com.example.springproject.dto.CDDTO;
import com.example.springproject.model.Artist;
import com.example.springproject.model.CD;
import com.example.springproject.services.ArtistService;
import com.example.springproject.services.CDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CDController {

    private final CDService cdService;
    private final ArtistService artistService;
    public CDController(CDService cdService, ArtistService artistService) {
        this.cdService = cdService;
        this.artistService = artistService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello, Home!";
    }

    @RequestMapping("/cd")
    public List<CDDTO> getAllCDs() {
        return cdService.getListOfCDs();
    }

    @PostMapping("/artist/{id}/cd")
    void addNewCD(@PathVariable UUID id, @RequestBody CDDTO cd){
        cdService.add(id, cd);
    }

    @PostMapping("/artistname/{name}/cd")
    void addNewCD(@PathVariable String name, @RequestBody CD cd){
        cdService.addByName(name, cd);
    }

    @RequestMapping("/cd/{id}")
    public ResponseEntity<CD> getCDById(@PathVariable UUID id) {
        Optional<CD> optionalCD = cdService.getCDById(id);
        return optionalCD.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping("/artist")
    public ArrayList<Artist> getAllArtists() {
        return artistService.getListOfArtists();
    }

    @PostMapping("/artist")
    void addNewArtist(@RequestBody Artist artist) {
        artistService.addArtist(artist);
    }

    @RequestMapping("/artist/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable UUID id) {
        Optional<Artist> optionalArtist = artistService.getArtistById(id);
        return optionalArtist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @RequestMapping("/artistname/{name}")
    public ResponseEntity<Artist> getArtistByName(@PathVariable String name) {
        Optional<Artist> optionalArtist = artistService.getArtistByName(name);
        return optionalArtist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping("/artistname/{name}/cd")
    public ArrayList<CD> getCDsByArtistName(@PathVariable String name) {
        return cdService.getCDsByArtistName(name);
    }

    @RequestMapping("/artist/{id}/cd")
    public ArrayList<CD> getCDsByArtist(@PathVariable UUID id) {
        return cdService.getCDsByArtistId(id);
    }
}
