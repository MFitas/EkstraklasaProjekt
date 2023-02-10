package com.example.Ekstraklasa.Projekt.Repository;

import com.example.Ekstraklasa.Projekt.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>
{
    public List<Player> findAllByTeamId(int teamId);
    public List<Player> findAllByMatchesId(int matchId);
}
