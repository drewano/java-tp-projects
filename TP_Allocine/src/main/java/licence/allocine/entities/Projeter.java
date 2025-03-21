package licence.allocine.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "projeter")
public class Projeter {
    @EmbeddedId
    private ProjeterId id;

    @MapsId("numCinema")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numCinema", nullable = false)
    private Cinema numCinema;

    @MapsId("numFilm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numFilm", nullable = false)
    private Film numFilm;

    public ProjeterId getId() {
        return id;
    }

    public void setId(ProjeterId id) {
        this.id = id;
    }

    public Cinema getNumCinema() {
        return numCinema;
    }

    public void setNumCinema(Cinema numCinema) {
        this.numCinema = numCinema;
    }

    public Film getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(Film numFilm) {
        this.numFilm = numFilm;
    }

}