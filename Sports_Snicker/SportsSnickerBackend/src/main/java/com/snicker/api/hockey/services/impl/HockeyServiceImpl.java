package com.snicker.api.hockey.services.impl;

import com.snicker.api.hockey.entity.Hockey;
import com.snicker.api.hockey.repositories.HockeyRepo;
import com.snicker.api.hockey.services.HockeyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HockeyServiceImpl implements HockeyService {

    private HockeyRepo hockeyRepo;

    public HockeyServiceImpl(HockeyRepo hockeyRepo) {
        this.hockeyRepo = hockeyRepo;
    }

    @Override
    public List<Hockey> getLiveMatches() {
        List<Hockey> matches = new ArrayList<>();

        try {
            String url = "https://www.fih.hockey/schedule-fixtures-results";
            Document document = Jsoup.connect(url).get();

            Elements liveScoreElements = document.select("li.live");
            for (Element matchElement : liveScoreElements) {

                //div.event__title
                //String leagueHeading=matchElement.select("div.fixtures-head > h4.fixtures-title").text();


                String matchVenue=matchElement.select("p.venue").text();
                String homeTeam=matchElement.select("div.team-info > p.team-name").first().text();
                String awayTeam=matchElement.select("div.team-info > p.team-name").last().text();
                String leagueHeading = homeTeam +
                        " vs " + awayTeam;
                //div.fixtures-bot > div.fixtures-view > div.team.team-b.loss
                String homeTeamScore=matchElement.select("div.team-a > div.team-score > p.score").text();
                String awayTeamScore = matchElement.select("div.team-b > div.team-score > p.score").text();
                String matchStatus = matchElement.select(".fixtures-status span").text();
                String liveTimer=matchElement.select("div.timer-counter").text();
                String matchLink=matchElement.select("li.live > a").text();

                Hockey hockeyMatch = new Hockey();
                hockeyMatch.setHomeTeam(homeTeam);
                hockeyMatch.setAwayTeam(awayTeam);
                hockeyMatch.setTeamHeading(leagueHeading);
                hockeyMatch.setMatchNumberVenue(matchVenue);
                hockeyMatch.setHomeTeamScore(homeTeamScore);
                hockeyMatch.setAwayTeamScore(awayTeamScore);
                hockeyMatch.setStatus(matchStatus);
                hockeyMatch.setLiveTimer(liveTimer);
                hockeyMatch.setMatchLink(matchLink);
                matches.add(hockeyMatch);
                updateMatch(hockeyMatch);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return matches;
    }

    private void updateMatch(Hockey hockeyMatch) {
        Hockey existingMatch = hockeyRepo.findByTeamHeading(hockeyMatch.getTeamHeading()).orElse(null);
        if (existingMatch == null) {
            hockeyRepo.save(hockeyMatch);
        } else {
            hockeyMatch.setMatchId(existingMatch.getMatchId());
            hockeyRepo.save(hockeyMatch);
        }
    }
    @Override
    public List<Hockey> getAllMatches() {
        return hockeyRepo.findAll();
    }
}
