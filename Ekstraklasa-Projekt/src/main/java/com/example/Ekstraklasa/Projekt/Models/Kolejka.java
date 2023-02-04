package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kolejka
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int KolejkaId;

    private int matchId;

    public Kolejka() {
    }

    public Kolejka(int kolejkaId, int matchId) {
        KolejkaId = kolejkaId;
        this.matchId = matchId;
    }

    public int getKolejkaId() {
        return KolejkaId;
    }

    public void setKolejkaId(int kolejkaId) {
        KolejkaId = kolejkaId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}
