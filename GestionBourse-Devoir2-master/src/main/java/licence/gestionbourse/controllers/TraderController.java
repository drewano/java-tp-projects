package licence.gestionbourse.controllers;

import licence.gestionbourse.repositories.TraderRepository;
import licence.gestionbourse.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraderController {

    @Autowired
    private TraderRepository traderRepository;

    @GetMapping("/")
    public String listTraders(Model model) {
        model.addAttribute("traders", traderRepository.findAll());
        return "traders";
    }
}
