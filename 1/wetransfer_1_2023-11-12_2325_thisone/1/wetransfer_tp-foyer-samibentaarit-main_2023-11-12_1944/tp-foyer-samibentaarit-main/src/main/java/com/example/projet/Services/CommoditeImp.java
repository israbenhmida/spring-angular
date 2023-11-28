package com.example.projet.Services;

import com.example.projet.Entities.Commodite;
import com.example.projet.Interfaces.ICommodite;
import com.example.projet.Repositories.CommoditeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommoditeImp implements ICommodite {
    private CommoditeRepository commoditeRepository;

    @Override
    public List<Commodite> getAll() {
        return commoditeRepository.findAll();
    }

    @Override
    public Optional<Commodite> getCommoditeById(Long id) {
        return commoditeRepository.findById(id);
    }

    @Override
    public void saveCommodite(Commodite commodite) {
        commoditeRepository.save(commodite);
    }

    @Override
    public void updateCommodite(Long id, Commodite updatedCommodite) {
        Commodite existingCommodite = commoditeRepository.findById(id).orElse(null);

        if (existingCommodite != null) {
            existingCommodite.setNomCommodite(updatedCommodite.getNomCommodite());
            existingCommodite.setDispoCommodite(updatedCommodite.getDispoCommodite());
            existingCommodite.setBlocs(updatedCommodite.getBlocs()); // Update the 'commodite' attribute

            commoditeRepository.save(existingCommodite);
        } else {
            throw new IllegalArgumentException("Commodite with ID " + id + " does not exist.");
        }
    }


    @Override
    public void deleteCommodite(Long commoditeId) {
        Commodite commodite = commoditeRepository.findById(commoditeId).orElse(null);

        if (commodite != null) {
            commoditeRepository.delete(commodite);
        } else {
            throw new IllegalArgumentException("Commodite with ID " + commoditeId + " does not exist.");
        }
    }
}
