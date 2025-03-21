package licence.allocine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JouerId implements Serializable {
    private static final long serialVersionUID = 2608912244801872642L;
    @Column(name = "numFilm", nullable = false, length = 10)
    private String numFilm;

    @Column(name = "numActeur", nullable = false, length = 10)
    private String numActeur;

    public String getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(String numFilm) {
        this.numFilm = numFilm;
    }

    public String getNumActeur() {
        return numActeur;
    }

    public void setNumActeur(String numActeur) {
        this.numActeur = numActeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JouerId entity = (JouerId) o;
        return Objects.equals(this.numActeur, entity.numActeur) &&
                Objects.equals(this.numFilm, entity.numFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numActeur, numFilm);
    }

}