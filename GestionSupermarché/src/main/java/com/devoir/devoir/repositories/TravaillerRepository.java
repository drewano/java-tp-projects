package com.devoir.devoir.repositories;

import com.devoir.devoir.entities.Employe;
import com.devoir.devoir.entities.Travailler;
import com.devoir.devoir.entities.TravaillerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravaillerRepository extends JpaRepository<Travailler, TravaillerId> {

    @Query("SELECT t.codeE FROM Travailler t WHERE t.codeR.id = :rayonId")
    List<Employe> findEmployesByRayonId(Integer rayonId);

    @Query("SELECT SUM(t.temps) FROM Travailler t WHERE t.codeR.id = :rayonId")
    Integer findTotalHoursByRayonId(Integer rayonId);

    @Query("SELECT DISTINCT t.codeE FROM Travailler t")
    List<Employe> findAllEmployes();
}