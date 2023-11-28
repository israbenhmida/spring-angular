package com.example.projet.Controller;

import com.example.projet.Entities.Bibliotheque;
import com.example.projet.Services.BibliothequeImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("bibliotheque")
public class BibliothequeController {
    private final BibliothequeImp bibliothequeService;

    @GetMapping
    public List<Bibliotheque> getAll() {
        return bibliothequeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotheque> getBibliothequeById(@PathVariable Long id) {
        Optional<Bibliotheque> bibliotheque = bibliothequeService.getBibliothequeById(id);
        return bibliotheque.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bibliotheque> saveBibliotheque(@RequestBody Bibliotheque bibliotheque) {
        bibliothequeService.saveBibliotheque(bibliotheque);
        return new ResponseEntity<>(bibliotheque, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotheque> updateBibliotheque(@PathVariable("id") Long id, @RequestBody Bibliotheque bibliotheque) {
        bibliothequeService.updateBibliotheque(id, bibliotheque);
        return new ResponseEntity<Bibliotheque>(bibliotheque, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotheque(@PathVariable Long id) {
        try {
            bibliothequeService.deleteBibliotheque(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

