// SecteurService.java
package com.devoir.devoir.services;

import com.devoir.devoir.entities.Rayon;
import com.devoir.devoir.entities.Secteur;
import com.devoir.devoir.repositories.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {
    @Autowired
    private SecteurRepository secteurRepository;

    public List<Secteur> findAll() {
        return secteurRepository.findAll();
    }

    public Secteur findById(Integer numS) {
        return secteurRepository.findById(numS).orElseThrow();
    }

    public List<Rayon> findRayonsBySecteurId(Integer numS) {
        Secteur secteur = findById(numS);
        return secteur.getRayons().stream().toList();
    }
}