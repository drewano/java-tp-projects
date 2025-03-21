package licence.allocine.controllers;

import licence.allocine.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/{codeFilm}/rate")
    public void rateFilm(@PathVariable("codeFilm") int codeFilm, @RequestBody RatingRequest ratingRequest) {
        filmService.rateFilm(codeFilm, ratingRequest.getRating());
    }
}