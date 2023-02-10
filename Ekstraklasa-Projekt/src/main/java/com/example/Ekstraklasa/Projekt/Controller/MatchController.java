package com.example.Ekstraklasa.Projekt.Controller;

import com.example.Ekstraklasa.Projekt.Models.Match;
import com.example.Ekstraklasa.Projekt.Models.MatchDTO;
import com.example.Ekstraklasa.Projekt.Repository.MatchRepository;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Ekstraklasa.Projekt.Controller.KolejkaController.getMatchDTOS;

@RestController
@RequestMapping("/match")
public class MatchController
{
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public MatchController(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<MatchDTO> getAllMatches()
    {
       var matches = matchRepository.findAll();

       return getMatchDTOS(matches, teamRepository);
    }

    @GetMapping(value = "{matchID}")
    public MatchDTO getMatchDetails(@PathVariable int matchID)
    {
        var match = this.matchRepository.findById(matchID).get();

        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setHomeTeamName(teamRepository.findById(match.getHomeTeamId()).get().getName());
        matchDTO.setAwayTeamName(teamRepository.findById(match.getAwayTeamId()).get().getName());
        matchDTO.setHomeGoals(match.getHomeGoals());
        matchDTO.setAwayGoals(match.getAwayGoals());
        matchDTO.setMatchDate(match.getMatchDate());
        return matchDTO;
    }

    @PostMapping
    public ResponseEntity postMatch(@RequestBody Match match){
        return ResponseEntity.status(201).body(this.matchRepository.save(match));
    }

    @PutMapping(value = "{matchId}")
    public ResponseEntity updateMatch(@PathVariable int matchId, @RequestBody Match match){
        Match matchToUpdate = null;
        try {
            matchToUpdate = this.matchRepository.findById(matchId)
                    .orElseThrow(Exception::new);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        matchToUpdate.setHomeTeamId(match.getHomeTeamId());
        matchToUpdate.setAwayTeamId(match.getAwayTeamId());
        matchToUpdate.setHomeGoals(match.getHomeGoals());
        matchToUpdate.setAwayGoals(match.getAwayGoals());
        matchToUpdate.setMatchDate(match.getMatchDate());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{matchId}")
    public ResponseEntity deleteMatch(@PathVariable int matchId){
        this.matchRepository.deleteById(matchId);
        return ResponseEntity.ok().build();
    }
}
