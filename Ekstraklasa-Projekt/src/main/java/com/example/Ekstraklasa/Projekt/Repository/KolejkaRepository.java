package com.example.Ekstraklasa.Projekt.Repository;

import com.example.Ekstraklasa.Projekt.Models.Kolejka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KolejkaRepository extends JpaRepository<Kolejka, Integer>
{
}
