package licence.allocine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acteur")
public class Acteur {
    @Id
    @Column(name = "codeActeur", nullable = false, length = 10)
    private String codeActeur;

    @Column(name = "nomActeur", nullable = false, length = 50)
    private String nomActeur;

    @Column(name = "imageActeur", nullable = false, length = 100)
    private String imageActeur;

    public String getCodeActeur() {
        return codeActeur;
    }

    public void setCodeActeur(String codeActeur) {
        this.codeActeur = codeActeur;
    }

    public String getNomActeur() {
        return nomActeur;
    }

    public void setNomActeur(String nomActeur) {
        this.nomActeur = nomActeur;
    }

    public String getImageActeur() {
        return imageActeur;
    }

    public void setImageActeur(String imageActeur) {
        this.imageActeur = imageActeur;
    }

}