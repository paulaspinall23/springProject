package com.example.springproject.controller;

import com.example.springproject.model.CD;
import com.example.springproject.services.CDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CDController {

    private final CDService cdService;
    public CDController(CDService cdService) {
        this.cdService = cdService;
    }


    @GetMapping("/")
    public String home() {
        return "Hello, Home!";
    }

    @RequestMapping("/cd")
    public ArrayList<CD> getAllCDs() {
        return cdService.getListOfCDs();
    }

    @RequestMapping("/cd/{id}")
    public ResponseEntity<CD> getCDById(@PathVariable UUID id) {
        Optional<CD> optionalCD = cdService.getCDById(id);
        return optionalCD.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cd")
    void addNewCD(@RequestBody CD cd){
        cdService.add(cd);
    }
}
