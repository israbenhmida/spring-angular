package com.example.projet.Interfaces;

import com.example.projet.Entities.Bloc;

import java.util.List;
import java.util.Optional;

public interface IBloc {

    List<Bloc> getAll();

    Optional<Bloc> getBlocById(Long id);

    void saveBloc(Bloc bloc);

    void updateBloc(Long id, Bloc updatedBloc);

    void deleteBloc(Long blocId);
}