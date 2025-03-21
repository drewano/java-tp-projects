package com.devoir.devoir.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rayon")
public class Rayon {
    @Id
    @Column(name = "numR", nullable = false)
    private Integer id;

    @Column(name = "nomR", nullable = false, length = 20)
    private String nomR;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numSecteur", nullable = false)
    private Secteur numSecteur;

    @OneToMany(mappedBy = "codeR")
    @JsonManagedReference
    private Set<Travailler> travaillers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public Secteur getNumSecteur() {
        return numSecteur;
    }

    public void setNumSecteur(Secteur numSecteur) {
        this.numSecteur = numSecteur;
    }

    public Set<Travailler> getTravaillers() {
        return travaillers;
    }

    public void setTravaillers(Set<Travailler> travaillers) {
        this.travaillers = travaillers;
    }

}