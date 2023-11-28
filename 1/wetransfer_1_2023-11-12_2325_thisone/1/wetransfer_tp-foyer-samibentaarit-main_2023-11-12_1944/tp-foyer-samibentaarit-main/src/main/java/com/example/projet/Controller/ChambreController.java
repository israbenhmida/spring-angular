package com.example.projet.Controller;

import com.example.projet.Entities.Chambre;
import com.example.projet.Services.ChambreImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/chambre")
@CrossOrigin(origins = "http://localhost:4200")
public class ChambreController {

    private final ChambreImp chambreService;


    @GetMapping
    public List<Chambre> getAll() {
        return chambreService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreService.getChambreById(id);
        return chambre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Chambre> saveChambre(@RequestBody Chambre chambre) {
        chambreService.saveChambre(chambre);
        return new ResponseEntity<>(chambre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable("id") Long id, @RequestBody Chambre chambre) {
        chambreService.updateChambre(id, chambre);
        return new ResponseEntity<Chambre>(chambre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        try {
            chambreService.deleteChambre(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
