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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByFkUsuario", query = "SELECT a FROM Autor a WHERE a.fkUsuario = :fkUsuario")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private List<AutorCurso> autorCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private List<TrabalhoAutorCurso> trabalhoAutorCursoList;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Autor() {
    }

    public Autor(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @XmlTransient
    public List<AutorCurso> getAutorCursoList() {
        return autorCursoList;
    }

    public void setAutorCursoList(List<AutorCurso> autorCursoList) {
        this.autorCursoList = autorCursoList;
    }

    @XmlTransient
    public List<TrabalhoAutorCurso> getTrabalhoAutorCursoList() {
        return trabalhoAutorCursoList;
    }

    public void setTrabalhoAutorCursoList(List<TrabalhoAutorCurso> trabalhoAutorCursoList) {
        this.trabalhoAutorCursoList = trabalhoAutorCursoList;
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
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Autor[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
