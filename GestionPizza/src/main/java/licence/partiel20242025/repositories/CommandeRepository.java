package licence.partiel20242025.repositories;

import licence.partiel20242025.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    @Query("SELECT COALESCE(MAX(c.id), 0) FROM Commande c")
    Integer findMaxId();
}
