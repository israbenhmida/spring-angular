package com.example.projet.Controller;

import com.example.projet.Entities.Bloc;
import com.example.projet.Interfaces.IBloc;
import com.example.projet.Entities.Bloc;
import com.example.projet.Services.BlocImp;
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
@RequestMapping("bloc")
public class BlocController {

 private final BlocImp blocService;

 @GetMapping
 public List<Bloc> getAll() {
  return blocService.getAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
  Optional<Bloc> bloc = blocService.getBlocById(id);
  return bloc.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
 }

 @PostMapping
 public ResponseEntity<Bloc> saveBloc(@RequestBody Bloc bloc) {
  blocService.saveBloc(bloc);
  return new ResponseEntity<>(bloc, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Bloc> updateBloc(@PathVariable("id") Long id, @RequestBody Bloc bloc) {
  blocService.updateBloc(id, bloc);
  return new ResponseEntity<Bloc>(bloc, HttpStatus.OK);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
  try {
   blocService.deleteBloc(id);
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (IllegalArgumentException e) {
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
 }
}
