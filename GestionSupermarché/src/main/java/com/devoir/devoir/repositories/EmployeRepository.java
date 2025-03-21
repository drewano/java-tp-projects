package com.devoir.devoir.repositories;

import com.devoir.devoir.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer>
{
    @Override
    Optional<Employe> findById(Integer integer);

    @Override
    <S extends Employe> S saveAndFlush(S entity);
}
