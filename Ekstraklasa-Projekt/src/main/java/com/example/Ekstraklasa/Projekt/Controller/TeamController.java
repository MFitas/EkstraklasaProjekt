package com.example.Ekstraklasa.Projekt.Controller;

import com.example.Ekstraklasa.Projekt.Models.Team;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Team")
public class TeamController
{
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public ResponseEntity getAllTeams(){
        return ResponseEntity.ok(this.teamRepository.findAll());
    }

    @GetMapping(value = "{teamId}")
    public ResponseEntity getTeamDetails(@PathVariable int teamId){
        return ResponseEntity.ok(this.teamRepository.findById(teamId));
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody Team team){
        return ResponseEntity.status(201).body(this.teamRepository.save(team));
    }

    @PutMapping(value = "{teamid}")
    public ResponseEntity updateProduct(@PathVariable int teamid, @RequestBody Team team){
        Team teamToUpdate = this.teamRepository.findById(teamid).get();
        teamToUpdate.setName(team.getName());
        teamToUpdate.setWins(team.getWins());
        teamToUpdate.setDraws(team.getDraws());
        teamToUpdate.setLoses(team.getLoses());
        teamToUpdate.setGoalsScored(team.getGoalsScored());
        teamToUpdate.setGoalsAgainst(team.getGoalsAgainst());

        return ResponseEntity.ok(this.teamRepository.save(teamToUpdate));
    }

    @DeleteMapping(value = "{teamid}")
    public ResponseEntity  deleteTeam(@PathVariable int teamid) {
        this.teamRepository.deleteById(teamid);
        return ResponseEntity.ok().build();
    }
}
