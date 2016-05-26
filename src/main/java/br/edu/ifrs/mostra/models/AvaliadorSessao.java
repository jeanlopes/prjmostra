/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "avaliador_sessao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliadorSessao.findAll", query = "SELECT a FROM AvaliadorSessao a"),
    @NamedQuery(name = "AvaliadorSessao.findByFkAvaliador", query = "SELECT a FROM AvaliadorSessao a WHERE a.avaliadorSessaoPK.fkAvaliador = :fkAvaliador"),
    @NamedQuery(name = "AvaliadorSessao.findByFkSessao", query = "SELECT a FROM AvaliadorSessao a WHERE a.avaliadorSessaoPK.fkSessao = :fkSessao"),
    @NamedQuery(name = "AvaliadorSessao.findBySeq", query = "SELECT a FROM AvaliadorSessao a WHERE a.seq = :seq"),
    @NamedQuery(name = "AvaliadorSessao.findByStatus", query = "SELECT a FROM AvaliadorSessao a WHERE a.status = :status")})
public class AvaliadorSessao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliadorSessaoPK avaliadorSessaoPK;
    @Basic(optional = false)
    @NotNull(message = "seq nao pode ser null na tabela avaliadorSessao")
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser null na tabela avaliadorSessao")
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "fk_sessao", referencedColumnName = "id_sessao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sessao sessao;
    @JoinColumn(name = "fk_avaliador", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avaliador avaliador;

    public AvaliadorSessao() {
    }

    public AvaliadorSessao(AvaliadorSessaoPK avaliadorSessaoPK) {
        this.avaliadorSessaoPK = avaliadorSessaoPK;
    }

    public AvaliadorSessao(AvaliadorSessaoPK avaliadorSessaoPK, int seq, int status) {
        this.avaliadorSessaoPK = avaliadorSessaoPK;
        this.seq = seq;
        this.status = status;
    }

    public AvaliadorSessao(int fkAvaliador, int fkSessao) {
        this.avaliadorSessaoPK = new AvaliadorSessaoPK(fkAvaliador, fkSessao);
    }

    public AvaliadorSessaoPK getAvaliadorSessaoPK() {
        return avaliadorSessaoPK;
    }

    public void setAvaliadorSessaoPK(AvaliadorSessaoPK avaliadorSessaoPK) {
        this.avaliadorSessaoPK = avaliadorSessaoPK;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliadorSessaoPK != null ? avaliadorSessaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliadorSessao)) {
            return false;
        }
        AvaliadorSessao other = (AvaliadorSessao) object;
        if ((this.avaliadorSessaoPK == null && other.avaliadorSessaoPK != null) || (this.avaliadorSessaoPK != null && !this.avaliadorSessaoPK.equals(other.avaliadorSessaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.AvaliadorSessao[ avaliadorSessaoPK=" + avaliadorSessaoPK + " ]";
    }
    
}
