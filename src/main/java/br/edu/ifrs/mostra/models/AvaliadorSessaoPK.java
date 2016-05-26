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
public class AvaliadorSessaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull(message = "fk_avaliador nao pode ser null na tabela AvaliadorSessao")
    @Column(name = "fk_avaliador")
    private int fkAvaliador;
    @Basic(optional = false)
    @NotNull(message = "fk_sessao  nao pode ser null na tabela AvaliadorSessao")
    @Column(name = "fk_sessao")
    private int fkSessao;

    public AvaliadorSessaoPK() {
    }

    public AvaliadorSessaoPK(int fkAvaliador, int fkSessao) {
        this.fkAvaliador = fkAvaliador;
        this.fkSessao = fkSessao;
    }

    public int getFkAvaliador() {
        return fkAvaliador;
    }

    public void setFkAvaliador(int fkAvaliador) {
        this.fkAvaliador = fkAvaliador;
    }

    public int getFkSessao() {
        return fkSessao;
    }

    public void setFkSessao(int fkSessao) {
        this.fkSessao = fkSessao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkAvaliador;
        hash += (int) fkSessao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliadorSessaoPK)) {
            return false;
        }
        AvaliadorSessaoPK other = (AvaliadorSessaoPK) object;
        if (this.fkAvaliador != other.fkAvaliador) {
            return false;
        }
        if (this.fkSessao != other.fkSessao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.AvaliadorSessaoPK[ fkAvaliador=" + fkAvaliador + ", fkSessao=" + fkSessao + " ]";
    }
    
}
