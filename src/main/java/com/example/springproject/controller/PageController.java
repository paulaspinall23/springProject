package com.example.springproject.controller;

import com.example.springproject.model.CD;
import com.example.springproject.services.CDService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final CDService cdService;
    public PageController(CDService cdService) {
        this.cdService = cdService;
    }
    @GetMapping("/cdtable")
    public String getCDTable(Model model) {
        model.addAttribute("CDTable", cdService.getListOfCDs());
        return "CDList";
    }
}
