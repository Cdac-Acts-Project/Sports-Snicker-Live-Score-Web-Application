package com.snicker.api.cricket.repositories;

import com.snicker.api.cricket.entity.Cricket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CricketRepo extends JpaRepository<Cricket,Integer> {

    Optional<Cricket> findByTeamHeading(String teamHeading);
}
