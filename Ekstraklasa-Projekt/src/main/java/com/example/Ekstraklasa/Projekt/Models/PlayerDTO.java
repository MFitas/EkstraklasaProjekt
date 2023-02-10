package com.example.Ekstraklasa.Projekt.Models;

public class PlayerDTO
{
    private String Name;
    private String SurName;
    private String TeamName;

    public PlayerDTO(String name, String surName, String teamName) {
        Name = name;
        SurName = surName;
        TeamName = teamName;
    }

    public PlayerDTO() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }
}

