package com.example.springproject.controller;

import com.example.springproject.dto.CDDTO;
import com.example.springproject.model.Artist;
import com.example.springproject.model.CD;
import com.example.springproject.response.MusicBrainzAPI;
import com.example.springproject.response.MusicBrainzAlbum;
import com.example.springproject.services.ArtistService;
import com.example.springproject.services.CDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class PageController {

    private final CDService cdService;
    private final ArtistService artistService;
    public PageController(CDService cdService, ArtistService artistService) {
        this.cdService = cdService;
        this.artistService = artistService;
    }

    @GetMapping("/home")
    public String getCDTable() {
        return "home";
    }

    @GetMapping("/artistlist")
    public String getListOfArtists(Model model) {
        model.addAttribute("Artists", artistService.getListOfArtists());
        model.addAttribute("tlartist", new Artist());
        return "artists";
    }

   @PostMapping(value = "/artistlist")
    public String addAnArtist(@ModelAttribute("tlartist") Artist artist) {
        artistService.addArtist(artist);
        return "redirect:artistlist";
    }

    @RequestMapping("/cdlist")
    public String getListOfCDs(Model model) {
        model.addAttribute("CDs", cdService.getListOfCDs());
        model.addAttribute("Artist", artistService.getListOfArtists());
        model.addAttribute("tlCDByArtist", new CD());
        return "cds";
    }

    @PostMapping("/cdlist")
    public String addNewCDFromArtist(CDDTO cd){
        cdService.addByName(cd.artist(), cd.toCD());
        return "redirect:cdlist";
    }

//    @RequestMapping("/artist/{artistid}/cdlist")
//    public String getCDListByArtist(Model model, @PathVariable UUID artistid) {
//        Optional<Artist> artistById = artistService.getArtistById(artistid);
//        if (artistById.isPresent()) {
//            model.addAttribute("Artist", artistById
//                        .map(Artist::getArtistName).orElse(""));
//            model.addAttribute("ArtistCDList", cdService.getCDsByArtistId(artistid));
//        }
//        return "artistCdList";
//    }

    @RequestMapping("/artist/{artistid}/cdlist")
    public String getCDListByArtistNew(Model model, @PathVariable UUID artistid) throws Exception {
        Optional<Artist> artistById = artistService.getArtistById(artistid);
        if (artistById.isPresent()) {
            Artist artist = artistById.get();
            String musicBrainzId = artist.getMusicBrainzId();
            List<MusicBrainzAlbum> albums = MusicBrainzAPI.getAlbums(musicBrainzId);
            List<String> titles = albums.stream().map(MusicBrainzAlbum::getTitle).toList();
            model.addAttribute("titles", titles);
        }

        model.addAttribute("Artist", artistById
                .map(Artist::getArtistName).orElse(""));
//        return "artistCdList";
        return "tracks";
    }

//    @RequestMapping("/tracklist")
//    public String getTitles(Model model) throws Exception {
//        String jsonResponse = MusicBrainzAPI.getAlbums();
//        List<String> titles = cdService.getAlbumTitles(jsonResponse);
//        model.addAttribute("titles", titles);
//        return "tracks";
//    }

//    @RequestMapping("/tracklistnew")
//    public String getTitlesxml(Model model) {
//        try {
//            String response = MusicBrainzAPI.getApiResponse("http://musicbrainz.org/ws/2/recording?query=arid:614e3804-7d34-41ba-857f-811bad7c2b7a");
//            NodeList nodeList = XMLParser.parseXML(response);
//            List<String> titles = TitleExtractor.extractTitles(nodeList).;
//            model.addAttribute("titles", titles);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "tracks";
//    }
}
