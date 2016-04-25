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
public class TrabalhoAutorCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_trabalho")
    private int fkTrabalho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_autor")
    private int fkAutor;

    public TrabalhoAutorCursoPK() {
    }

    public TrabalhoAutorCursoPK(int fkTrabalho, int fkAutor) {
        this.fkTrabalho = fkTrabalho;
        this.fkAutor = fkAutor;
    }

    public int getFkTrabalho() {
        return fkTrabalho;
    }

    public void setFkTrabalho(int fkTrabalho) {
        this.fkTrabalho = fkTrabalho;
    }

    public int getFkAutor() {
        return fkAutor;
    }

    public void setFkAutor(int fkAutor) {
        this.fkAutor = fkAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkTrabalho;
        hash += (int) fkAutor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabalhoAutorCursoPK)) {
            return false;
        }
        TrabalhoAutorCursoPK other = (TrabalhoAutorCursoPK) object;
        if (this.fkTrabalho != other.fkTrabalho) {
            return false;
        }
        if (this.fkAutor != other.fkAutor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.TrabalhoAutorCursoPK[ fkTrabalho=" + fkTrabalho + ", fkAutor=" + fkAutor + " ]";
    }
    
}
