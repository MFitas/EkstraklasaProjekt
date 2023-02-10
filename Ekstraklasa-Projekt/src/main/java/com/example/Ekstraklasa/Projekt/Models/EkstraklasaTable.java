package com.example.Ekstraklasa.Projekt.Models;

public class EkstraklasaTable
{
    public String name;
    public int wins;
    public int matchCount;
    public int draws;
    public int loses;
    public int goalsScored;
    public int goalsAgainst;
    public int points;

    public EkstraklasaTable() {
    }

    public EkstraklasaTable(String name, int wins, int matchCount, int draws, int loses, int goalsScored, int goalsAgainst, int points) {
        this.name = name;
        this.wins = wins;
        this.matchCount = matchCount;
        this.draws = draws;
        this.loses = loses;
        this.goalsScored = goalsScored;
        this.goalsAgainst = goalsAgainst;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
