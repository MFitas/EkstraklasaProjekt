package com.example.Ekstraklasa.Projekt.Controller;

import com.example.Ekstraklasa.Projekt.Models.Player;
import com.example.Ekstraklasa.Projekt.Models.PlayerDTO;
import com.example.Ekstraklasa.Projekt.Repository.PlayerRepository;
import com.example.Ekstraklasa.Projekt.Repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController
{

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;

    public PlayerController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping(value = "team/{teamId}")
    public List<PlayerDTO> getAllPlayersInTeam(@PathVariable int teamId){

        var players = playerRepository.findAllByTeamId(teamId);
        List<PlayerDTO> dtos = new ArrayList<>();

        for (Player player : players)
        {
            PlayerDTO dto  = new PlayerDTO();
            dto.setName(player.getName());
            dto.setSurName(player.getSurname());
            dto.setTeamName(teamRepository.findById(teamId).get().getName());

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping(value = "{playerId}")
    public PlayerDTO getSinglePlayer(@PathVariable int playerId){
        var player = playerRepository.findById(playerId).get();
        PlayerDTO dto = new PlayerDTO();
        dto.setName(player.getName());
        dto.setSurName(player.getSurname());
        dto.setTeamName(teamRepository.findById(player.getTeam().getId()).get().getName());

        return dto;
    }

    @PostMapping
    public ResponseEntity postPlayer(@RequestBody Player player){
        return ResponseEntity.status(201).body(this.playerRepository.save(player));
    }

    @PutMapping(value = "{playerId}")
    public ResponseEntity updatePlayer(@PathVariable int playerId, @RequestBody Player player){
        Player playerToUpdate = this.playerRepository.findById(playerId).get();
        playerToUpdate.setName(player.getName());
        playerToUpdate.setSurname(player.getSurname());

        playerToUpdate.setTeam(teamRepository.findById(player.getTeam().getId()).get());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{playerId}")
    public ResponseEntity deletePlayer(@PathVariable int playerId){
        this.playerRepository.deleteById(playerId);
        return ResponseEntity.ok().build();
    }
}
