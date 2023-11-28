package com.example.projet.Repositories;

import com.example.projet.Entities.Bloc;
import com.example.projet.Entities.Commodite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommoditeRepository extends JpaRepository<Commodite,Long> {
}
