package com.example.Ekstraklasa.Projekt.Models;

import java.util.Date;

public class MatchDTO
{
    private String HomeTeamName;
    private String AwayTeamName;
    private int HomeGoals;
    private int AwayGoals;
    private Date MatchDate;

    public MatchDTO() {
    }

    public MatchDTO(String homeTeamName, String awayTeamName, int homeGoals, int awayGoals, Date matchDate) {
        HomeTeamName = homeTeamName;
        AwayTeamName = awayTeamName;
        HomeGoals = homeGoals;
        AwayGoals = awayGoals;
        MatchDate = matchDate;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
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

