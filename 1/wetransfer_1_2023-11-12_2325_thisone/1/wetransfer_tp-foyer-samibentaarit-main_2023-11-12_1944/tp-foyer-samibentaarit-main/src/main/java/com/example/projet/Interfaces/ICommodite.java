package com.example.projet.Interfaces;

import com.example.projet.Entities.Commodite;

import java.util.List;
import java.util.Optional;

public interface ICommodite {
    List<Commodite> getAll();

    Optional<Commodite> getCommoditeById(Long id);

    void saveCommodite(Commodite commodite);

    void updateCommodite(Long id, Commodite updatedCommodite);

    void deleteCommodite(Long commoditeId);
}
