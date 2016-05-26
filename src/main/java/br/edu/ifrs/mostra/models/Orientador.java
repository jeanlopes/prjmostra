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
@Table(name = "orientador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orientador.findAll", query = "SELECT o FROM Orientador o"),
    @NamedQuery(name = "Orientador.findByFkUsuario", query = "SELECT o FROM Orientador o WHERE o.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "Orientador.findByTipoServidor", query = "SELECT o FROM Orientador o WHERE o.tipoServidor = :tipoServidor"),
    @NamedQuery(name = "Orientador.findByStatus", query = "SELECT o FROM Orientador o WHERE o.status = :status")})
public class Orientador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "fk_usuario nao pode ser null na tabela orientador")
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @Basic(optional = false)
    @NotNull(message = "tipo_servidor nao pode ser null na tabela orientador")
    @Column(name = "tipo_servidor")
    private int tipoServidor;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser null na tabela orientador")
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orientador")
    private List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orientador")
    private List<OrientadorCampus> orientadorCampusList;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Orientador() {
    }

    public Orientador(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Orientador(Integer fkUsuario, int tipoServidor, int status) {
        this.fkUsuario = fkUsuario;
        this.tipoServidor = tipoServidor;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<TrabalhoOrientadorCampus> getTrabalhoOrientadorCampusList() {
        return trabalhoOrientadorCampusList;
    }

    public void setTrabalhoOrientadorCampusList(List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList) {
        this.trabalhoOrientadorCampusList = trabalhoOrientadorCampusList;
    }

    @XmlTransient
    public List<OrientadorCampus> getOrientadorCampusList() {
        return orientadorCampusList;
    }

    public void setOrientadorCampusList(List<OrientadorCampus> orientadorCampusList) {
        this.orientadorCampusList = orientadorCampusList;
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
        if (!(object instanceof Orientador)) {
            return false;
        }
        Orientador other = (Orientador) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Orientador[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
