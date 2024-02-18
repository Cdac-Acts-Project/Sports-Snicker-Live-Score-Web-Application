package com.snicker.api.hockey.entity;

import com.snicker.api.helper.MatchStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "hockey_info")
public class Hockey {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;
    private String matchNumberVenue;

    private String homeTeam;
    private String awayTeam;

    private String homeTeamScore;
    private String awayTeamScore;

    private String liveTimer;
    private String matchLink;

    private String textComplete;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;
    public void setStatus(String matchStatus) {
        if ("Live".equalsIgnoreCase(matchStatus)) {
            this.status = MatchStatus.LIVE;
        } else {
            this.status = MatchStatus.COMPLETED;
        }
    }

    public Hockey(int matchId, String teamHeading, String matchNumberVenue, String homeTeam, String awayTeam, String homeTeamScore, String awayTeamScore, String liveTimer, String matchLink, String textComplete, MatchStatus status) {
        this.matchId = matchId;
        this.teamHeading = teamHeading;
        this.matchNumberVenue = matchNumberVenue;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.liveTimer = liveTimer;
        this.matchLink = matchLink;
        this.textComplete = textComplete;
        this.status = status;
    }

    public Hockey() {
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

    public String getMatchNumberVenue() {
        return matchNumberVenue;
    }

    public void setMatchNumberVenue(String matchNumberVenue) {
        this.matchNumberVenue = matchNumberVenue;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(String homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(String awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getLiveTimer() {
        return liveTimer;
    }

    public void setLiveTimer(String liveTimer) {
        this.liveTimer = liveTimer;
    }

    public String getMatchLink() {
        return matchLink;
    }

    public void setMatchLink(String matchLink) {
        this.matchLink = matchLink;
    }

    public String getTextComplete() {
        return textComplete;
    }

    public void setTextComplete(String textComplete) {
        this.textComplete = textComplete;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }
}
