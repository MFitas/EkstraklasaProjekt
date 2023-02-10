package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Kolejka
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @OneToMany
    private List<Match> matches;

    public Kolejka() {
    }

    public Kolejka(int id, List<Match> matches) {
        Id = id;
        this.matches = matches;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
