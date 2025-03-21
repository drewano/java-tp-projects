package licence.allocine.controllers;


import licence.allocine.entities.Cinema;
import licence.allocine.entities.Film;
import licence.allocine.services.CinemaService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CinemaController
{
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas")
    public String getLesCinemas(Model model)
    {
        List<Cinema> lesCinemas = cinemaService.getAllCinemas();
        model.addAttribute("cinemas", lesCinemas);
        return "index";
    }

    @GetMapping("/cinema/{codeCinema}/films")
    @ResponseBody
    public List<Film> getAllFilmsByCinema(@PathVariable("codeCinema") String codeCinema)
    {
        return cinemaService.getFilmsByCodeCine(codeCinema);
    }

}
