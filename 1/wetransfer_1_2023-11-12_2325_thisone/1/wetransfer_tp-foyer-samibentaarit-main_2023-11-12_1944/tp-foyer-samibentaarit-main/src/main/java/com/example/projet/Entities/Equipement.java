package com.example.projet.Entities;

import com.example.projet.Enums.TypeEquipement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Equipement implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idEquipement;
        @Enumerated(EnumType.STRING)
        private TypeEquipement type;
        @OneToMany(cascade = CascadeType.ALL)
        private Set<Chambre> chambres;


    }



