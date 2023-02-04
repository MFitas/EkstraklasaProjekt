package com.example.Ekstraklasa.Projekt.Repository;

import com.example.Ekstraklasa.Projekt.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>
{
}
