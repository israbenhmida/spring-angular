package com.example.projet.Interfaces;

import com.example.projet.Entities.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBibliotheque {
    List<Bibliotheque> getAll();

    Optional<Bibliotheque> getBibliothequeById(Long id);

    void saveBibliotheque(Bibliotheque bibliotheque);

    void updateBibliotheque(Long id, Bibliotheque updatedBibliotheque);

    void deleteBibliotheque(Long bibliothequeId);
}
