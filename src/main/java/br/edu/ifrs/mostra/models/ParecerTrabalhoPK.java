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
public class ParecerTrabalhoPK implements Serializable {

    @Basic(optional = false)
    @NotNull(message = "seq nao pode ser null na tabela Parecer_trabalho")
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull(message = "fk_trabalho nao pode ser null na tabela parecer_trabalho")
    @Column(name = "fk_trabalho")
    private int fkTrabalho;
    @Basic(optional = false)
    @NotNull(message = "fk_revisor nao pode ser null na tabela parecer_trabalho")
    @Column(name = "fk_revisor")
    private int fkRevisor;

    public ParecerTrabalhoPK() {
    }

    public ParecerTrabalhoPK(int seq, int fkTrabalho, int fkRevisor) {
        this.seq = seq;
        this.fkTrabalho = fkTrabalho;
        this.fkRevisor = fkRevisor;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getFkTrabalho() {
        return fkTrabalho;
    }

    public void setFkTrabalho(int fkTrabalho) {
        this.fkTrabalho = fkTrabalho;
    }

    public int getFkRevisor() {
        return fkRevisor;
    }

    public void setFkRevisor(int fkRevisor) {
        this.fkRevisor = fkRevisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) seq;
        hash += (int) fkTrabalho;
        hash += (int) fkRevisor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParecerTrabalhoPK)) {
            return false;
        }
        ParecerTrabalhoPK other = (ParecerTrabalhoPK) object;
        if (this.seq != other.seq) {
            return false;
        }
        if (this.fkTrabalho != other.fkTrabalho) {
            return false;
        }
        if (this.fkRevisor != other.fkRevisor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.ParecerTrabalhoPK[ seq=" + seq + ", fkTrabalho=" + fkTrabalho + ", fkRevisor=" + fkRevisor + " ]";
    }
    
}
