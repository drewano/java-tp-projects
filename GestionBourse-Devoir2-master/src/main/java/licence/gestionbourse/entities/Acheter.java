package licence.gestionbourse.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "acheter")
public class Acheter {
    @EmbeddedId
    private AcheterId id;

    @MapsId("numAction")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numAction", nullable = false)
    private Action numAction;

    @MapsId("numTrader")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numTrader", nullable = false)
    private Trader numTrader;

    @Column(name = "montantAchat", nullable = false)
    private Double montantAchat;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    public AcheterId getId() {
        return id;
    }

    public void setId(AcheterId id) {
        this.id = id;
    }

    public Action getNumAction() {
        return numAction;
    }

    public void setNumAction(Action numAction) {
        this.numAction = numAction;
    }

    public Trader getNumTrader() {
        return numTrader;
    }

    public void setNumTrader(Trader numTrader) {
        this.numTrader = numTrader;
    }

    public Double getMontantAchat() {
        return montantAchat;
    }

    public void setMontantAchat(Double montantAchat) {
        this.montantAchat = montantAchat;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

}