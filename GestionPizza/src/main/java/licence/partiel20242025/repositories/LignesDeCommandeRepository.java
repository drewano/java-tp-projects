package licence.partiel20242025.repositories;

import licence.partiel20242025.entities.Lignescommande;
import licence.partiel20242025.entities.LignescommandeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignesDeCommandeRepository extends JpaRepository<Lignescommande, LignescommandeId> {
}
