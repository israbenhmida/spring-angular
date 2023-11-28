package com.example.projet.Interfaces;


import com.example.projet.Entities.Reservation;

import java.util.List;

public interface IReservation {
    List<Reservation> getAll();
    Object getReservationById (Long id);
    void saveReservation (Reservation reservation);
    void updateReservation (Long id, Reservation reservation);
    void deleteReservation (Long reservationId);


}
