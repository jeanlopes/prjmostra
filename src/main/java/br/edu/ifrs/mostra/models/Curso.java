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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Curso.findByFkCampus", query = "SELECT c FROM Curso c WHERE c.fkCampus = :fkCampus"),
    @NamedQuery(name = "Curso.findByNome", query = "SELECT c FROM Curso c WHERE c.nome = :nome"),
    @NamedQuery(name = "Curso.findByNivel", query = "SELECT c FROM Curso c WHERE c.nivel = :nivel")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "fk_campus")
    private Integer fkCampus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<AutorCurso> autorCursoList;
    @OneToMany(mappedBy = "fkCurso")
    private List<TrabalhoAutorCurso> trabalhoAutorCursoList;
    @OneToMany(mappedBy = "fkCurso")
    private List<Ouvinte> ouvinteList;
    @OneToMany(mappedBy = "fkCurso")
    private List<Voluntario> voluntarioList;

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Integer idCurso, String nome, int nivel) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.nivel = nivel;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getFkCampus() {
        return fkCampus;
    }

    public void setFkCampus(Integer fkCampus) {
        this.fkCampus = fkCampus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    @XmlTransient
    public List<Ouvinte> getOuvinteList() {
        return ouvinteList;
    }

    public void setOuvinteList(List<Ouvinte> ouvinteList) {
        this.ouvinteList = ouvinteList;
    }

    @XmlTransient
    public List<Voluntario> getVoluntarioList() {
        return voluntarioList;
    }

    public void setVoluntarioList(List<Voluntario> voluntarioList) {
        this.voluntarioList = voluntarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
