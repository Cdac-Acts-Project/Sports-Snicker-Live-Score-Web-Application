package com.snicker.api.cricket.controller;

import com.snicker.api.cricket.entity.Cricket;
import com.snicker.api.cricket.services.CricketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cricket")
@CrossOrigin("*")
public class CricketController {

    private CricketService cricketService;

    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @GetMapping("/live")
    public ResponseEntity<?> getLiveMatchScores()  {

        return new ResponseEntity<>(this.cricketService.getLiveMatches(), HttpStatus.OK);
    }

    @GetMapping("/point-table")
    public ResponseEntity<?> getPointsTable() {
        return new ResponseEntity<>(this.cricketService.getPointsTable(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cricket>> getAllMatches() {
        return new ResponseEntity<>(this.cricketService.getAllMatches(), HttpStatus.OK);
    }
}
