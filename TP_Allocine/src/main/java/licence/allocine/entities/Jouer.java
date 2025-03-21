package licence.allocine.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jouer")
public class Jouer {
    @EmbeddedId
    private JouerId id;

    @MapsId("numFilm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numFilm", nullable = false)
    private Film numFilm;

    @MapsId("numActeur")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numActeur", nullable = false)
    private Acteur numActeur;

    public JouerId getId() {
        return id;
    }

    public void setId(JouerId id) {
        this.id = id;
    }

    public Film getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(Film numFilm) {
        this.numFilm = numFilm;
    }

    public Acteur getNumActeur() {
        return numActeur;
    }

    public void setNumActeur(Acteur numActeur) {
        this.numActeur = numActeur;
    }

}