package licence.allocine.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @Column(name = "codeCine", nullable = false, length = 10)
    private String codeCine;

    @Column(name = "nomCine", nullable = false, length = 30)
    private String nomCine;

    @Column(name = "adresseCine", nullable = false, length = 50)
    private String adresseCine;

    @Column(name = "codePostalCine", nullable = false, length = 5)
    private String codePostalCine;

    @Column(name = "villeCine", nullable = false, length = 20)
    private String villeCine;

    @Column(name = "latitudeCine", nullable = false)
    private Float latitudeCine;

    @Column(name = "longitudeCine", nullable = false)
    private Float longitudeCine;

    @Column(name = "imageCine", nullable = false, length = 100)
    private String imageCine;

    @ManyToMany
    @JoinTable(name = "projeter",
            joinColumns = @JoinColumn(name = "numCinema"),
            inverseJoinColumns = @JoinColumn(name = "numFilm"))
    private Set<Film> films = new LinkedHashSet<>();

    public String getCodeCine() {
        return codeCine;
    }

    public void setCodeCine(String codeCine) {
        this.codeCine = codeCine;
    }

    public String getNomCine() {
        return nomCine;
    }

    public void setNomCine(String nomCine) {
        this.nomCine = nomCine;
    }

    public String getAdresseCine() {
        return adresseCine;
    }

    public void setAdresseCine(String adresseCine) {
        this.adresseCine = adresseCine;
    }

    public String getCodePostalCine() {
        return codePostalCine;
    }

    public void setCodePostalCine(String codePostalCine) {
        this.codePostalCine = codePostalCine;
    }

    public String getVilleCine() {
        return villeCine;
    }

    public void setVilleCine(String villeCine) {
        this.villeCine = villeCine;
    }

    public Float getLatitudeCine() {
        return latitudeCine;
    }

    public void setLatitudeCine(Float latitudeCine) {
        this.latitudeCine = latitudeCine;
    }

    public Float getLongitudeCine() {
        return longitudeCine;
    }

    public void setLongitudeCine(Float longitudeCine) {
        this.longitudeCine = longitudeCine;
    }

    public String getImageCine() {
        return imageCine;
    }

    public void setImageCine(String imageCine) {
        this.imageCine = imageCine;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}