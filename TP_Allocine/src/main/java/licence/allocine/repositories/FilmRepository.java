package licence.allocine.repositories;

import licence.allocine.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Override
    List<Film> findAll();

    @Override
    Film getOne(Integer integer);

}