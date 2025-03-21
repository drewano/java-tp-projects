// SecteurController.java
package com.devoir.devoir.controllers;

import com.devoir.devoir.entities.Rayon;
import com.devoir.devoir.services.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecteurController {
    @Autowired
    private SecteurService secteurService;

    @GetMapping("/secteur")
    public String listerSecteur(Model model) {
        model.addAttribute("secteurs", secteurService.findAll());
        return "index";
    }

    @GetMapping("/secteur/{numS}/rayon")
    @ResponseBody
    public List<Rayon> getRayonBySecteur(@PathVariable("numS") Integer numS) {
        return secteurService.findRayonsBySecteurId(numS);
    }
}