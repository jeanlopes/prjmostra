/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "parecer_trabalho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParecerTrabalho.findAll", query = "SELECT p FROM ParecerTrabalho p"),
    @NamedQuery(name = "ParecerTrabalho.findBySeq", query = "SELECT p FROM ParecerTrabalho p WHERE p.parecerTrabalhoPK.seq = :seq"),
    @NamedQuery(name = "ParecerTrabalho.findByFkTrabalho", query = "SELECT p FROM ParecerTrabalho p WHERE p.parecerTrabalhoPK.fkTrabalho = :fkTrabalho"),
    @NamedQuery(name = "ParecerTrabalho.findByFkRevisor", query = "SELECT p FROM ParecerTrabalho p WHERE p.parecerTrabalhoPK.fkRevisor = :fkRevisor"),
    @NamedQuery(name = "ParecerTrabalho.findByDatahora", query = "SELECT p FROM ParecerTrabalho p WHERE p.datahora = :datahora"),
    @NamedQuery(name = "ParecerTrabalho.findByStatus", query = "SELECT p FROM ParecerTrabalho p WHERE p.status = :status"),
    @NamedQuery(name = "ParecerTrabalho.findByStatusIntroducao", query = "SELECT p FROM ParecerTrabalho p WHERE p.statusIntroducao = :statusIntroducao"),
    @NamedQuery(name = "ParecerTrabalho.findByStatusObjetivos", query = "SELECT p FROM ParecerTrabalho p WHERE p.statusObjetivos = :statusObjetivos"),
    @NamedQuery(name = "ParecerTrabalho.findByStatusMetodologia", query = "SELECT p FROM ParecerTrabalho p WHERE p.statusMetodologia = :statusMetodologia"),
    @NamedQuery(name = "ParecerTrabalho.findByStatusResultados", query = "SELECT p FROM ParecerTrabalho p WHERE p.statusResultados = :statusResultados"),
    @NamedQuery(name = "ParecerTrabalho.findByObservacoes", query = "SELECT p FROM ParecerTrabalho p WHERE p.observacoes = :observacoes"),
    @NamedQuery(name = "ParecerTrabalho.findByObservacoesInternas", query = "SELECT p FROM ParecerTrabalho p WHERE p.observacoesInternas = :observacoesInternas"),
    @NamedQuery(name = "ParecerTrabalho.findByAutorCiente", query = "SELECT p FROM ParecerTrabalho p WHERE p.autorCiente = :autorCiente"),
    @NamedQuery(name = "ParecerTrabalho.findByObsIntroducao", query = "SELECT p FROM ParecerTrabalho p WHERE p.obsIntroducao = :obsIntroducao"),
    @NamedQuery(name = "ParecerTrabalho.findByObsObjetivos", query = "SELECT p FROM ParecerTrabalho p WHERE p.obsObjetivos = :obsObjetivos"),
    @NamedQuery(name = "ParecerTrabalho.findByObsMetodologia", query = "SELECT p FROM ParecerTrabalho p WHERE p.obsMetodologia = :obsMetodologia"),
    @NamedQuery(name = "ParecerTrabalho.findByObsResultados", query = "SELECT p FROM ParecerTrabalho p WHERE p.obsResultados = :obsResultados")})
public class ParecerTrabalho implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParecerTrabalhoPK parecerTrabalhoPK;
    @Basic(optional = false)
    @NotNull(message = "datahora nao pode ser null na tabela ParecerTrabalho")
    @Column(name = "datahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser null na tabela ParecerTrabalho")
    @Column(name = "status")
    private int status;
    @Column(name = "status_introducao")
    private Integer statusIntroducao;
    @Column(name = "status_objetivos")
    private Integer statusObjetivos;
    @Column(name = "status_metodologia")
    private Integer statusMetodologia;
    @Column(name = "status_resultados")
    private Integer statusResultados;
    @Size(max = 255, message = "tamanho nao permitido para o campo observacoes na tabela parecer_trabalho")
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 255, message = "tamanho nao permitido para o campo observacoes_internas na tabela parecer_trabalho")
    @Column(name = "observacoes_internas")
    private String observacoesInternas;
    @Column(name = "autor_ciente")
    private Integer autorCiente;
    @Size(max = 255, message = "tamanho nao permitido para o campo obs_introducao na tabela parecer_trabalho")
    @Column(name = "obs_introducao")
    private String obsIntroducao;
    @Size(max = 255, message = "tamanho nao permitido para o campo obs_objetivos na tabela parecer_trabalho")
    @Column(name = "obs_objetivos")
    private String obsObjetivos;
    @Size(max = 255, message = "tamanho nao permitido para o campo obs_metodologia na tabela parecer_trabalho")
    @Column(name = "obs_metodologia")
    private String obsMetodologia;
    @Size(max = 255, message = "tamanho nao permitido para o campo obs_resultados na tabela parecer_trabalho")
    @Column(name = "obs_resultados")
    private String obsResultados;
    @JoinColumn(name = "fk_revisor", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Revisor revisor;
    @JoinColumn(name = "fk_trabalho", referencedColumnName = "id_trabalho", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabalho trabalho;

    public ParecerTrabalho() {
    }

    public ParecerTrabalho(ParecerTrabalhoPK parecerTrabalhoPK) {
        this.parecerTrabalhoPK = parecerTrabalhoPK;
    }

    public ParecerTrabalho(ParecerTrabalhoPK parecerTrabalhoPK, Date datahora, int status) {
        this.parecerTrabalhoPK = parecerTrabalhoPK;
        this.datahora = datahora;
        this.status = status;
    }

    public ParecerTrabalho(int seq, int fkTrabalho, int fkRevisor) {
        this.parecerTrabalhoPK = new ParecerTrabalhoPK(seq, fkTrabalho, fkRevisor);
    }

    public ParecerTrabalhoPK getParecerTrabalhoPK() {
        return parecerTrabalhoPK;
    }

    public void setParecerTrabalhoPK(ParecerTrabalhoPK parecerTrabalhoPK) {
        this.parecerTrabalhoPK = parecerTrabalhoPK;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getStatusIntroducao() {
        return statusIntroducao;
    }

    public void setStatusIntroducao(Integer statusIntroducao) {
        this.statusIntroducao = statusIntroducao;
    }

    public Integer getStatusObjetivos() {
        return statusObjetivos;
    }

    public void setStatusObjetivos(Integer statusObjetivos) {
        this.statusObjetivos = statusObjetivos;
    }

    public Integer getStatusMetodologia() {
        return statusMetodologia;
    }

    public void setStatusMetodologia(Integer statusMetodologia) {
        this.statusMetodologia = statusMetodologia;
    }

    public Integer getStatusResultados() {
        return statusResultados;
    }

    public void setStatusResultados(Integer statusResultados) {
        this.statusResultados = statusResultados;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoesInternas() {
        return observacoesInternas;
    }

    public void setObservacoesInternas(String observacoesInternas) {
        this.observacoesInternas = observacoesInternas;
    }

    public Integer getAutorCiente() {
        return autorCiente;
    }

    public void setAutorCiente(Integer autorCiente) {
        this.autorCiente = autorCiente;
    }

    public String getObsIntroducao() {
        return obsIntroducao;
    }

    public void setObsIntroducao(String obsIntroducao) {
        this.obsIntroducao = obsIntroducao;
    }

    public String getObsObjetivos() {
        return obsObjetivos;
    }

    public void setObsObjetivos(String obsObjetivos) {
        this.obsObjetivos = obsObjetivos;
    }

    public String getObsMetodologia() {
        return obsMetodologia;
    }

    public void setObsMetodologia(String obsMetodologia) {
        this.obsMetodologia = obsMetodologia;
    }

    public String getObsResultados() {
        return obsResultados;
    }

    public void setObsResultados(String obsResultados) {
        this.obsResultados = obsResultados;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parecerTrabalhoPK != null ? parecerTrabalhoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParecerTrabalho)) {
            return false;
        }
        ParecerTrabalho other = (ParecerTrabalho) object;
        if ((this.parecerTrabalhoPK == null && other.parecerTrabalhoPK != null) || (this.parecerTrabalhoPK != null && !this.parecerTrabalhoPK.equals(other.parecerTrabalhoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.ParecerTrabalho[ parecerTrabalhoPK=" + parecerTrabalhoPK + " ]";
    }
    
}
