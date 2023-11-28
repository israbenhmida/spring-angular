package com.example.projet.Services;

import com.example.projet.Entities.Reservation;
import com.example.projet.Interfaces.IReservation;
import com.example.projet.Repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReservationImp implements IReservation {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);

        if (existingReservation != null) {
            existingReservation.setIdReservation(updatedReservation.getIdReservation());
            existingReservation.setAnneUniversitaire(updatedReservation.getAnneUniversitaire());
            existingReservation.setEstValide(updatedReservation.getEstValide());
            existingReservation.setEtudiants(updatedReservation.getEtudiants()); // Update the 'foyer' attribute

            reservationRepository.save(existingReservation);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + id + " does not exist.");
        }
    }

    @Override
    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);

        if (reservation != null) {
            reservationRepository.delete(reservation);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + reservationId + " does not exist.");
        }
    }}
