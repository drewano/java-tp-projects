package licence.allocine.services;


import licence.allocine.entities.Cinema;
import licence.allocine.entities.Film;
import licence.allocine.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService
{
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas()
    {
        return cinemaRepository.findAll();
    }

    public List<Film> getFilmsByCodeCine(String codeCine)
    {
        return cinemaRepository.findById(codeCine).get().getFilms().stream().toList();
    }

}
