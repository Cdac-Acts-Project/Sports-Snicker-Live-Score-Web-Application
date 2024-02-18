package com.snicker.api.football.services.impl;

import com.snicker.api.football.entity.Football;
import com.snicker.api.football.repositories.FootballRepo;
import com.snicker.api.football.services.FootballService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//import java.util.ArrayList;

import java.util.List;

@Service
public class FootballServiceImpl implements FootballService {

	private FootballRepo footballRepo;

	public FootballServiceImpl(FootballRepo footballRepo) {
		this.footballRepo = footballRepo;
	}

	@Override
	public List<Football> getAllMatches() {
		return this.footballRepo.findAll();
	}

	@Override
	public List<Football> getLiveMatches() {
		List<Football> footballs = new ArrayList<>();
		try {
			String url = "https://www.espn.in/football/scoreboard";
			Document document = Jsoup.connect(url).get();

			Elements liveScoreElements = document.select("section.Card.gameModules");

			for (Element section : liveScoreElements) {
				
				Elements teamOne = section.getElementsByClass("ScoreCell__Item--home");
//				String teamOneName = "",teamOneScore = "";
//				for(Element teamOneInfo : teamOne) {
//					 teamOneName = teamOneInfo.getElementsByClass("ScoreCell__TeamName").text();
//					 teamOneScore = teamOneInfo.getElementsByClass("ScoreCell__Score").text();
//				}
				
				Elements teamTwo = section.getElementsByClass("ScoreCell__Item--away");
//				String teamTwoName = "",teamTwoScore = "";
//				for(Element teamTwoInfo : teamTwo) {
//					 teamTwoName = teamTwoInfo.getElementsByClass("ScoreCell__TeamName").text();
//					 teamTwoScore = teamTwoInfo.getElementsByClass("ScoreCell__Score").text();
//				}
//				
				System.out.println(teamOne.text());
				System.out.println(teamTwo.text());
//
//				Football football = new Football();
//
//				football.setTeamHeading(teamHeading);
//				football.setTeamOne(teamOneName);
//				football.setTeamTwo(teamTwoName);
//				football.setTeamOneScore(teamOneScore);
//				football.setTeamTwoScore(teamTwoScore);
////
//				footballs.add(football);
//
//				 updateMatch(football);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return footballs;
	}

//    private void updateMatch(Football football1) {
//        Football football = this.footballRepo.findByTeamHeading(football1.getTeamHeading()).orElse(null);
//        if(football == null){
//            this.footballRepo.save(football1);
//        }else{
//            football1.setMatchId((football.getMatchId()));
//            this.footballRepo.save(football1);
//        }
//    }
}
