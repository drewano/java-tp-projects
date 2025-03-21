package com.devoir.devoir.repositories;

import com.devoir.devoir.entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RayonRepository extends JpaRepository<Rayon, Integer>
{
    @Override
    Optional<Rayon> findById(Integer integer);

    @Override
    <S extends Rayon> S saveAndFlush(S entity);
}
