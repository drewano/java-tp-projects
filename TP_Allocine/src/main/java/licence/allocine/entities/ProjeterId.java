package licence.allocine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjeterId implements Serializable {
    private static final long serialVersionUID = -1008146417045195037L;
    @Column(name = "numCinema", nullable = false, length = 10)
    private String numCinema;

    @Column(name = "numFilm", nullable = false, length = 10)
    private String numFilm;

    public String getNumCinema() {
        return numCinema;
    }

    public void setNumCinema(String numCinema) {
        this.numCinema = numCinema;
    }

    public String getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(String numFilm) {
        this.numFilm = numFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProjeterId entity = (ProjeterId) o;
        return Objects.equals(this.numCinema, entity.numCinema) &&
                Objects.equals(this.numFilm, entity.numFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCinema, numFilm);
    }

}