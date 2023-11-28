package com.example.projet.Services;

import com.example.projet.Entities.Equipement;
import com.example.projet.Entities.Universite;
import com.example.projet.Interfaces.IEquipement;
import com.example.projet.Repositories.EquipementRepository;
import com.example.projet.Repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class EquipementImp implements IEquipement {
    @Autowired
    private EquipementRepository equipementRepository;


    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Object getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    @Override
    public void saveEquipement(Equipement equipement) {
        equipementRepository.save(equipement);
    }

    @Override
    public void updateEquipement(Long idEq, Equipement equipement) {
        Equipement existingEquipement = equipementRepository.findById(idEq).orElse(null);

        if (existingEquipement != null) {
            existingEquipement.setIdEquipement(equipement.getIdEquipement());
            existingEquipement.setChambres(equipement.getChambres());

            equipementRepository.save(existingEquipement);
        } else {
            throw new IllegalArgumentException("Equipement with ID " + idEq + " does not exist.");
        }

    }

    @Override
    public void deleteEquipement(Long idEquipement) {
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);

        if (equipement != null) {
            equipementRepository.delete(equipement);
        } else {
            throw new IllegalArgumentException("equipement with ID " + idEquipement + " does not exist.");
        }
    }

    }
