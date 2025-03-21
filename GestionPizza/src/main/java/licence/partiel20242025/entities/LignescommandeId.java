package licence.partiel20242025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LignescommandeId implements Serializable {
    private static final long serialVersionUID = -2141279530077539969L;
    @Column(name = "refCde", nullable = false)
    private Integer refCde;

    @Column(name = "refPizza", nullable = false, length = 4)
    private String refPizza;

    public Integer getRefCde() {
        return refCde;
    }

    public void setRefCde(Integer refCde) {
        this.refCde = refCde;
    }

    public String getRefPizza() {
        return refPizza;
    }

    public void setRefPizza(String refPizza) {
        this.refPizza = refPizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LignescommandeId entity = (LignescommandeId) o;
        return Objects.equals(this.refCde, entity.refCde) &&
                Objects.equals(this.refPizza, entity.refPizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refCde, refPizza);
    }
}
