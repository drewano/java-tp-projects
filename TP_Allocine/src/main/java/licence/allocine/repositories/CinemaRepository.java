package licence.allocine.repositories;


import licence.allocine.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String>
{
    @Override
    List<Cinema> findAll();

    @Override
    Optional<Cinema> findById(String idCine);
}
