package com.example.projet.Controller;

import com.example.projet.Entities.Commodite;
import com.example.projet.Interfaces.ICommodite;
import com.example.projet.Entities.Commodite;
import com.example.projet.Services.CommoditeImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("commodite")
public class CommoditeController {

    private final CommoditeImp commoditeService;

    @GetMapping
    public List<Commodite> getAll() {
        return commoditeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commodite> getCommoditeById(@PathVariable Long id) {
        Optional<Commodite> commodite = commoditeService.getCommoditeById(id);
        return commodite.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Commodite> saveCommodite(@RequestBody Commodite commodite) {
        commoditeService.saveCommodite(commodite);
        return new ResponseEntity<>(commodite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commodite> updateCommodite(@PathVariable("id") Long id, @RequestBody Commodite commodite) {
        commoditeService.updateCommodite(id, commodite);
        return new ResponseEntity<Commodite>(commodite, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommodite(@PathVariable Long id) {
        try {
            commoditeService.deleteCommodite(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
