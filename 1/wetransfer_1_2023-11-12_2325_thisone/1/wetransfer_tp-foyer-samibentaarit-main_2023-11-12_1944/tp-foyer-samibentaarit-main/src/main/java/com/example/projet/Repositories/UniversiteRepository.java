package com.example.projet.Repositories;

import com.example.projet.Entities.Universite;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
