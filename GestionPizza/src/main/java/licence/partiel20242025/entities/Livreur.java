package licence.partiel20242025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livreurs")
public class Livreur {
    @Id
    @Column(name = "numLiv", nullable = false)
    private Integer id;

    @Column(name = "nomLiv", nullable = false, length = 20)
    private String nomLiv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomLiv() {
        return nomLiv;
    }

    public void setNomLiv(String nomLiv) {
        this.nomLiv = nomLiv;
    }
}
