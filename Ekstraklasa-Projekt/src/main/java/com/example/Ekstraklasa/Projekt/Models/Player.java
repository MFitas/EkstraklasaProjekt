package com.example.Ekstraklasa.Projekt.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PlayerId;

    private String Name;
    private String Surname;
    private int TeamId;

    public Player() {
    }

    public Player(int playerId, String name, String surname, int teamId) {
        PlayerId = playerId;
        Name = name;
        Surname = surname;
        TeamId = teamId;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
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

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int teamId) {
        TeamId = teamId;
    }
}

