package com.example.projet.Interfaces;

import com.example.projet.Entities.Equipement;
import com.example.projet.Entities.Universite;

import java.util.List;

public interface IEquipement {
    List<Equipement> getAll();
    Object getEquipementById(Long id);
    void saveEquipement(Equipement equipement);
    void updateEquipement(Long id, Equipement equipement);
    void deleteEquipement(Long Id);
}
