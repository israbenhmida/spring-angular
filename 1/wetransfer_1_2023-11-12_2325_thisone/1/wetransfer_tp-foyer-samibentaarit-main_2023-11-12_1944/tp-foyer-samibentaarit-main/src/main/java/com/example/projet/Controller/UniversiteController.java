package com.example.projet.Controller;

import com.example.projet.Entities.Universite;
import com.example.projet.Services.UniversiteImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/universites")
@CrossOrigin(origins = "http://localhost:4200")
public class UniversiteController {

    private final UniversiteImp universiteService;


    @GetMapping
    public List<Universite> getAll() {
        return universiteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        Optional<Universite> universite = universiteService.getUniversiteById(id);
        return universite.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Universite> saveUniversite(@RequestBody Universite universite) {
        universiteService.saveUniversite(universite);
        return new ResponseEntity<>(universite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable("id") Long id, @RequestBody Universite universite) {
        universiteService.updateUniversite(id, universite);
        return new ResponseEntity<Universite>(universite, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        try {
            universiteService.deleteUniversite(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
