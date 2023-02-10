package com.example.Ekstraklasa.Projekt.Models;

public class TeamDTO
{
    private String name;
    private int wins;
    private int draws;
    private int loses;
    private int goalsScored;
    private int goalsAgainst;

    public TeamDTO() {
    }

    public TeamDTO(String name, int wins, int draws, int loses, int goalsScored, int goalsAgainst) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.goalsScored = goalsScored;
        this.goalsAgainst = goalsAgainst;
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
}
