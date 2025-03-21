package licence.gestionbourse.repositories;

import licence.gestionbourse.entities.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends JpaRepository<Trader,Integer>
{

}
