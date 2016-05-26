/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "avaliador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliador.findAll", query = "SELECT a FROM Avaliador a"),
    @NamedQuery(name = "Avaliador.findByFkUsuario", query = "SELECT a FROM Avaliador a WHERE a.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "Avaliador.findByTipoServidor", query = "SELECT a FROM Avaliador a WHERE a.tipoServidor = :tipoServidor"),
    @NamedQuery(name = "Avaliador.findByFormacao", query = "SELECT a FROM Avaliador a WHERE a.formacao = :formacao"),
    @NamedQuery(name = "Avaliador.findByStatus", query = "SELECT a FROM Avaliador a WHERE a.status = :status")})
public class Avaliador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "fk_usuario nao pode ser nulo na tabela avaliador")
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @Basic(optional = false)
    @NotNull(message = "tipo_servidor nao pode ser nulo na tabela avaliador")
    @Column(name = "tipo_servidor")
    private int tipoServidor;
    @Basic(optional = false)
    @NotNull(message = "formacao nao pode ser nulo na tabela avaliador")
    @Column(name = "formacao")
    private int formacao;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser nulo na tabela avaliador")
    @Column(name = "status")
    private int status;
    @ManyToMany(mappedBy = "avaliadorList")
    private List<Area> areaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliador")
    private List<AvaliadorSessao> avaliadorSessaoList;
    @JoinColumn(name = "fk_campus", referencedColumnName = "id_campus")
    @ManyToOne
    private Campus fkCampus;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Avaliador() {
    }

    public Avaliador(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Avaliador(Integer fkUsuario, int tipoServidor, int formacao, int status) {
        this.fkUsuario = fkUsuario;
        this.tipoServidor = tipoServidor;
        this.formacao = formacao;
        this.status = status;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getTipoServidor() {
        return tipoServidor;
    }

    public void setTipoServidor(int tipoServidor) {
        this.tipoServidor = tipoServidor;
    }

    public int getFormacao() {
        return formacao;
    }

    public void setFormacao(int formacao) {
        this.formacao = formacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<AvaliadorSessao> getAvaliadorSessaoList() {
        return avaliadorSessaoList;
    }

    public void setAvaliadorSessaoList(List<AvaliadorSessao> avaliadorSessaoList) {
        this.avaliadorSessaoList = avaliadorSessaoList;
    }

    public Campus getFkCampus() {
        return fkCampus;
    }

    public void setFkCampus(Campus fkCampus) {
        this.fkCampus = fkCampus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fkUsuario != null ? fkUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliador)) {
            return false;
        }
        Avaliador other = (Avaliador) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Avaliador[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
