package com.example.projet.Controller;


import com.example.projet.Entities.Chambre;
import com.example.projet.Entities.Equipement;
import com.example.projet.Services.ChambreImp;
import com.example.projet.Services.EquipementImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/equipement")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementController {
    private final EquipementImp equipementImp;


    @GetMapping
    public List<Equipement> getAll() {
        return equipementImp.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Optional<Equipement> equipement = (Optional<Equipement>) equipementImp.getEquipementById(id);
        return equipement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Equipement> saveEquipement(@RequestBody Equipement equipement) {
        equipementImp.saveEquipement(equipement);
        return new ResponseEntity<>(equipement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable("id") Long id, @RequestBody Equipement equipement) {
        equipementImp.updateEquipement(id, equipement);
        return new ResponseEntity<Equipement>(equipement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        try {
            equipementImp.deleteEquipement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
