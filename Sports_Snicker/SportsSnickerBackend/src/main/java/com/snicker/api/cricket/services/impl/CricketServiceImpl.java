package com.snicker.api.cricket.services.impl;

import com.snicker.api.cricket.entity.Cricket;
import com.snicker.api.cricket.repositories.CricketRepo;
import com.snicker.api.cricket.services.CricketService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


@Service
public class CricketServiceImpl implements CricketService {

    private final CricketRepo cricketRepo;

    public CricketServiceImpl(CricketRepo cricketRepo) {
        this.cricketRepo = cricketRepo;
    }

    @Override
    public List<Cricket> getLiveMatches() {
        List<Cricket> crickets = new ArrayList<>();
        try {
            String url = "https://www.cricbuzz.com/cricket-match/live-scores";
            Document document = Jsoup.connect(url).get();
            Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");
            for (Element match : liveScoreElements) {
              //  HashMap<String, String> liveMatchInfo = new LinkedHashMap<>();
                String teamsHeading = match.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
                String matchNumberVenue = match.select("span").text();
                Elements matchBatTeamInfo = match.select("div.cb-hmscg-bat-txt");
                String battingTeam = matchBatTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String score = matchBatTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                Elements bowlTeamInfo = match.select("div.cb-hmscg-bwl-txt");
                String bowlTeam = bowlTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String bowlTeamScore = bowlTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                String textLive = match.select("div.cb-text-live").text();
                String textComplete = match.select("div.cb-text-complete").text();
                //getting match link
                String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href");

                Cricket cricket1 = new Cricket();
                cricket1.setTeamHeading(teamsHeading);
                cricket1.setMatchNumberVenue(matchNumberVenue);
                cricket1.setBattingTeam(battingTeam);
                cricket1.setBattingTeamScore(score);
                cricket1.setBowlTeam(bowlTeam);
                cricket1.setBowlTeamScore(bowlTeamScore);
                cricket1.setLiveText(textLive);
                cricket1.setMatchLink(matchLink);
                cricket1.setTextComplete(textComplete);
                cricket1.setMatchStatus();


                crickets.add(cricket1);

//                update the match in database


                updateMatch(cricket1);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crickets;
    }

    private void updateMatch(Cricket cricket1) {

        Cricket cricket = this.cricketRepo.findByTeamHeading(cricket1.getTeamHeading()).orElse(null);
        if (cricket == null) {
            this.cricketRepo.save(cricket1);
        } else {

            cricket1.setMatchId(cricket.getMatchId());
            this.cricketRepo.save(cricket1);
        }

    }

    @Override
    public List<List<String>> getPointsTable() {
        List<List<String>> pointTable = new ArrayList<>();
        String tableURL = "https://www.cricbuzz.com/cricket-series/6732/icc-cricket-world-cup-2023/points-table";
        try {
            Document document = Jsoup.connect(tableURL).get();
            Elements table = document.select("table.cb-srs-pnts");
            Elements tableHeads = table.select("thead>tr>*");
            List<String> headers = new ArrayList<>();
            tableHeads.forEach(element -> headers.add(element.text()));
            pointTable.add(headers);
            Elements bodyTrs = table.select("tbody>*");
            bodyTrs.forEach(tr -> {
                List<String> points = new ArrayList<>();
                if (tr.hasAttr("class")) {
                    Elements tds = tr.select("td");
                    String team = tds.get(0).select("div.cb-col-84").text();
                    points.add(team);
                    tds.forEach(td -> {
                        if (!td.hasClass("cb-srs-pnts-name")) {
                            points.add(td.text());
                        }
                    });
//                    System.out.println(points);
                    pointTable.add(points);
                }


            });


        } catch (Exception e) {
            e.printStackTrace();
        }
        return pointTable;
    }

    @Override
    public List<Cricket> getAllMatches() {
        return this.cricketRepo.findAll();
    }
}
