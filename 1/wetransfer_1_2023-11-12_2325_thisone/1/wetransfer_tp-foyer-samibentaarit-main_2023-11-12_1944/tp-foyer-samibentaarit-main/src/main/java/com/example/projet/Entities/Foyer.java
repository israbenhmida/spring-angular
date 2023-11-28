package com.example.projet.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;
    String nomFoyer;
    Long capaciteFoyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private List<Bloc> blocs;
    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bibliotheque> bibliotheques;

}
