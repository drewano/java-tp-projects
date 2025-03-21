package licence.partiel20242025.services;

import licence.partiel20242025.entities.Commande;
import licence.partiel20242025.entities.Client;
import licence.partiel20242025.entities.Lignescommande;
import licence.partiel20242025.entities.LignescommandeId;
import licence.partiel20242025.entities.Livreur;
import licence.partiel20242025.entities.Pizza;
import licence.partiel20242025.repositories.CommandeRepository;
import licence.partiel20242025.repositories.LignesDeCommandeRepository;
import licence.partiel20242025.repositories.ClientRepository;
import licence.partiel20242025.repositories.LivreurRepository;
import licence.partiel20242025.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LignesDeCommandeRepository lignesDeCommandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LivreurRepository livreurRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    public Integer getNextCommandeNumber() {
        Integer maxId = commandeRepository.findMaxId();
        return (maxId == null ? 1 : maxId + 1);
    }

    public void createCommande(Integer clientId, Integer livreurId, Map<String, Integer> pizzaQuantities) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new RuntimeException("Livreur non trouvé"));

        Commande commande = new Commande();
        commande.setId(getNextCommandeNumber());
        commande.setNumCli(client);
        commande.setNumLiv(livreur);
        commandeRepository.save(commande);

        for (Map.Entry<String, Integer> entry : pizzaQuantities.entrySet()) {
            String pizzaId = entry.getKey();
            Integer qty = entry.getValue();
            if (qty != null && qty > 0) {
                Pizza pizza = pizzaRepository.findById(pizzaId)
                        .orElseThrow(() -> new RuntimeException("Pizza non trouvée : " + pizzaId));
                Lignescommande ligne = new Lignescommande();
                LignescommandeId id = new LignescommandeId();
                id.setRefCde(commande.getId());
                id.setRefPizza(pizza.getNumPiz());
                ligne.setId(id);
                ligne.setRefCde(commande);
                ligne.setRefPizza(pizza);
                ligne.setQte(qty);
                lignesDeCommandeRepository.save(ligne);
            }
        }
    }
}
