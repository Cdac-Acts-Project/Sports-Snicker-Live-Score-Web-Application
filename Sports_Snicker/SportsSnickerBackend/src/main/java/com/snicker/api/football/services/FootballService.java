package com.snicker.api.football.services;

import com.snicker.api.football.entity.Football;

import java.util.List;

public interface FootballService {
    // getAll
    List<Football> getAllMatches();

    //getLiveMatch
    List<Football> getLiveMatches();
}
