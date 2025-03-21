package licence.allocine.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "codeFilm", nullable = false, length = 10)
    private String codeFilm;

    @Column(name = "nomFilm", nullable = false, length = 100)
    private String nomFilm;

    @Column(name = "imageFilm", nullable = false, length = 150)
    private String imageFilm;

    @Column(name = "genreFilm", nullable = false, length = 50)
    private String genreFilm;

    @Column(name = "nbVotes", nullable = false)
    private Integer nbVotes;

    @Column(name = "totalVotes", nullable = false)
    private Float totalVotes;

    public String getCodeFilm() {
        return codeFilm;
    }

    public void setCodeFilm(String codeFilm) {
        this.codeFilm = codeFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public String getImageFilm() {
        return imageFilm;
    }

    public void setImageFilm(String imageFilm) {
        this.imageFilm = imageFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public Integer getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(Integer nbVotes) {
        this.nbVotes = nbVotes;
    }

    public Float getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Float totalVotes) {
        this.totalVotes = totalVotes;
    }

}