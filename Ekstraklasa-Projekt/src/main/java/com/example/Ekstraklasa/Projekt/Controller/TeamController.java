package com.example.Ekstraklasa.Projekt.Controller;

import com.example.Ekstraklasa.Projekt.Models.*;
import com.example.Ekstraklasa.Projekt.Repository.MatchRepository;
import com.example.Ekstraklasa.Projekt.Repository.PlayerRepository;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.Ekstraklasa.Projekt.Controller.KolejkaController.getMatchDTOS;

@RestController
@RequestMapping("/team")
public class TeamController
{
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams(){
        var teams = teamRepository.findAll();
        List<TeamDTO> dtos = new ArrayList<>();

        for (Team team: teams)
        {
            TeamDTO dto = new TeamDTO();
            dto.setName(team.getName());
            dto.setWins(team.getWins());
            dto.setDraws(team.getDraws());
            dto.setLoses(team.getLoses());
            dto.setGoalsScored(team.getGoalsScored());
            dto.setGoalsAgainst(team.getGoalsAgainst());

            dtos.add(dto);
        }
        return dtos;
    }

    @GetMapping(value = "{teamId}")
    public TeamDTO getTeamDetails(@PathVariable int teamId){

        var team = teamRepository.findById(teamId).get();

        TeamDTO dto = new TeamDTO();
        dto.setName(team.getName());
        dto.setWins(team.getWins());
        dto.setDraws(team.getDraws());
        dto.setLoses(team.getLoses());
        dto.setGoalsScored(team.getGoalsScored());
        dto.setGoalsAgainst(team.getGoalsAgainst());

        return dto;
    }

    @GetMapping(value = "{teamId}/players")
    public List<PlayerDTO> getPlayersForTeam(@PathVariable int teamId){
        var playersFromTeam = playerRepository.findAllByTeamId(teamId);
        var teamName = teamRepository.findById(teamId).get().getName();

        List<PlayerDTO> players = new ArrayList<>();
        for (Player player: playersFromTeam)
        {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setName(player.getName());
            playerDTO.setSurName(player.getSurname());
            playerDTO.setTeamName(teamName);

            players.add(playerDTO);
        }

        return players;
    }

    @GetMapping(value = "{teamId}/matches")
    public List<MatchDTO> getMatchesForTeam(@PathVariable int teamId){
        var teamMatches = matchRepository.findAllByTeamsId(teamId);
        return getMatchDTOS(teamMatches, teamRepository);
    }

    @PostMapping
    public ResponseEntity postTeam(@RequestBody Team team){
        return ResponseEntity.status(201).body(this.teamRepository.save(team));
    }

    @PutMapping(value = "{teamId}")
    public ResponseEntity updateTeam(@PathVariable int teamId, @RequestBody Team team){
        Team teamToUpdate = this.teamRepository.findById(teamId).get();
        teamToUpdate.setName(team.getName());
        teamToUpdate.setWins(team.getWins());
        teamToUpdate.setDraws(team.getDraws());
        teamToUpdate.setLoses(team.getLoses());
        teamToUpdate.setGoalsScored(team.getGoalsScored());
        teamToUpdate.setGoalsAgainst(team.getGoalsAgainst());

        this.teamRepository.save(teamToUpdate);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{teamId}")
    public ResponseEntity  deleteTeam(@PathVariable int teamId) {
        this.teamRepository.deleteById(teamId);
        return ResponseEntity.ok().build();
    }


}
