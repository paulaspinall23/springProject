package com.example.springproject.controller;

import com.example.springproject.dto.CDDTO;
import com.example.springproject.model.Artist;
import com.example.springproject.model.CD;
import com.example.springproject.services.ArtistService;
import com.example.springproject.services.CDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PageController {

    private final CDService cdService;
    private final ArtistService artistService;
    public PageController(CDService cdService, ArtistService artistService) {
        this.cdService = cdService;
        this.artistService = artistService;
    }
    @GetMapping("/cdtable")
    public String getCDTable(Model model) {
        model.addAttribute("CDTable", artistService.getListOfArtists());
//        model.addAttribute("CDTable", artistService.getListOfArtists());
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

    @PostMapping("/cdlist/cd")
    public String addNewCDFromArtist(@ModelAttribute("tlCDByArtist") String artist, CD cd){
        cdService.addByName(artist, cd);
        return "redirect:cds";
    }

    @RequestMapping("/artist/{artistid}/cdlist")
    public String getCDListByArtist(Model model, @PathVariable UUID artistid) {
        model.addAttribute("ArtistCDList", cdService.getCDsByArtistId(artistid));
        return "artistCdList";
    }


}
