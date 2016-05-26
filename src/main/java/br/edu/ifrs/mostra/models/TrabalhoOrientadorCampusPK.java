/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jean
 */
@Embeddable
public class TrabalhoOrientadorCampusPK implements Serializable {

    @Basic(optional = false)
    @NotNull(message = "fk_trabalho nao pode ser nulo na tabela trabalho_orientador_campus")
    @Column(name = "fk_trabalho")
    private int fkTrabalho;
    @Basic(optional = false)
    @NotNull(message = "fk_orientador nao pode ser nulo na tabela trabalho_orientador_campus")
    @Column(name = "fk_orientador")
    private int fkOrientador;
    @Basic(optional = false)
    @NotNull(message = "fk_campus nao pode ser nulo na tabela trabalho_orientador_campus")
    @Column(name = "fk_campus")
    private int fkCampus;

    public TrabalhoOrientadorCampusPK() {
    }

    public TrabalhoOrientadorCampusPK(int fkTrabalho, int fkOrientador, int fkCampus) {
        this.fkTrabalho = fkTrabalho;
        this.fkOrientador = fkOrientador;
        this.fkCampus = fkCampus;
    }

    public int getFkTrabalho() {
        return fkTrabalho;
    }

    public void setFkTrabalho(int fkTrabalho) {
        this.fkTrabalho = fkTrabalho;
    }

    public int getFkOrientador() {
        return fkOrientador;
    }

    public void setFkOrientador(int fkOrientador) {
        this.fkOrientador = fkOrientador;
    }

    public int getFkCampus() {
        return fkCampus;
    }

    public void setFkCampus(int fkCampus) {
        this.fkCampus = fkCampus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkTrabalho;
        hash += (int) fkOrientador;
        hash += (int) fkCampus;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabalhoOrientadorCampusPK)) {
            return false;
        }
        TrabalhoOrientadorCampusPK other = (TrabalhoOrientadorCampusPK) object;
        if (this.fkTrabalho != other.fkTrabalho) {
            return false;
        }
        if (this.fkOrientador != other.fkOrientador) {
            return false;
        }
        if (this.fkCampus != other.fkCampus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.TrabalhoOrientadorCampusPK[ fkTrabalho=" + fkTrabalho + ", fkOrientador=" + fkOrientador + ", fkCampus=" + fkCampus + " ]";
    }
    
}
