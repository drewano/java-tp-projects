package com.devoir.devoir.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TravaillerId implements Serializable {
    private static final long serialVersionUID = -2987701420689305276L;
    @Column(name = "codeE", nullable = false)
    private Integer codeE;

    @Column(name = "codeR", nullable = false)
    private Integer codeR;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Integer getCodeE() {
        return codeE;
    }

    public void setCodeE(Integer codeE) {
        this.codeE = codeE;
    }

    public Integer getCodeR() {
        return codeR;
    }

    public void setCodeR(Integer codeR) {
        this.codeR = codeR;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TravaillerId entity = (TravaillerId) o;
        return Objects.equals(this.date, entity.date) &&
                Objects.equals(this.codeR, entity.codeR) &&
                Objects.equals(this.codeE, entity.codeE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, codeR, codeE);
    }

}