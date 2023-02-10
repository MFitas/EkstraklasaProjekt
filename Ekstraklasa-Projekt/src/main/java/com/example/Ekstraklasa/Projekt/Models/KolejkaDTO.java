package com.example.Ekstraklasa.Projekt.Models;

import java.util.List;

public class KolejkaDTO
{
    private int NumerKolejki;
    private List<MatchDTO> matches;

    public KolejkaDTO(int numerKolejki, List<MatchDTO> matches) {
        NumerKolejki = numerKolejki;
        this.matches = matches;
    }

    public KolejkaDTO() {
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }

    public int getNumerKolejki() {
        return NumerKolejki;
    }

    public void setNumerKolejki(int numerKolejki) {
        NumerKolejki = numerKolejki;
    }


}
