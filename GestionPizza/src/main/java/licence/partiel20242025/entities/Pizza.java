package licence.partiel20242025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @Column(name = "numPiz", nullable = false, length = 4)
    private String numPiz;

    @Column(name = "nomPiz", nullable = false, length = 20)
    private String nomPiz;

    @Column(name = "nbPers", nullable = false)
    private Integer nbPers;

    @Column(name = "prix", nullable = false)
    private Integer prix;

    public String getNumPiz() {
        return numPiz;
    }

    public void setNumPiz(String numPiz) {
        this.numPiz = numPiz;
    }

    public String getNomPiz() {
        return nomPiz;
    }

    public void setNomPiz(String nomPiz) {
        this.nomPiz = nomPiz;
    }

    public Integer getNbPers() {
        return nbPers;
    }

    public void setNbPers(Integer nbPers) {
        this.nbPers = nbPers;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
