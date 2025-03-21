package licence.gestionbourse.controllers;

import licence.gestionbourse.dto.ActionDto;
import licence.gestionbourse.entities.Acheter;
import licence.gestionbourse.entities.AcheterId;
import licence.gestionbourse.entities.Action;
import licence.gestionbourse.entities.Trader;
import licence.gestionbourse.repositories.AcheterRepository;
import licence.gestionbourse.repositories.ActionRepository;
import licence.gestionbourse.repositories.TraderRepository;
import licence.gestionbourse.services.AcheterService;
import licence.gestionbourse.services.ActionService;
import licence.gestionbourse.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AcheterController {

    @Autowired
    private AcheterRepository acheterRepository;

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private TraderRepository traderRepository;

    @GetMapping("/traders/{traderId}/actions/{actionId}/vendre")
    public String vendreActionForm(@PathVariable("traderId") Integer traderId,
                                   @PathVariable("actionId") Integer actionId,
                                   Model model) {
        Acheter acheter = acheterRepository.findByNumTraderIdAndNumActionId(traderId, actionId);
        if (acheter == null) {
            return "redirect:/traders/" + traderId + "/actions";
        }

        ActionDto actionDto = new ActionDto(
                acheter.getNumAction().getId(),
                acheter.getNumAction().getNomAction(),
                acheter.getQuantite(),
                acheter.getMontantAchat(),
                traderId
        );
        model.addAttribute("actionDto", actionDto);
        return "vendreAction";
    }

    @PostMapping("/traders/{traderId}/actions/{actionId}/vendre")
    public String vendreAction(@PathVariable("traderId") Integer traderId,
                               @PathVariable("actionId") Integer actionId,
                               @ModelAttribute("actionDto") ActionDto actionDto,
                               Model model) {
        Acheter acheter = acheterRepository.findByNumTraderIdAndNumActionId(traderId, actionId);
        if (acheter == null) {
            return "redirect:/traders/" + traderId + "/actions";
        }

        int quantitePossedee = actionDto.getQuantite();
        int quantiteAVendre = actionDto.getQuantiteAVendre();

        if (quantiteAVendre > quantitePossedee) {
            model.addAttribute("error", "Quantité à vendre supérieure à la quantité possédée.");
            model.addAttribute("actionDto", actionDto);
            return "vendreAction";
        } else if (quantiteAVendre < quantitePossedee) {
            acheter.setQuantite(quantitePossedee - quantiteAVendre);
            acheterRepository.save(acheter);
        } else {
            acheterRepository.delete(acheter);
        }
        return "redirect:/traders/" + traderId + "/actions";
    }

    @GetMapping("/traders/{traderId}/actions/{actionId}/acheter")
    public String acheterActionForm(@PathVariable("traderId") Integer traderId,
                                    @PathVariable("actionId") Integer actionId,
                                    Model model) {
        Action action = actionRepository.findById(actionId).orElse(null);
        if (action == null) {
            return "redirect:/traders/" + traderId + "/actionsNotIn";
        }

        ActionDto actionDto = new ActionDto(
                action.getId(),
                action.getNomAction(),
                0,
                0.0,
                traderId
        );
        model.addAttribute("actionDto", actionDto);
        return "acheterAction";
    }

    @PostMapping("/traders/{traderId}/actions/{actionId}/acheter")
    public String acheterAction(@PathVariable("traderId") Integer traderId,
                                @PathVariable("actionId") Integer actionId,
                                @ModelAttribute("actionDto") ActionDto actionDto,
                                Model model) {
        Optional<Action> actionOpt = actionRepository.findById(actionId);
        Optional<Trader> traderOpt = traderRepository.findById(traderId);

        if (!actionOpt.isPresent() || !traderOpt.isPresent()) {
            return "redirect:/traders/" + traderId + "/actionsNotIn";
        }

        Action action = actionOpt.get();
        Trader trader = traderOpt.get();

        Acheter acheter = new Acheter();
        AcheterId acheterId = new AcheterId();
        acheterId.setNumAction(actionDto.getId()); // Utilise l'ID de actionDto
        acheterId.setNumTrader(actionDto.getNumTrader()); // Utilise le numTrader de actionDto
        acheter.setId(acheterId);
        acheter.setNumAction(action);
        acheter.setNumTrader(trader);
        acheter.setQuantite(actionDto.getQuantite());
        acheter.setMontantAchat(actionDto.getPrix());
        acheterRepository.save(acheter);

        return "redirect:/traders/" + traderId + "/actionsNotIn";
    }
}
