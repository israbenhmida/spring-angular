package com.example.projet.Services;


import com.example.projet.Entities.Bloc;
import com.example.projet.Interfaces.IBloc;
import com.example.projet.Repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BlocImp implements IBloc{
    private BlocRepository blocRepository;

    @Override
    public List<Bloc> getAll() {
        return blocRepository.findAll();
    }

    @Override
    public Optional<Bloc> getBlocById(Long id) {
        return blocRepository.findById(id);
    }

    @Override
    public void saveBloc(Bloc bloc) {
        blocRepository.save(bloc);
    }

    @Override
    public void updateBloc(Long id, Bloc updatedBloc) {
        Bloc existingBloc = blocRepository.findById(id).orElse(null);

        if (existingBloc != null) {
            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBLoc(updatedBloc.getCapaciteBLoc());
            existingBloc.setChambres(updatedBloc.getChambres());
            blocRepository.save(existingBloc);
        } else {
            throw new IllegalArgumentException("Bloc with ID " + id + " does not exist.");
        }
    }


    @Override
    public void deleteBloc(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).orElse(null);

        if (bloc != null) {
            blocRepository.delete(bloc);
        } else {
            throw new IllegalArgumentException("Bloc with ID " + blocId + " does not exist.");
        }
    }
}