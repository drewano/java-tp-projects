package licence.gestionbourse.repositories;

import licence.gestionbourse.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>
{

}
