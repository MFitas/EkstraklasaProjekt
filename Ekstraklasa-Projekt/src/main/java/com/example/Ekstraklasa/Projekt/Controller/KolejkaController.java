package com.example.Ekstraklasa.Projekt.Controller;


import com.example.Ekstraklasa.Projekt.Models.Kolejka;
import com.example.Ekstraklasa.Projekt.Models.KolejkaDTO;
import com.example.Ekstraklasa.Projekt.Models.Match;
import com.example.Ekstraklasa.Projekt.Models.MatchDTO;
import com.example.Ekstraklasa.Projekt.Repository.KolejkaRepository;
import com.example.Ekstraklasa.Projekt.Repository.MatchRepository;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/kolejka")
public class KolejkaController
{
    private final KolejkaRepository kolejkaRepository;
    private final MatchRepository matchRepository;

    private final TeamRepository teamRepository;

    public KolejkaController(KolejkaRepository kolejkaRepository, MatchRepository matchRepository, TeamRepository teamRepository) {
        this.kolejkaRepository = kolejkaRepository;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<KolejkaDTO> getAllKolejkas(){

        var kolejki = kolejkaRepository.findAll();
        List<KolejkaDTO> dtos = new ArrayList<>();

        for (Kolejka kolejka: kolejki)
        {
            KolejkaDTO dto = new KolejkaDTO();
            dto.setNumerKolejki(kolejka.getId());
            List<MatchDTO> matchDTOList = new ArrayList<>();
            for (Match match: kolejka.getMatches())
            {
                MatchDTO matchDTO = new MatchDTO();
                matchDTO.setHomeTeamName(teamRepository.findById(match.getHomeTeamId()).get().getName());
                matchDTO.setAwayTeamName(teamRepository.findById(match.getAwayTeamId()).get().getName());
                matchDTO.setHomeGoals(match.getHomeGoals());
                matchDTO.setAwayGoals(match.getAwayGoals());
                matchDTO.setMatchDate(match.getMatchDate());

                matchDTOList.add(matchDTO);
            }
            dto.setMatches(matchDTOList);

            dtos.add(dto);
        }
        return dtos;
    }

    @GetMapping("{kolejkaId}")
    public List<MatchDTO> getKolejkaDetails(@PathVariable int kolejkaId)
    {
        var matches = matchRepository.findAllByKolejkaId(kolejkaId);
        return getMatchDTOS(matches, teamRepository);
    }

    static List<MatchDTO> getMatchDTOS(List<Match> smth, TeamRepository teamRepository) {
        List<MatchDTO> dtos = new ArrayList<>();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        for (Match match: smth)
        {
            MatchDTO matchDTO = new MatchDTO();
            matchDTO.setHomeTeamName(teamRepository.findById(match.getHomeTeamId()).get().getName());
            matchDTO.setAwayTeamName(teamRepository.findById(match.getAwayTeamId()).get().getName());
            matchDTO.setHomeGoals(match.getHomeGoals());
            matchDTO.setAwayGoals(match.getAwayGoals());
            matchDTO.setMatchDate(match.getMatchDate());
            dtos.add(matchDTO);
        }

        return dtos;
    }

    @PostMapping
    public ResponseEntity postKolejka(@RequestBody Kolejka kolejka){
        return ResponseEntity.status(201).body(this.kolejkaRepository.save(kolejka));
    }

    @PutMapping(value = "{kolejkaId}")
    public ResponseEntity updateKolejka(@PathVariable int kolejkaId, @RequestBody Kolejka kolejka){
        Kolejka kolejkaToUpdate = this.kolejkaRepository.findById(kolejkaId).get();
        kolejkaToUpdate.setMatches(kolejka.getMatches());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{kolejkaId}")
    public ResponseEntity deleteKolejka(@PathVariable int kolejkaId){
        this.kolejkaRepository.deleteById(kolejkaId);
        return ResponseEntity.ok().build();
    }
}
