package licence.partiel20242025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lignescommandes")
public class Lignescommande {
    @EmbeddedId
    private LignescommandeId id;

    @MapsId("refCde")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "refCde", nullable = false)
    private Commande refCde;

    @MapsId("refPizza")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "refPizza", nullable = false)
    private Pizza refPizza;

    @Column(name = "qte", nullable = false)
    private Integer qte;

    public LignescommandeId getId() {
        return id;
    }

    public void setId(LignescommandeId id) {
        this.id = id;
    }

    public Commande getRefCde() {
        return refCde;
    }

    public void setRefCde(Commande refCde) {
        this.refCde = refCde;
    }

    public Pizza getRefPizza() {
        return refPizza;
    }

    public void setRefPizza(Pizza refPizza) {
        this.refPizza = refPizza;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
