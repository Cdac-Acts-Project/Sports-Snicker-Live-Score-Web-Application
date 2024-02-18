package com.snicker.api.football.repositories;

import com.snicker.api.football.entity.Football;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballRepo extends JpaRepository<Football,Integer> {
    Optional<Football> findByTeamHeading(String teamHeading);
}
