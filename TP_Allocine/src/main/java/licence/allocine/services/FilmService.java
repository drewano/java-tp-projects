package licence.allocine.services;

import licence.allocine.entities.Film;
import licence.allocine.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public void rateFilm(int codeFilm, int rating) {
        Optional<Film> filmOpt = filmRepository.findById(codeFilm);
        if (filmOpt.isPresent()) {
            Film film = filmOpt.get();
            film.setNbVotes(film.getNbVotes() + 1);
            film.setTotalVotes(film.getTotalVotes() + rating);
            filmRepository.save(film);
        }
    }
}
