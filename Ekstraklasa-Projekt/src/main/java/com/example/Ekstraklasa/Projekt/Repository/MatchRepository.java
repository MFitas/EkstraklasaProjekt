package com.example.Ekstraklasa.Projekt.Repository;

import com.example.Ekstraklasa.Projekt.Models.Match;
import com.example.Ekstraklasa.Projekt.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>
{
    public List<Match> findAllByKolejkaId(int kolejkaId);

    public List<Match> findAllByTeamsId(int teamId);
}
