package com.example.Ekstraklasa.Projekt.Controller;


import com.example.Ekstraklasa.Projekt.Models.Kolejka;
import com.example.Ekstraklasa.Projekt.Models.Team;
import com.example.Ekstraklasa.Projekt.Repository.KolejkaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Kolejka")
public class KolejkaController
{
    private final KolejkaRepository kolejkaRepository;

    public KolejkaController(KolejkaRepository kolejkaRepository) {
        this.kolejkaRepository = kolejkaRepository;
    }

    @GetMapping
    public ResponseEntity getAllKolejkas(){
        return ResponseEntity.ok(this.kolejkaRepository.findAll());
    }

    @GetMapping("{kolejkaId}")
    public ResponseEntity getKolejkaDetails(@PathVariable int kolejkaId){
        return ResponseEntity.ok(this.kolejkaRepository.findById(kolejkaId));
    }

    @PostMapping
    public ResponseEntity postKolejka(@RequestBody Kolejka kolejka){
        return ResponseEntity.status(201).body(this.kolejkaRepository.save(kolejka));
    }

    @PutMapping(value = "{kolejkaId}")
    public ResponseEntity updateKolejka(@PathVariable int kolejkaId, @RequestBody Kolejka kolejka){
        Kolejka kolejkaToUpdate = this.kolejkaRepository.findById(kolejkaId).get();
        kolejkaToUpdate.setMatchId(kolejka.getMatchId());

        return ResponseEntity.ok(this.kolejkaRepository.save(kolejkaToUpdate));
    }

    @DeleteMapping(value = "{kolejkaId}")
    public ResponseEntity deleteKolejka(@PathVariable int kolejkaId){
        this.kolejkaRepository.deleteById(kolejkaId);
        return ResponseEntity.ok().build();
    }
}
