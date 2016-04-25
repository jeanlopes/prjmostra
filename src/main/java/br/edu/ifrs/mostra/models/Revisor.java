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
@Table(name = "revisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revisor.findAll", query = "SELECT r FROM Revisor r"),
    @NamedQuery(name = "Revisor.findByFkUsuario", query = "SELECT r FROM Revisor r WHERE r.fkUsuario = :fkUsuario")})
public class Revisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @JoinColumn(name = "fk_campus", referencedColumnName = "id_campus")
    @ManyToOne
    private Campus fkCampus;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revisor")
    private List<ParecerTrabalho> parecerTrabalhoList;

    public Revisor() {
    }

    public Revisor(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
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

    @XmlTransient
    public List<ParecerTrabalho> getParecerTrabalhoList() {
        return parecerTrabalhoList;
    }

    public void setParecerTrabalhoList(List<ParecerTrabalho> parecerTrabalhoList) {
        this.parecerTrabalhoList = parecerTrabalhoList;
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
        if (!(object instanceof Revisor)) {
            return false;
        }
        Revisor other = (Revisor) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Revisor[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
