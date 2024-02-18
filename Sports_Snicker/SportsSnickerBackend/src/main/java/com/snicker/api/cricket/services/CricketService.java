package com.snicker.api.cricket.services;

import com.snicker.api.cricket.entity.Cricket;

import java.util.List;

public interface CricketService {
    // getAll
    List<Cricket> getAllMatches();
    //getLiveMatch

    List<Cricket> getLiveMatches();

    //getPointTable
    List<List<String>> getPointsTable();
}
