package licence.gestionbourse.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAction", nullable = false)
    private Integer id;

    @Column(name = "nomAction", nullable = false, length = 50)
    private String nomAction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

}