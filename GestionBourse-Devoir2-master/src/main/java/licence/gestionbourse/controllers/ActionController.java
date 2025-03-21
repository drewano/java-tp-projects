package licence.gestionbourse.controllers;

import licence.gestionbourse.dto.ActionDto;
import licence.gestionbourse.entities.Acheter;
import licence.gestionbourse.entities.Action;
import licence.gestionbourse.repositories.AcheterRepository;
import licence.gestionbourse.repositories.ActionRepository;
import licence.gestionbourse.repositories.TraderRepository;
import licence.gestionbourse.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private AcheterRepository acheterRepository;

    @GetMapping("/traders/{id}/actions")
    public String listActions(@PathVariable("id") Integer traderId, Model model) {
        List<Acheter> achats = acheterRepository.findByNumTraderId(traderId);
        List<ActionDto> actionsDto = new ArrayList<>();

        for (Acheter achat : achats) {
            ActionDto dto = new ActionDto(
                    achat.getNumAction().getId(),
                    achat.getNumAction().getNomAction(),
                    achat.getQuantite(),
                    achat.getMontantAchat(),
                    traderId
            );
            actionsDto.add(dto);
        }

        model.addAttribute("actions", actionsDto);
        model.addAttribute("traderId", traderId);
        return "actions";
    }

    @GetMapping("/traders/{id}/actionsNotIn")
    public String listActionsNotIn(@PathVariable("id") Integer traderId, Model model) {
        List<Action> allActions = actionRepository.findAll();
        List<Acheter> achats = acheterRepository.findByNumTraderId(traderId);
        List<Action> ownedActions = new ArrayList<>();
        for (Acheter achat : achats) {
            ownedActions.add(achat.getNumAction());
        }

        allActions.removeAll(ownedActions);
        model.addAttribute("actions", allActions);
        model.addAttribute("traderId", traderId);
        return "actionsNotIn";
    }
}
