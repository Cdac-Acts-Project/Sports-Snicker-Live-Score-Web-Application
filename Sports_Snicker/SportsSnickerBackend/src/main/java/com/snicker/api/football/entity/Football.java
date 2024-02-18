package com.snicker.api.football.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "football_info")
public class Football {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;



    private String teamOne;

    private String teamOneScore;

    private String teamTwo;

    private String teamTwoScore;


    private Date date = new Date();

    public Football() {
    }

    public Football(int matchId, String teamHeading, String teamOne, String teamOneScore, String teamTwo, String teamTwoScore, Date date) {
        this.matchId = matchId;
        this.teamHeading = teamHeading;
        this.teamOne = teamOne;
        this.teamOneScore = teamOneScore;
        this.teamTwo = teamTwo;
        this.teamTwoScore = teamTwoScore;
        this.date = date;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeamHeading() {
        return teamHeading;
    }

    public void setTeamHeading(String teamHeading) {
        this.teamHeading = teamHeading;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(String teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(String teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
