package licence.partiel20242025.controllers;

import licence.partiel20242025.entities.Client;
import licence.partiel20242025.entities.Livreur;
import licence.partiel20242025.entities.Pizza;
import licence.partiel20242025.services.ClientService;
import licence.partiel20242025.services.CommandeService;
import licence.partiel20242025.services.LivreurService;
import licence.partiel20242025.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PizzeriaController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private LivreurService livreurService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/")
    public String index(Model model) {
        List<Client> clients = clientService.getAllClients();
        List<Livreur> livreurs = livreurService.getAllLivreurs();
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        Integer nextCommande = commandeService.getNextCommandeNumber();

        model.addAttribute("clients", clients);
        model.addAttribute("livreurs", livreurs);
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("nextCommande", nextCommande);

        if(!clients.isEmpty()){
            model.addAttribute("defaultClientId", clients.get(0).getId());
        }
        if(!livreurs.isEmpty()){
            model.addAttribute("defaultLivreurId", livreurs.get(0).getId());
        }

        return "index";
    }

    @PostMapping("/order")
    public String submitOrder(@RequestParam("clientSelect") Integer clientId,
                              @RequestParam("livreurSelect") Integer livreurId,
                              @RequestParam Map<String, String> requestParams,
                              RedirectAttributes redirectAttributes) {

        Map<String, Integer> pizzaQuantities = new HashMap<>();
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("quantity_")) {
                String pizzaId = key.substring("quantity_".length());
                try {
                    Integer qty = Integer.parseInt(entry.getValue());
                    pizzaQuantities.put(pizzaId, qty);
                } catch (NumberFormatException e) {
                }
            }
        }

        commandeService.createCommande(clientId, livreurId, pizzaQuantities);

        redirectAttributes.addFlashAttribute("message", "Commande enregistrée !");
        return "redirect:/";
    }
}
