/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "organizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizador.findAll", query = "SELECT o FROM Organizador o"),
    @NamedQuery(name = "Organizador.findByFkUsuario", query = "SELECT o FROM Organizador o WHERE o.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "Organizador.findByNivel", query = "SELECT o FROM Organizador o WHERE o.nivel = :nivel"),
    @NamedQuery(name = "Organizador.findByStatus", query = "SELECT o FROM Organizador o WHERE o.status = :status")})
public class Organizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "fk_usuario nao pode ser null na tabela organizador")
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @Basic(optional = false)
    @NotNull(message = "nivel nao pode ser null na tabela organizador")
    @Column(name = "nivel")
    private int nivel;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser null na tabela organizador")
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Organizador() {
    }

    public Organizador(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Organizador(Integer fkUsuario, int nivel, int status) {
        this.fkUsuario = fkUsuario;
        this.nivel = nivel;
        this.status = status;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Organizador)) {
            return false;
        }
        Organizador other = (Organizador) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Organizador[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
