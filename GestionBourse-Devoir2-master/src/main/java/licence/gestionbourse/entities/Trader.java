package licence.gestionbourse.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trader")
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrader", nullable = false)
    private Integer id;

    @Column(name = "nomTrader", nullable = false, length = 50)
    private String nomTrader;

    @OneToMany(mappedBy = "numTrader")
    private Set<Acheter> acheters = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomTrader() {
        return nomTrader;
    }

    public void setNomTrader(String nomTrader) {
        this.nomTrader = nomTrader;
    }

    public Set<Acheter> getAcheters() {
        return acheters;
    }

    public void setAcheters(Set<Acheter> acheters) {
        this.acheters = acheters;
    }

}