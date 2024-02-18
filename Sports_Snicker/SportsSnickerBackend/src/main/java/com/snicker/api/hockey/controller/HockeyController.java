package com.snicker.api.hockey.controller;

import com.snicker.api.hockey.entity.Hockey;
import com.snicker.api.hockey.services.HockeyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hockey")
@CrossOrigin("*")
public class HockeyController {

    private HockeyService hockeyService;

    public HockeyController(HockeyService hockeyService) {
        this.hockeyService = hockeyService;
    }

    @GetMapping("/live")
    ResponseEntity<List<Hockey>> getLiveMatches(){
        return new ResponseEntity<>(hockeyService.getLiveMatches(), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Hockey>> getALLMatches(){
        return new ResponseEntity<>(hockeyService.getAllMatches(), HttpStatus.OK);
    }
}
