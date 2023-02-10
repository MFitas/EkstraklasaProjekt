package com.example.Ekstraklasa.Projekt.Repository;

import com.example.Ekstraklasa.Projekt.Models.Player;
import com.example.Ekstraklasa.Projekt.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer>
{
    public Team findTeamByPlayersId(int PlayerId);

    public List<Team> findAllByMatchesId(int matchId);
}
