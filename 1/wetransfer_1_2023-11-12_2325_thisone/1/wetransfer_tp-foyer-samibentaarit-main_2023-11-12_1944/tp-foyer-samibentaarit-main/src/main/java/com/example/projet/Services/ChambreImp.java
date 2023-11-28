package com.example.projet.Services;

import com.example.projet.Entities.Chambre;
import com.example.projet.Interfaces.IChambre;
import com.example.projet.Repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreImp implements IChambre {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public void saveChambre(Chambre chambre) {
        chambreRepository.save(chambre);
    }

    @Override
    public void updateChambre(Long id, Chambre updatedChambre) {
        Chambre existingChambre = chambreRepository.findById(id).orElse(null);

        if (existingChambre != null) {
            existingChambre.setNumeroChambre(updatedChambre.getNumeroChambre());
            existingChambre.setIdChambre(updatedChambre.getIdChambre());
            existingChambre.setBloc(updatedChambre.getBloc()); // Update the 'foyer' attribute

            chambreRepository.save(existingChambre);
        } else {
            throw new IllegalArgumentException("Chambre with ID " + id + " does not exist.");
        }
    }


    @Override
    public void deleteChambre(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId).orElse(null);

        if (chambre != null) {
            chambreRepository.delete(chambre);
        } else {
            throw new IllegalArgumentException("Chambre with ID " + chambreId + " does not exist.");
        }
    }
}
