package com.example.projet.Controller;


import com.example.projet.Interfaces.IReservation;
import com.example.projet.Entities.Reservation;
import com.example.projet.Services.ReservationImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor

@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
    private final ReservationImp reservationService;



    @GetMapping("getAllReservation")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("getReservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveReservation")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @PutMapping("updateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping("deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
