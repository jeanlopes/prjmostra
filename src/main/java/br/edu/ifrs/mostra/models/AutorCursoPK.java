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
public class AutorCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull(message = "fk_autor em AutorCurso nao pode ser null")
    @Column(name = "fk_autor")
    private int fkAutor;
    @Basic(optional = false)
    @NotNull(message = "fk_curso em AutorCurso nao pode ser null")
    @Column(name = "fk_curso")
    private int fkCurso;

    public AutorCursoPK() {
    }

    public AutorCursoPK(int fkAutor, int fkCurso) {
        this.fkAutor = fkAutor;
        this.fkCurso = fkCurso;
    }

    public int getFkAutor() {
        return fkAutor;
    }

    public void setFkAutor(int fkAutor) {
        this.fkAutor = fkAutor;
    }

    public int getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(int fkCurso) {
        this.fkCurso = fkCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkAutor;
        hash += (int) fkCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorCursoPK)) {
            return false;
        }
        AutorCursoPK other = (AutorCursoPK) object;
        if (this.fkAutor != other.fkAutor) {
            return false;
        }
        if (this.fkCurso != other.fkCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.AutorCursoPK[ fkAutor=" + fkAutor + ", fkCurso=" + fkCurso + " ]";
    }
    
}
