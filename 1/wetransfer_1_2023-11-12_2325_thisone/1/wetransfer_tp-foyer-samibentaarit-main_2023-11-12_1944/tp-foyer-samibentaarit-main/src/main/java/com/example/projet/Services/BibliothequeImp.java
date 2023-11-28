package com.example.projet.Services;

import com.example.projet.Entities.Bibliotheque;
import com.example.projet.Interfaces.IBibliotheque;
import com.example.projet.Repositories.BibliothequeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class BibliothequeImp implements IBibliotheque {
    private BibliothequeRepository bibliothequeRepository;

    @Override
    public List<Bibliotheque> getAll() {
        return bibliothequeRepository.findAll();
    }

    @Override
    public Optional<Bibliotheque> getBibliothequeById(Long id) {
        return bibliothequeRepository.findById(id);
    }

    @Override
    public void saveBibliotheque(Bibliotheque bibliotheque) {
        bibliothequeRepository.save(bibliotheque);
    }

    @Override
    public void updateBibliotheque(Long id, Bibliotheque updatedBibliotheque) {
        Bibliotheque existingBibliotheque = bibliothequeRepository.findById(id).orElse(null);

        if (existingBibliotheque != null) {
            existingBibliotheque.setTitreBibliotheque(updatedBibliotheque.getTitreBibliotheque());
            existingBibliotheque.setDescriptionBibliotheque(updatedBibliotheque.getDescriptionBibliotheque());
            existingBibliotheque.setFoyer(updatedBibliotheque.getFoyer()); // Update the 'bibliotheque' attribute

            bibliothequeRepository.save(existingBibliotheque);
        } else {
            throw new IllegalArgumentException("Bibliotheque with ID " + id + " does not exist.");
        }
    }


    @Override
    public void deleteBibliotheque(Long bibliothequeId) {
        Bibliotheque bibliotheque = bibliothequeRepository.findById(bibliothequeId).orElse(null);

        if (bibliotheque != null) {
            bibliothequeRepository.delete(bibliotheque);
        } else {
            throw new IllegalArgumentException("Bibliotheque with ID " + bibliothequeId + " does not exist.");
        }
    }
}

