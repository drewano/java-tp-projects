package licence.partiel20242025.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @Column(name = "numCde", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numCli", nullable = false)
    private Client numCli;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numLiv", nullable = false)
    private Livreur numLiv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getNumCli() {
        return numCli;
    }

    public void setNumCli(Client numCli) {
        this.numCli = numCli;
    }

    public Livreur getNumLiv() {
        return numLiv;
    }

    public void setNumLiv(Livreur numLiv) {
        this.numLiv = numLiv;
    }
}
