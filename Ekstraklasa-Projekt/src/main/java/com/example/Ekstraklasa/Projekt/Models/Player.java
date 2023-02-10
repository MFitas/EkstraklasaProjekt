package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Name;
    private String Surname;

    @ManyToOne
    private Team team;

    @ManyToMany
    private List<Match> matches;

    public Player() {
    }

    public Player(String name, String surname, Team team, List<Match> matches) {
        Name = name;
        Surname = surname;
        this.team = team;
        this.matches = matches;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}

