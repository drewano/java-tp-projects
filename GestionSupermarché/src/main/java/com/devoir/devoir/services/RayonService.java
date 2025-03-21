package com.devoir.devoir.services;

import com.devoir.devoir.entities.Employe;
import com.devoir.devoir.entities.Rayon;
import com.devoir.devoir.repositories.RayonRepository;
import com.devoir.devoir.repositories.TravaillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RayonService {

    @Autowired
    private RayonRepository rayonRepository;

    @Autowired
    private TravaillerRepository travaillerRepository;

    public List<Employe> findEmployesByRayonId(Integer rayonId) {
        return travaillerRepository.findEmployesByRayonId(rayonId);
    }

    public Integer findTotalHoursByRayonId(Integer rayonId) {
        return travaillerRepository.findTotalHoursByRayonId(rayonId);
    }

    public List<Employe> findAllEmployes() {
        return travaillerRepository.findAllEmployes();
    }
}