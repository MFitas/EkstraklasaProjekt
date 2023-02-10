package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Match
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private int HomeTeamId;
    private int AwayTeamId;
    private int HomeGoals;
    private int AwayGoals;
    private Date MatchDate;

    @ManyToOne
    private Kolejka kolejka;

    @ManyToMany
    private List<Player> players;

    @ManyToMany
    private List<Team> teams;

    public Match() {
    }

    public Match(int id, int homeTeamId, int awayTeamId, int homeGoals, int awayGoals, Date matchDate, Kolejka kolejka, List<Player> players, List<Team> teams) {
        Id = id;
        HomeTeamId = homeTeamId;
        AwayTeamId = awayTeamId;
        HomeGoals = homeGoals;
        AwayGoals = awayGoals;
        MatchDate = matchDate;
        this.kolejka = kolejka;
        this.players = players;
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public Kolejka getKolejka() {
        return kolejka;
    }

    public void setKolejka(Kolejka kolejka) {
        this.kolejka = kolejka;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
