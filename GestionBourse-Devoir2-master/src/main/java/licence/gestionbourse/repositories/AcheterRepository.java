package licence.gestionbourse.repositories;

import licence.gestionbourse.entities.Acheter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcheterRepository extends JpaRepository<Acheter, Integer>
{
    List<Acheter> findByNumTraderId(Integer traderId);
    Acheter findByNumTraderIdAndNumActionId(Integer traderId, Integer actionId);
}
