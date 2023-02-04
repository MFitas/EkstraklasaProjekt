package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Match
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int MatchId;

    private int HomeTeamId;
    private int AwayTeamId;
    private int HomeGoals;
    private int AwayGoals;
    private Date MatchDate;

    public Match() {
    }

    public Match(int matchId, int homeTeamId, int awayTeamId, int homeGoals, int awayGoals, Date matchDate) {
        MatchId = matchId;
        HomeTeamId = homeTeamId;
        AwayTeamId = awayTeamId;
        HomeGoals = homeGoals;
        AwayGoals = awayGoals;
        MatchDate = matchDate;
    }

    public int getMatchId() {
        return MatchId;
    }

    public void setMatchId(int matchId) {
        MatchId = matchId;
    }

    public int getHomeTeamId() {
        return HomeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        HomeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return AwayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        AwayTeamId = awayTeamId;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        HomeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        AwayGoals = awayGoals;
    }

    public Date getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(Date matchDate) {
        MatchDate = matchDate;
    }
}
