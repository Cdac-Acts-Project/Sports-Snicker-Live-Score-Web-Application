package com.snicker.api.hockey.services;

import com.snicker.api.hockey.entity.Hockey;

import java.util.List;

public interface HockeyService {
    List<Hockey> getLiveMatches();

    List<Hockey> getAllMatches();
}
