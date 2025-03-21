package licence.partiel20242025.services;

import licence.partiel20242025.entities.Livreur;
import licence.partiel20242025.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivreurService {
    @Autowired
    private LivreurRepository livreurRepository;

    public List<Livreur> getAllLivreurs() {
        return livreurRepository.findAll();
    }
}
