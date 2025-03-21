package com.devoir.devoir.repositories;

import com.devoir.devoir.entities.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository <Secteur, Integer>
{

    @Override
    List<Secteur> findAll();

    @Override
    Optional<Secteur> findById(Integer idSecteur);


}
