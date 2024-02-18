package com.snicker.api.football.controller;

import com.snicker.api.football.entity.Football;
import com.snicker.api.football.services.FootballService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/football")
@CrossOrigin("*")

public class FootballController {
    private FootballService footballService;

    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping
    public ResponseEntity<List<Football>> getAllMatches() {
        return new ResponseEntity<>(this.footballService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/live")
    public ResponseEntity<List<Football>> getLiveMatchScores()  {
       // System.out.println("getting live match");
        return new ResponseEntity<List<Football>>(this.footballService.getLiveMatches(), HttpStatus.OK);
    }

   
}
