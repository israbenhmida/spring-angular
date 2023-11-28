package com.example.projet.Interfaces;

import com.example.projet.Entities.Chambre;
import java.util.List;

public interface IChambre {

    List<Chambre> getAll();
    Object getChambreById(Long id);
    void saveChambre(Chambre eleve);
    void updateChambre(Long id, Chambre eleve);
    void deleteChambre(Long eleveId);

}
